package com.example.phase2.Controllers;

import com.example.phase2.logic.transactionservice.TransactionService;
import com.example.phase2.models.Providers.ProviderFactory;
import com.example.phase2.models.Providers.ServiceProvider;
import com.example.phase2.models.Services.Donation;
import com.example.phase2.models.Services.Landline;
import com.example.phase2.models.Services.Service;
import com.example.phase2.models.Services.ServiceFactory;
import com.example.phase2.databases.DiscountData;
import com.example.phase2.databases.RefundRequestData;
import com.example.phase2.databases.TransactionData;
import com.example.phase2.databases.Userdata;
import com.example.phase2.logic.paymentservice.DiscountDecorator;
import com.example.phase2.logic.paymentservice.PaymentService;
import com.example.phase2.logic.adminservice.AdminService;
import com.example.phase2.logic.clientservice.ClientService;
import com.example.phase2.logic.refundservice.RefundService;
import com.example.phase2.models.discount.Discount;
import com.example.phase2.models.discount.OverallDiscount;
import com.example.phase2.models.discount.SpecificDiscount;
import com.example.phase2.models.paymentmethod.CreditCard;
import com.example.phase2.models.refundrequest.RefundRequest;
import com.example.phase2.models.transaction.AddToWalletTransaction;
import com.example.phase2.models.transaction.PaymentTransaction;
import com.example.phase2.models.transaction.RefundRequestTransaction;
import com.example.phase2.models.transaction.Transaction;
import com.example.phase2.models.user.Admin;
import com.example.phase2.models.user.Client;
import com.example.phase2.models.variables.AddToWalletVariable;
import com.example.phase2.models.variables.SignUpVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;


@RestController
public class UserController {
	private RefundRequestData refundRequestData;
	private TransactionData transactionData;
	private Userdata userdata;
	private DiscountData discountData;
	private RefundService refundService;
	private ClientService clientService;

	private AdminService adminService;
	private DiscountDecorator discountDecorator;
	PaymentService paymentService;
	Landline landline;
	Donation donation;
	TransactionService transactionService;
	UserController(RefundRequestData refundRequestData,Userdata userdata,TransactionData transactionData,DiscountData discountData,ClientService clientService,Landline landline,Donation donation){
		this.landline=landline;
		this.donation=donation;
		this.userdata=userdata;
		this.refundRequestData=refundRequestData;
		this.transactionData=transactionData;
		this.discountData=discountData;
		discountDecorator=new DiscountDecorator(discountData);
		this.clientService=new ClientService(refundRequestData,userdata);
		this.refundService=new RefundService(clientService,refundRequestData,userdata);
		this.adminService=new AdminService(refundRequestData,userdata);
		this.transactionService=new TransactionService(transactionData);
		this.paymentService=new PaymentService();
	}
	//client endpoints:
	@PostMapping(value="/Client/loginUser")
	public ResponseEntity<String> login(@RequestBody Client client) {
		if(clientService.checkCardinality(client)){
			Client user= (Client) userdata.matchUser(client);
			clientService.setActive(user);
			return ResponseEntity.ok(user.getName()+" is active now");
		}
		else{
			return ResponseEntity.ok("Invalid username or password\n"+"if you are new user POST this http request: http://localhost:8080/signUpUser");
		}
	}

	@PostMapping(value="/Client/signUpUser")
	public ResponseEntity<String> signUp(@RequestBody SignUpVariable signUpVariable) {
		CreditCard creditCard=new CreditCard();
		creditCard.setCreditCardId(signUpVariable.getCreditCardId());
		creditCard.setPassword(signUpVariable.getCreditCardPassword());
		userdata.addCreditCard(creditCard);
		Client client=new Client();
		client.setName(signUpVariable.getName());
		client.setPassword(signUpVariable.getPassword());
		client.setCreditCard(creditCard);
		clientService.registerClient(client);
		return ResponseEntity.ok("Added Successfully") ;
	}

	@PostMapping(value = "/Client/{clientId}/refund/{transactionID}")
	ResponseEntity<String> refund(@PathVariable int transactionID, @PathVariable int clientId){
		if(userdata.isActive(clientId,"client")) {
			PaymentTransaction transaction = (PaymentTransaction)transactionData.getTransaction(transactionID);
			RefundRequest refundRequest = new RefundRequest(transaction);
			refundService.subscribe(refundRequest);
			return ResponseEntity.ok("Refund Request is added to id: " + refundRequest.getId());
		}
		else {
			return ResponseEntity.ok("you must login");
		}
	}
	@PostMapping(value = "/Client/{clientId}/addToWallet")
	ResponseEntity<String> addToWallet(@RequestBody AddToWalletVariable addToWalletVariable, @PathVariable int clientId){
		CreditCard creditCard=new CreditCard();
		creditCard.setCreditCardId(addToWalletVariable.getCreditCardId());
		creditCard.setPassword(addToWalletVariable.getCreditCardPassword());
		AddToWalletTransaction addToWalletTransaction=new AddToWalletTransaction(creditCard ,addToWalletVariable.getAddedAmount()) ;
		//check valid creditCard
		if(userdata.validateCreditCard(addToWalletTransaction.getCreditCard())) {
			clientService.addToWallet(clientId, addToWalletTransaction.getAddedAmount());
			//add trans to transList
			transactionService.addTransaction(addToWalletTransaction);
			return ResponseEntity.ok("addedToWallet: " + addToWalletTransaction.getAddedAmount());
		}
		else{
			return ResponseEntity.ok("Invalid creditCard");
		}
	}
	@GetMapping(value = "/Client/{clientId}/checkRefundStatus/{refundId}")
	ResponseEntity<String> checkRefundStatus(@PathVariable int refundId, @PathVariable int clientId){
		if(userdata.isActive(clientId,"client")) {
			return ResponseEntity.ok("Status of Refund Request with id " + refundId + ": " + clientService.checkRefundStatus(refundId));
		}else {
			return ResponseEntity.ok("you must login");
		}
	}

	@GetMapping(value="/Client/{clientId}/searchForService/{s}")
	public  ResponseEntity<String> searchForService(@PathVariable int clientId, @PathVariable("s") String s) {
		ServiceFactory f=new ServiceFactory();
		if(f.createService(s)==null) {
			return ResponseEntity.ok("not found");
		}
		if(userdata.isActive(clientId,"client")) {
			return ResponseEntity.ok("found");
		}
		return ResponseEntity.ok("you must login");
	}
	@PostMapping(value = "/Client/{clientId}/paymentTransaction/internetPayment")
	public ResponseEntity<String> internetPayment(@RequestBody PaymentTransaction transaction,@PathVariable int clientId){
		// check if valid user
		if(!userdata.findById(clientId))
			return ResponseEntity.ok("User Not Found") ;
		// check if valid service
		Service service = ServiceFactory.createService(transaction.getService()) ;
		if(service==null)
			return ResponseEntity.ok("Service Not Valid") ;
		// check if valid provider
		ServiceProvider provider = ProviderFactory.getProvider(transaction.getServiceProvider()) ;
		if(provider==null)
			return ResponseEntity.ok("Provider Not Valid") ;
		// check if valid payment method
		if(!service.checkPaymentMethod(transaction.getMethod()))
			return ResponseEntity.ok("Payment Method Not Valid") ;
		// check if valid amount
		service.setProvider(provider) ;
		double requiredAmount;
		if(discountData.hasDiscount(transaction.getService())){
			requiredAmount=discountDecorator.pay(service);
		}
		else{
			requiredAmount=paymentService.pay(service);
		}
		if(transaction.getPaidAmount()<requiredAmount)
			return ResponseEntity.ok("Not Valid Amount") ;
		//provider.setCost(transaction.getPaidAmount());
		// set Provider(cost) & set Service(Provider)
		String paymentmethod=transaction.getMethod();
		Client client=(Client) userdata.getUser(clientId,"client");
		if(paymentmethod.equalsIgnoreCase("creditCard")){
			if(client.getCreditCard().getAmount()<requiredAmount){
				return ResponseEntity.ok("CreditCardAmount is not enough") ;
			}
			clientService.updateCreditCard(clientId,requiredAmount);
		} else if (paymentmethod.equalsIgnoreCase("wallet")) {
			if(client.getWallet().getAmount()<requiredAmount) {
				return ResponseEntity.ok("WalletAmount is not enough");
			}
			clientService.updateWallet(clientId,requiredAmount);
		}
		else if (paymentmethod.equalsIgnoreCase("cash")) {
			clientService.addToWallet(clientId,transaction.getPaidAmount()-requiredAmount);
		}
		transaction.setRequiredAmount(requiredAmount);
		transaction.setClientRestAmount(transaction.getPaidAmount()-requiredAmount);
		// finally add transaction to dataBase , and report success
		transactionService.addTransaction(transaction);
		return ResponseEntity.ok("transaction that has id "+transaction.getId() + " has done with paid amount: "+requiredAmount) ;
	}


	@PostMapping(value = "/Client/{clientId}/paymentTransaction/mobileRecharge")
	public ResponseEntity<String> mobileRecharge(@RequestBody PaymentTransaction transaction,@PathVariable int clientId){
		// check if valid user
		if(!userdata.findById(clientId))
			return ResponseEntity.ok("User Not Found") ;
		// check if valid service
		Service service = ServiceFactory.createService(transaction.getService()) ;
		if(service==null)
			return ResponseEntity.ok("Service Not Valid") ;
		// check if valid provider
		ServiceProvider provider = ProviderFactory.getProvider(transaction.getServiceProvider()) ;
		if(provider==null)
			return ResponseEntity.ok("Provider Not Valid") ;
		// check if valid payment method
		if(!service.checkPaymentMethod(transaction.getMethod()))
			return ResponseEntity.ok("Payment Method Not Valid") ;
		// check if valid amount
		service.setProvider(provider) ;
		double requiredAmount;
		if(discountData.hasDiscount(transaction.getService())){
			requiredAmount=discountDecorator.pay(service);
		}
		else{
			requiredAmount=paymentService.pay(service);
		}
		if(transaction.getPaidAmount()<requiredAmount)
			return ResponseEntity.ok("Not Valid Amount") ;
		//provider.setCost(transaction.getPaidAmount());
		// set Provider(cost) & set Service(Provider)
		String paymentmethod=transaction.getMethod();
		Client client=(Client) userdata.getUser(clientId,"client");
		if(paymentmethod.equalsIgnoreCase("creditCard")){
			if(client.getCreditCard().getAmount()<requiredAmount){
				return ResponseEntity.ok("CreditCardAmount is not enough") ;
			}
			clientService.updateCreditCard(clientId,requiredAmount);
		} else if (paymentmethod.equalsIgnoreCase("wallet")) {
			if(client.getWallet().getAmount()<requiredAmount) {
				return ResponseEntity.ok("WalletAmount is not enough");
			}
			clientService.updateWallet(clientId,requiredAmount);
		}
		else if (paymentmethod.equalsIgnoreCase("cash")) {
			clientService.addToWallet(clientId,transaction.getPaidAmount()-requiredAmount);
		}
		transaction.setRequiredAmount(requiredAmount);
		transaction.setClientRestAmount(transaction.getPaidAmount()-requiredAmount);
		// finally add transaction to dataBase , and report success
		transactionService.addTransaction(transaction);

		return ResponseEntity.ok("transaction that has id "+transaction.getId() + " has done with paid amount: "+requiredAmount) ;
	}


	@PostMapping(value = "/Client/{clientId}/paymentTransaction/landline")
	public ResponseEntity<String> payLandlinePlan(@RequestBody PaymentTransaction transaction,@PathVariable int clientId){
		transaction.setService("landline");
		// check if valid user
		if(!userdata.findById(clientId))
			return ResponseEntity.ok("User Not Found") ;
		String plan=transaction.getPlan();
		landline.setPlan(plan);
		double requiredAmount;
		if(discountData.hasDiscount("Landline")){
			requiredAmount=discountDecorator.pay(landline);
		}
		else{
			requiredAmount=paymentService.pay(landline);
		}
		if(transaction.getPaidAmount()<requiredAmount)
			return ResponseEntity.ok("Not Valid Amount") ;
		//provider.setCost(transaction.getPaidAmount());
		// set Provider(cost) & set Service(Provider)
		String paymentmethod=transaction.getMethod();
		Client client=(Client) userdata.getUser(clientId,"client");
		if(paymentmethod.equalsIgnoreCase("creditCard")){
			if(client.getCreditCard().getAmount()<requiredAmount){
				return ResponseEntity.ok("CreditCardAmount is not enough") ;
			}
			clientService.updateCreditCard(clientId,requiredAmount);
		} else if (paymentmethod.equalsIgnoreCase("wallet")) {
			if(client.getWallet().getAmount()<requiredAmount) {
				return ResponseEntity.ok("WalletAmount is not enough");
			}
			clientService.updateWallet(clientId,requiredAmount);
		}
		else if (paymentmethod.equalsIgnoreCase("cash")) {
			clientService.addToWallet(clientId,transaction.getPaidAmount()-requiredAmount);
		}
		transaction.setRequiredAmount(requiredAmount);
		transaction.setClientRestAmount(transaction.getPaidAmount()-requiredAmount);
		// finally add transaction to dataBase , and report success
		transactionService.addTransaction(transaction);
		return ResponseEntity.ok("transaction that has id "+transaction.getId() + " has done with paid amount: "+requiredAmount) ;
	}


	@PostMapping(value = "/Client/{clientId}/paymentTransaction/donation")
	public ResponseEntity<String> makeDonation(@RequestBody PaymentTransaction transaction,@PathVariable int clientId){
		transaction.setService("Donation");
		// check if valid user
		if(!userdata.findById(clientId))
			return ResponseEntity.ok("User Not Found") ;
		String donationProvider=transaction.getServiceProvider();

		donation.setDonationAmount(donationProvider,transaction.getPaidAmount());
		String paymentmethod=transaction.getMethod();
		Client client=(Client) userdata.getUser(clientId,"client");
		if(paymentmethod.equalsIgnoreCase("creditCard")){
			if(client.getCreditCard().getAmount()<transaction.getPaidAmount()){
				return ResponseEntity.ok("CreditCardAmount is not enough") ;
			}
			clientService.updateCreditCard(clientId,transaction.getPaidAmount());
		} else if (paymentmethod.equalsIgnoreCase("wallet")) {
			if(client.getWallet().getAmount()<transaction.getPaidAmount()) {
				return ResponseEntity.ok("WalletAmount is not enough");
			}
			clientService.updateWallet(clientId,transaction.getPaidAmount());
		}
		// finally add transaction to dataBase , and report success
		transactionService.addTransaction(transaction);
		return ResponseEntity.ok("transaction that has id "+transaction.getId() + " has done with paid amount: "+transaction.getPaidAmount()) ;
	}

	@GetMapping(value = "/Client/{clientId}/checkDiscount/{service}")
	ResponseEntity<LinkedList<Discount>> checkDiscount(@PathVariable int clientId, @PathVariable String service){
		LinkedList<Discount>list=discountData.searchForDiscounts(service);
		return ResponseEntity.ok(list);
	}

	//admin endpoints:
	@PostMapping(value="/Admin/loginUser")
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		if(adminService.checkCardinality(admin)) {
			Admin user= (Admin) userdata.matchUser(admin);
			adminService.setActive(user);
			return ResponseEntity.ok(user.getName() + " is active now");
		}
		else{
			return ResponseEntity.ok("Invalid username or password");
		}
	}

	@PostMapping(value = "/Admin/{adminId}/processRefund/{refundId}/{status}")
	ResponseEntity<String> processRefund(@PathVariable("refundId") int refundId, @PathVariable("status") String status, @PathVariable("adminId") int adminId){
		if(userdata.isActive(adminId,"admin")){
			adminService.processRefundRequests(refundId, status);
			refundService.notify(refundId);
			transactionService.addTransaction(new RefundRequestTransaction(refundRequestData.getRefundRequest(refundId)));
			return ResponseEntity.ok("status Added successfully");
		}
		else{
			return ResponseEntity.ok("you must login");
		}
	}
	@PostMapping(value = "/Admin/{adminId}/addSpecificDiscount/{service}/{discountValue}")
	ResponseEntity<String> addSpecificDiscount(@PathVariable int adminId, @PathVariable String service, @PathVariable Double discountValue){
		SpecificDiscount specificDiscount=new SpecificDiscount(service,discountValue);
		discountData.addDiscount(specificDiscount);
		return ResponseEntity.ok("Discount Added Successfully");
	}
	@PostMapping(value = "/Admin/{adminId}/addOverallDiscount/{discountValue}")
	ResponseEntity<String> addOverallDiscount(@PathVariable int adminId, @PathVariable Double discountValue){
		OverallDiscount overallDiscount=new OverallDiscount(discountValue);
		discountData.addDiscount(overallDiscount);
		return ResponseEntity.ok("Discount Added Successfully");
	}

	@GetMapping(value = "/Admin/{AdminId}/checkRefundRequests")
	ResponseEntity<LinkedList<RefundRequest>> checkRefundRequests(@PathVariable int AdminId){
		return ResponseEntity.ok(refundRequestData.getRefundRequests());
	}

	@GetMapping(value = "/Admin/{AdminId}/checkTransactions")
	ResponseEntity<LinkedList<Transaction>> checkTransactions(@PathVariable int AdminId){
		return ResponseEntity.ok(transactionData.getTransactions());
	}
}

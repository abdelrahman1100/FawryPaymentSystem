package com.example.phase2.User.Controllers;

import com.example.phase2.Providers.ProviderFactory;
import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.Services.Service;
import com.example.phase2.Services.ServiceFactory;
import com.example.phase2.User.RefundRequestData;
import com.example.phase2.User.TransactionData;
import com.example.phase2.User.Userdata.Userdata;
import com.example.phase2.User.bsl.adminservice.AdminService;
import com.example.phase2.User.bsl.clientservice.ClientService;
import com.example.phase2.User.bsl.refundservice.RefundService;
import com.example.phase2.User.models.Admin;
import com.example.phase2.User.models.Client;
import com.example.phase2.User.models.RefundRequest;
import com.example.phase2.User.models.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
	private RefundRequestData refundRequestData;
	private TransactionData transactionData;
	private Userdata userdata;
	private RefundService refundService;
	private ClientService clientService;

	private AdminService adminService;
	UserController(RefundRequestData refundRequestData,Userdata userdata,TransactionData transactionData,ClientService clientService){
		this.userdata=userdata;
		this.refundRequestData=refundRequestData;
		this.transactionData=transactionData;
		this.clientService=new ClientService(refundRequestData,userdata);
		this.refundService=new RefundService(clientService,refundRequestData,userdata);
		this.adminService=new AdminService(refundRequestData,userdata);
		//for test:
		Client client=new Client("ahmed","pass");
		userdata.addUser(client);
		transactionData.addTransaction(new Transaction(0,"mo","we","credit",10));
	}
	//client endpoints:
	@PostMapping(value="/Client/loginUser")
	public ResponseEntity<String> login(@RequestBody Client client) {
		if(clientService.checkCardinality(client)){
			clientService.setActive(client);
			return ResponseEntity.ok(client.getName()+" is active now");
		}
		else{
			return ResponseEntity.ok("Invalid username or password\n"+"if you are new user POST this http request: http://localhost:8080/signUpUser");
		}
	}

	@PostMapping(value="/Client/signUpUser")
	public ResponseEntity<String> signUp(@RequestBody Client client) {
		clientService.registerClient(client);
		return ResponseEntity.ok("Added Successfully") ;
	}

	@PostMapping(value = "/Client/{clientId}/refund/{transactionID}")
	ResponseEntity<String> refund(@PathVariable int transactionID, @PathVariable int clientId){
		if(userdata.isActive(clientId,"client")) {
			Transaction transaction = transactionData.getTransaction(transactionID);
			RefundRequest refundRequest = new RefundRequest(transaction);
			refundService.subscribe(refundRequest);
			return ResponseEntity.ok("Refund Request is added to id: " + refundRequest.getId());
		}
		else {
			return ResponseEntity.ok("you must login");
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

	@PostMapping(value="/Client/{clientId}/searchforservice/{s}")
	public  ResponseEntity<String> searchforservice(@PathVariable int clientId, @PathVariable("s") String s) {
		ServiceFactory f=new ServiceFactory();
		if(f.createService(s)==null) {
			return ResponseEntity.ok("not found");
		}
		if(userdata.isActive(clientId,"client")) {
			userdata.getUser(clientId).setservice(s);
			return ResponseEntity.ok("found");
		}
		return ResponseEntity.ok("user not found");
	}
	@PostMapping(value = "/operation")
	public ResponseEntity<String> operate(@RequestBody Transaction transaction){
		// check if valid user
		if(!userdata.findById(transaction.getClientId()))
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
		if(transaction.getPaidAmount()<=0)
			return ResponseEntity.ok("Not Valid Amount") ;
		// set Provider(cost) & set Service(Provider)
		provider.setCost(transaction.getPaidAmount());
		service.setProvider(provider) ;
		// do service & provider should do anything else ?
		// update user wallet ?
		// finally add transaction to dataBase , and report success
		transactionData.addTransaction(transaction);
		return ResponseEntity.ok("operation done successfully") ;
	}
	// should we make an endpoint to let user put money in wallet through credit card ?
	//admin endpoints:
	@PostMapping(value="/Admin/loginUser")
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		if(adminService.checkCardinality(admin)) {
			adminService.setActive(admin);
			return ResponseEntity.ok(admin.getName() + " is active now");
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
			return ResponseEntity.ok("status Added successfully");
		}
		else{
			return ResponseEntity.ok("you must login");
		}
	}


}

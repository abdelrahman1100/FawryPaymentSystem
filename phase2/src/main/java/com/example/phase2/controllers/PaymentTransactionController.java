package com.example.phase2.controllers;


import com.example.phase2.services.*;
import com.example.phase2.services.donationservices.DonationService;
import com.example.phase2.services.internetservices.InternetPaymentService;
import com.example.phase2.services.landlineservices.LandlineService;
import com.example.phase2.services.mobileservices.MobileRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentTransactionController {
    @Autowired
    ClientService clientService;
    @Autowired
    MobileRechargeService mobileRechargeService;
    @Autowired
    InternetPaymentService internetPaymentService;
    @Autowired
    DonationService donationService;
    @Autowired
    LandlineService landlineService;
    @PostMapping("/api/client/{clientId}/mobile recharge/{provider}/{paymentMethod}/{amount}")
    ResponseEntity<String>mobileRecharge(@PathVariable int clientId,@PathVariable String provider,@PathVariable String paymentMethod,@PathVariable double amount){
        mobileRechargeService.makeTransaction(clientId,provider,paymentMethod,amount);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PostMapping("/api/client/{clientId}/internet payment/{provider}/{paymentMethod}/{amount}")
    ResponseEntity<String>internetPayment(@PathVariable int clientId,@PathVariable String provider,@PathVariable String paymentMethod,@PathVariable double amount){
        internetPaymentService.makeTransaction(clientId,provider,paymentMethod,amount);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PostMapping("/api/client/{clientId}/donation/{provider}/{paymentMethod}/{amount}")
    ResponseEntity<String>donate(@PathVariable int clientId,@PathVariable String provider,@PathVariable String paymentMethod,@PathVariable double amount){
        donationService.makeTransaction(clientId,provider,paymentMethod,amount);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PostMapping("/api/client/{clientId}/landline payment/{plan}/{paymentMethod}/{amount}")
    ResponseEntity<String>landlinePayment(@PathVariable int clientId,@PathVariable String plan,@PathVariable String paymentMethod,@PathVariable double amount){
        landlineService.makeTransaction(clientId,plan,paymentMethod,amount);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
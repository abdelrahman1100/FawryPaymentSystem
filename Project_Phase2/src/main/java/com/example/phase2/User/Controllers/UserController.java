package com.example.phase2.User.Controllers;

import com.example.phase2.User.bsl.AdminService;
import com.example.phase2.User.bsl.ClientService;
import com.example.phase2.User.models.Admin;
import com.example.phase2.User.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
public class UserController {
	private ClientService clientService;
	private AdminService adminService;
	UserController(){
		this.clientService=new ClientService();
		this.adminService=new AdminService();
	}
	//client endpoints:
	@PostMapping(value="/loginUser/Client")
	public ResponseEntity<String> login(@RequestBody Client client) {
		if(clientService.isExist(client)){
			clientService.setActive(client);
			return ResponseEntity.ok(client.getName()+" is active now");
		}
		else{
			return ResponseEntity.ok("Invalid username or password\n"+"if you are new user POST this http request: http://localhost:8080/signUpUser");
		}
	}

	@PostMapping(value="/signUpUser")
	public ResponseEntity<String> signUp(@RequestBody Client client) {
		clientService.registerClient(client);
		return ResponseEntity.ok("Added Successfully") ;
	}
	//admin endpoints:
	@PostMapping(value="/loginUser/Admin")
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		if(adminService.isExist(admin)) {
			adminService.setActive(admin);
			return ResponseEntity.ok(admin.getName() + " is active now");
		}
		else{
			return ResponseEntity.ok("Invalid username or password");
		}
	}

	//@PostMapping(value="/Admin/{name}/{service}/{serviceProvider}/{discount}")
}

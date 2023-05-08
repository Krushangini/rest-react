package com.example.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.model.LoanApplicationModel;
import com.example.loan.model.LoginModel;
import com.example.loan.model.UserModel;
import com.example.loan.serivce.UserService;



@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public String register(@RequestBody UserModel user) {
		return service.register(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginModel log) {
		return service.login(log);
	}

	@GetMapping("/get-user")
	public UserModel getuser(@RequestParam String email) {
		return service.getUser(email);
	
	}
	
	@GetMapping("/get-loan-details")
	public LoanApplicationModel getLoanDetails(@RequestParam String email) {
		return service.getDetails(email);
	}
	
	@PostMapping("/apply-loan")
	public LoanApplicationModel applyLoan(@RequestBody LoanApplicationModel loan) {
		return service.apply(loan);
	}
	
	@DeleteMapping("/delete-account")
	public void deleteAcc(@RequestParam String email) {
		 service.deleteAcc(email);
	}

}

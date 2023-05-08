package com.example.loan.serivce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.loan.model.LoanApplicationModel;
import com.example.loan.model.LoginModel;
import com.example.loan.model.UserModel;
import com.example.loan.repo.LoanApplicationRepo;
import com.example.loan.repo.UserLoginrepo;
import com.example.loan.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepo urepo;
	
	@Autowired
	UserLoginrepo ulrepo;
	
	@Autowired
	LoanApplicationRepo loanrepo;
	
	public String register(UserModel user) {
		UserModel check = urepo.save(user);
		String us = user.getEmail();
		String pass = user.getPassword();
		LoginModel log = new LoginModel();
		log.setEmail(us);
		log.setPassword(pass);
		ulrepo.save(log);
		if(check!=null) {
			return "registered Successfully";
		}
		return "registration failed";
	}
	
	public ResponseEntity<String> login(LoginModel log) {
		  String email = log.getEmail();
	        Optional<LoginModel> l = ulrepo.findById(email);
	        if (l.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	        LoginModel lo = l.get();
	        String pass = lo.getPassword();
	        if (pass.equals(log.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}
	
	public UserModel getUser(String email) {
		return urepo.findByEmail(email);
	}
	
	
	public LoanApplicationModel getDetails(String email) {
		return loanrepo.findByEmail(email);
	}
	
	public LoanApplicationModel apply(LoanApplicationModel loan) {
		return loanrepo.save(loan);
	}
	
	@Transactional
	public void deleteAcc(String email) {
		ulrepo.deleteByEmail(email);
	}
}

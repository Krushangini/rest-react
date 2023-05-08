package com.example.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loan.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{

	@Query("select s from UserModel s where s.email=?1")
	UserModel findByEmail(String email);
	
}

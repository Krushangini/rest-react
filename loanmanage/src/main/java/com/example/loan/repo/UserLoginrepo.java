package com.example.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loan.model.LoginModel;

@Repository
public interface UserLoginrepo extends JpaRepository<LoginModel, String>{

	@Modifying
	@Query("delete from LoginModel s where s.email=?1")
	int deleteByEmail(String email);
}

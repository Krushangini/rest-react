package com.example.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loan.model.AdminModel;

@Repository
public interface AdminRepo extends JpaRepository<AdminModel , String>{

}

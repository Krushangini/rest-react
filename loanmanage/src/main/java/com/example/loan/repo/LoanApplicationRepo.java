package com.example.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loan.model.LoanApplicationModel;


@Repository
public interface LoanApplicationRepo extends JpaRepository<LoanApplicationModel, Integer>{
	
	@Query("select loan  from LoanApplicationModel loan where loan.applicantemail=?1")
	LoanApplicationModel findByEmail(String applicantemail);
}

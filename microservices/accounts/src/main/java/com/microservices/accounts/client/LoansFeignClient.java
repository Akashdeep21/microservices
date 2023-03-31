package com.microservices.accounts.client;

import java.util.List;

import com.microservices.accounts.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservices.accounts.model.Customer;

@FeignClient("loans")
public interface LoansFeignClient {

	@RequestMapping(method = RequestMethod.POST, value = "myLoans", consumes = "application/json")
	List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationid, @RequestBody Customer customer);
}

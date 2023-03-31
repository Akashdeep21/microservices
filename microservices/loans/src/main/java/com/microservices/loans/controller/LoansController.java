
package com.loans.loans.controller;

import java.util.List;

import com.loans.loans.config.LoansServiceConfig;
import com.loans.loans.model.Customer;
import com.loans.loans.model.Loans;
import com.loans.loans.model.Properties;
import com.loans.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class LoansController {

	@Autowired
	private LoansRepository loansRepository;
	
	@Autowired
	LoansServiceConfig loansConfig;

	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationid, @RequestBody Customer customer) {
		System.out.println("Invoking Loans Microservice");
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		} else {
			return null;
		}

	}
	
	@GetMapping("/loans/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
				loansConfig.getMailDetails(), loansConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}

}
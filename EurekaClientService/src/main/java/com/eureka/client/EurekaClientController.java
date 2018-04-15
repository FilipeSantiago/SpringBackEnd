package com.eureka.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

List<EurekaClientModel> model = new ArrayList<EurekaClientModel>();
	
	public EurekaClientController() {
		
		EurekaClientModel fc1 = new EurekaClientModel("100", "Richard Seroter", "555-123-4567", new BigDecimal("19.50"));
		EurekaClientModel fc2 = new EurekaClientModel("101", "Jason Salmond", "555-321-7654", new BigDecimal("11.25"));
		EurekaClientModel fc3 = new EurekaClientModel("102", "Lisa Szpunar", "555-987-6543", new BigDecimal("35.00"));
		
		model.add(fc1);
		model.add(fc2);
		model.add(fc3);
	}		
	
	@RequestMapping(path="/fastpass", params={"fastpassid"})
	public EurekaClientModel getFastPassById(@RequestParam String fastpassid) {
		
		Predicate<EurekaClientModel> p = c-> c.getFastPassId().equals(fastpassid);
		EurekaClientModel customer = model.stream().filter(p).findFirst().get();
		System.out.println("customer details retrieved");
		return customer;
	}
}

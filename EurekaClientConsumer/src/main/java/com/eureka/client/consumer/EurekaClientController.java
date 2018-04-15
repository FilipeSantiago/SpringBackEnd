package com.eureka.client.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EurekaClientController {
	
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallbackMethod")
	@RequestMapping(path="/customerdetails", params={"fastpassid"})
	public EurekaClientModel getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {
		
		EurekaClientModel c = 
				restTemplate.getForObject("http://eureka-server-client/fastpass?fastpassid=" + fastpassid, EurekaClientModel.class);
		System.out.println("retrieved customer details");
		m.addAttribute("customer", c);
		return c;
	}
	
	public EurekaClientModel fallbackMethod(@RequestParam String fastpassid, Model m) {

		EurekaClientModel c = new EurekaClientModel();
		c.setFastPassId(fastpassid);
		System.out.println("Fallback operation called");
		m.addAttribute("customer", c);
		return c;
	}
	
}

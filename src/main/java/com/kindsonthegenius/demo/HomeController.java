package com.kindsonthegenius.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

	private final static String URL = "http://localhost:8080/tarifas";
	
	@RequestMapping(value = "/")
	public static String Welcome() {
		return "Welcome to Spring Boot";
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/get/tarifas")
	public List<Object> getCountries(){
		
		Object[] objects = restTemplate.getForObject(URL,Object[].class);
		return Arrays.asList(objects);
	}
}

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
	private final static String ARCHIVO_URL_SQL = "http://localhost:4567/sql/facturar/70712345";
	
	
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
	
	@GetMapping("/get/cdr")
	public List<Object> getNumberCDR(){
		
		Object[] objects = restTemplate.getForObject("http://localhost:4567/sql/facturar/70712345",Object[].class);
		
		return Arrays.asList(objects);
	}
}

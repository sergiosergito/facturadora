package controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/*
@RestController
@RequestMapping("/myapp")
public class DepartmentController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/countries")
	public List<Object> getCountries(){
		String url = "https://restcountries.eu/rest/v2/name/australia";
		Object[] objects = restTemplate.getForObject(url,Object[].class);
		return Arrays.asList(objects);
	}
}
*/
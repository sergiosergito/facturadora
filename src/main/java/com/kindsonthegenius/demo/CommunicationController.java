package com.kindsonthegenius.demo;

import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import Models.SoyUnico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class CommunicationController {

	private final static String ARCHIVO_URL_SQL = "http://localhost:4567/sql/facturar";///70712345";
	private final static String RATES_JSP_FILE = "show-rates.jsp";
	private final static String TEST_HTML = "test.html";
	private final static String TEST_URL = "http://localhost:8080/tarifas";
	SoyUnico ricardo = SoyUnico.getSingletonInstance("Ricardo Moya");
	/*
	public void decoder(String unformated) {
		System.out.println(unformated);
	}
	*/
	/*
	public void decoder(HttpServletResponse response) throws IOException  {
		response.sendRedirect("/");
	}
	*/
	@GetMapping("/get/tarifas")
	public List<Object> getCountries(){
		
		Object[] objects = restTemplate.getForObject(TEST_URL,Object[].class);
		return Arrays.asList(objects);
	}
		
	@RequestMapping("/get/cdr/{number}")
	public void getNumberCDR(@PathVariable("number")String number){
		String response="";
		try {
			URL url = new URL(ARCHIVO_URL_SQL + "/" + number);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while((output = br.readLine()) != null){
				//System.out.println(output);
				response += output;
			}
			
			ricardo.setNombre(response);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		//ViewController view = new ViewController();
	}
	
	
	@RequestMapping("/mensaje")
    public String mensaje() {
        return "mensaje";
    }
	
	@Autowired
	private RestTemplate restTemplate;
	/*
	@RequestMapping(value = "/")
	public static String Welcome() {
		return "Welcome to Spring Boot";
	}
	*/
}

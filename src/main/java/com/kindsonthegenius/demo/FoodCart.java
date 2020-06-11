package com.kindsonthegenius.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FoodCart {

	private final static String TEST_HTML = "test.html";

	@RequestMapping("/home")
	public String doGet() {
		return TEST_HTML;
	}
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//get the data from model
		
		//redirect to a different page
		RequestDispatcher dispatcher = request.getRequestDispatcher(RATES_JSP_FILE);
		dispatcher.forward(request, response);
	}
	*/
}

package com.kindsonthegenius.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Models.SoyUnico;


@Controller
public class ViewController extends HttpServlet{

	private final static String INVOICE_HTML = "invoice.html";
	private final static String ARCHIVO_URL_SQL = "http://localhost:4567/sql/facturar/70712345";
	private final static String HOME_HTML = "home.html";
	private final static String WELCOME_JSP = "welcome.jsp";
	SoyUnico ricardo = SoyUnico.getSingletonInstance("Ricardo Moya");
	
	@RequestMapping(value = "/")
	public String root() {
		System.out.println(ricardo.getNombre());
		return HOME_HTML;
	}
	
	
	@RequestMapping(value = "/home")
	public String home() {
		return HOME_HTML;
	}
	
	@RequestMapping(value = "/invoice")
	public String showInvoice() {
		System.out.println(ricardo.getNombre());
		return INVOICE_HTML;
	}
	
	@RequestMapping(value = "/welcome")
	public String showWelcome() {
		System.out.println(ricardo.getNombre());
		return WELCOME_JSP;
	}
	
	
	/*
	@RequestMapping(value = "/invoice")
	public void invoice() {
		CommunicationController communicationController = null;
		communicationController.getNumberCDR("70712345");
	}
	*/
	/*
	@RequestMapping("/get/cdr/{number}")
	public String getNumberCDR(@PathVariable("number")String number){
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
				System.out.println(output);
				response += output;
			}
			//decoder(response);
			
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		return response;
	}
	*/
	/*
	@RequestMapping("/test")
	public String testjps() {
		System.out.println("Entro a /test funcion main");
		return "show-rates.jsp";
	}
	*/
	
	@RequestMapping("/test")
	public void doGet(HttpServletRequest request, HttpServletResponse response){
	     try{
	      response.setContentType("text/html");
	      PrintWriter pwriter = response.getWriter();

	      String name = request.getParameter("userName");
	      //String password = request.getParameter("userPassword");
	      //pwriter.print("Hello "+ name);
	      //pwriter.print("Your Password is: "+password);
	      HttpSession session=request.getSession();
	      session.setAttribute("uname",name);
	      //session.setAttribute("upass",password);
	      pwriter.print("<a href='welcome'>view details</a>");
	      pwriter.close();
	    }catch(Exception exp){
	       System.out.println(exp);
	     }
	  }
	
	
	/*
	@RequestMapping(value = "/")
	public static String Welcome() {
		return "Welcome to Spring Boot";
	}
	*/
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//get the data from model
		
		//redirect to a different page
		RequestDispatcher dispatcher = request.getRequestDispatcher(RATES_JSP_FILE);
		dispatcher.forward(request, response);
	}
	*/
}

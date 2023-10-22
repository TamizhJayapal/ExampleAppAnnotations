/*
 * ServletConfig is an interface in the Java Servlet API that represents 
 * the configuration information of a specific servlet. It provides access to 
 * the initialization parameters (init parameters) defined for the servlet in 
 * the web deployment descriptor (web.xml) or through annotations. 
 * It's typically used in the servlet's init method.
 * 
 * ServletContext is an interface in the Java Servlet API that represents the web application itself. 
 * It provides access to the environment and resources shared across all servlets in the application. 
 */


package com.example.welcome;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(
	name="WelcomeServlet",
	urlPatterns= {"/welcome"},
	initParams = {
		@WebInitParam(name="message", value="Page Welcomes you!")
	})

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private String dbUrl;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
		
		dbUrl = config.getServletContext().getInitParameter("dbUrl"));
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<body>\n"
					+ "\n"
					+ "<h1>Hi "
					+ request.getParameter("name")
					+",	 "
					+ getInitParameter("message")
					+ "</h1>\n"
					+ "<p>"
					+ dbUrl
					+ "</p>"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
	}

}

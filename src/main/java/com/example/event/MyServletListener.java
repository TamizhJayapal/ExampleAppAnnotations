package com.example.event;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class MyServletListener implements ServletContextListener {

    public MyServletListener() {
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	context.setInitParameter("dbUrl", "https://google.com/");
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    }
	
}

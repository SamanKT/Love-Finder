package com.saman.cl.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer // implements WebApplicationInitializer 
{

	public void onStartup(ServletContext servletContext) throws ServletException {

		//creating a webApplicationcontext using NO XML approach
		 AnnotationConfigWebApplicationContext webApplicationContext= new AnnotationConfigWebApplicationContext();
		
		webApplicationContext.register(LoveCalculatorConfig.class);
		
		//create a dispatcher servlet using the webapplicationcontext 
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		//registering dispatcher servlet on the sevlet context
		ServletRegistration.Dynamic serDynamic = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		serDynamic.setLoadOnStartup(1);
		serDynamic.addMapping("/mywebsite.com/*");

	}

}

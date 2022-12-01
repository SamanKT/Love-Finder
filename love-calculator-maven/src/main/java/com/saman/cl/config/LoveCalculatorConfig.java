package com.saman.cl.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.saman.cl.formatter.MyFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.saman.cl.controllers", "com.saman.cl.validator", "com.saman.cl.service" })
@PropertySource("classpath:mail.properties")
public class LoveCalculatorConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	private Logger logger = Logger.getLogger(LoveCalculatorConfig.class.getName());  // to get an instance of the Logger class
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;

	}

	@Bean
	public LocalValidatorFactoryBean validator() { // the name must be validator()
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());

		return localValidatorFactoryBean;
	}

	@Override
	public Validator getValidator() {

		return validator();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		//System.out.println("inside the formatter registry");
		logger.info("******inside the formatter registry with the Logger by SAMAN*****"); // always use logger instead of the sysout
		registry.addFormatter(new MyFormatter());
	}

	// Email Sender Bean creation

	@Bean
	public JavaMailSenderImpl getMailSender() {

		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(env.getProperty("mail.host"));

		mailSenderImpl.setUsername(env.getProperty("mail.user"));
		mailSenderImpl.setPassword(env.getProperty("mail.pass"));
		mailSenderImpl.setPort(getIntProperty());

		mailSenderImpl.setJavaMailProperties(getPrametersForMail());

		return mailSenderImpl;

	}

	private Properties getPrametersForMail() {
		Properties prob = new Properties();
		prob.put("mail.transport.protocol", "smtp");
		prob.put("mail.smtp.starttls.enable", "true");
		prob.put("mail.debug", "true");
		prob.put("mail.smtp.auth", "true");

		prob.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return prob;
	}

	public int getIntProperty() {

		String property = env.getProperty("mail.port");

		return Integer.parseInt(property);
	}

}

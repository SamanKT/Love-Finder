package com.saman.cl.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.saman.cl.api.EmailDTO;
import com.saman.cl.api.LoveCalculatorDTO;
import com.saman.cl.service.LoveCalServiceImp;

@Controller
public class EmailController {

	
	private Logger logger = Logger.getLogger(EmailController.class.getName());
	
	@Autowired
	private LoveCalServiceImp serviceImp;
	
	@RequestMapping("/email")
	public String emailSend( Model model, HttpSession session, HttpServletResponse response , HttpServletRequest request) throws IOException {
		System.out.println(session.getId());
		LoveCalculatorDTO dto2 = (LoveCalculatorDTO)session.getAttribute("dto");
	
		model.addAttribute("emailDTO", new EmailDTO());
		model.addAttribute("dto", dto2);
		
		return "email";
	}

	@RequestMapping("/email-process")
	public String emailProcess( LoveCalculatorDTO dto,@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		
		try {
			serviceImp.sendEmail(dto.getUserName(), emailDTO.getId(), "FRIEND");  // always handle the exception whenever using the service methods
		} catch (Exception e) {
			
			logger.info("***SAMAN We cannot send Email due to the invoked exception: "+e.getMessage());
		}
		
		
		return "email-process-page";
	}
}

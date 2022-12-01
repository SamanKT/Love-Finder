package com.saman.cl.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saman.cl.api.CommunicationDTO;
import com.saman.cl.api.LoveCalculatorDTO;
import com.saman.cl.api.LoveCalculatorRegisterDTO;
import com.saman.cl.api.Phone;
import com.saman.cl.service.LoveCalResultImpl;
import com.saman.cl.validator.EmailValidatorSpringVersion;

@Controller
//@SessionAttributes({"dto"})
public class TestController {

	
	@Autowired
	EmailValidatorSpringVersion emailValidator;
	
	@Autowired
	private LoveCalResultImpl loveCal;

	@RequestMapping("/")
	public String homeMethod(Model model) {
		
		
		
		model.addAttribute("dto", new LoveCalculatorDTO());   // in case of using @SessionAttributes, the model object MUST be added manually
		return "home";
	}

	@RequestMapping("/process-page")
	public String processMethod(@Valid @ModelAttribute("dto") LoveCalculatorDTO info, BindingResult result, HttpSession session, Model model, HttpServletResponse response, HttpServletRequest request) {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError);
			}
			return "home";
		}
		LoveCalculatorDTO dtoo =(LoveCalculatorDTO) model.getAttribute("dto");
		session.setAttribute("dto",dtoo );
		String loveResult = loveCal.calculateLove(info.getUserName(), info.getCrushName());
		info.setResult(loveResult);
		
		return "result";
	}


	@RequestMapping("/register")
	public String signup(@ModelAttribute("userRegister") LoveCalculatorRegisterDTO userRegister) {
		userRegister.setAge(10);
		Phone phone2 = new Phone();
		phone2.setCountryCode("91");
		phone2.setNumber("111222");
		CommunicationDTO comdto = new CommunicationDTO();
		comdto.setPhone(phone2);
		userRegister.setCommunicationDTO(comdto);

		return "signup";
	}

	@RequestMapping("/confirmation")
	public String confirm(@Valid @ModelAttribute("userRegister") LoveCalculatorRegisterDTO userRegister,
			BindingResult result) {

		emailValidator.validate(userRegister, result);

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error);
			}

			return "signup";
		}
		return "confirm";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside the initBinder method");
		// binder.setDisallowedFields("name");

		StringTrimmerEditor trimmer = new StringTrimmerEditor(true); // is used to delete space chars from a string
		binder.registerCustomEditor(String.class, "userName", trimmer); // registering an editor

		// binder.addValidators(new EmailValidatorSpringVersion());
	}

}

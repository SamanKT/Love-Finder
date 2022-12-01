package com.saman.cl.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saman.cl.api.FeedbackDTO;

@Controller
public class FeedBackController {

	@RequestMapping("/feedBack")
	public String feed(FeedbackDTO dto, Model model) {
		model.addAttribute("feedback", dto);
		return "feedPage";
	}
	
	@RequestMapping("/confirmFeedback")
	public String confirmFeed(@Valid FeedbackDTO dto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			
			model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"feedback", result);
			return "feedPage";
		}
		return "confirmfeed";
	}
}

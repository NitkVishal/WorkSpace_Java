package com.prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping("/sayWelcome")
	public ModelAndView sayWelcome(){
		String msg="Say Welcome Spring";
		return new ModelAndView("Welcome","message",msg);
		
	}

}

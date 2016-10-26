package com.prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/sayHello")
	public ModelAndView sayHello(){
		String msg="Say Hello Spring";
		return new ModelAndView("helloWorld","message",msg);
				
	}

}

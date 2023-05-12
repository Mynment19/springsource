package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * value : 해당 컨트롤러가 어떤 요청을 처리할 것인지 작성
 * 
 * http://localhost:8080/ + GET
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "index"; // ==> ViewResolver : /WEB-INF/views/home.jsp
	}
	
	@GetMapping("/doA")
	public String doA() {
		logger.info("doA...");
		// result.jsp 보여주고 싶다면?
		return "result";
	}
	
}

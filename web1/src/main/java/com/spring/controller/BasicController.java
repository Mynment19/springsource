package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // @Component의 자식
@RequestMapping("/sample") // option,  BasicController는 http://localhost:8080/sample/** 요청에 응답하는 컨트롤러
public class BasicController {
	
	// private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 컨트롤러 안에 일반 메소드 작성 가능
	// 일반 메소드는 @RequestMapping 어노테이션을 붙이지 않으면 됨
	
	@GetMapping() // http://localhost:8080/sample/basic + GET 
	public void basic() {
		//logger.info("basic......요청");
		log.info("basic......요청");
		
		// 컨트롤러 실행 후(없을수도 있다.) ViewResolver가 실행 된다.
		// 리턴이 있다면 /WEB-INF/views/리턴값.jsp
		// 리턴이 없다면 주소줄 문자열 /WEB-INF/views/sample/basic.jsp으로 만들어서 결과를 리턴한다.
		// [/WEB-INF/views/sample/basic.jsp]
	}
}

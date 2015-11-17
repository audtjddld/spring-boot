package com.devms.blog.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * 메인 페이지
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/")
	public String index(HttpServletRequest request){
		
		return "index";
	}
	
	/**
	 * 로그인 페이지
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request) {
		
		return "login";
	}
}

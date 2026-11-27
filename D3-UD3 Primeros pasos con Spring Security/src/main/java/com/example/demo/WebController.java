package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping(value = { "/", "/home" })
	public String home() {
		return "home";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	  
	@GetMapping("/login2")
	public String login2() {
		return "login";
	}


}
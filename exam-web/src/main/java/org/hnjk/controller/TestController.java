package org.hnjk.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public Authentication user(Authentication user) {
		return user;
	}
}

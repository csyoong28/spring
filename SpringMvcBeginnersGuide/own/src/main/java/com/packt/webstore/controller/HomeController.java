package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/redirect")
	public String welcomeRedirect(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		return "redirect:/home/welcome/greeting";
	}
	
	@RequestMapping("/forward")
	public String welcomeForward(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		return "forward:/welcome/greeting";
	}

	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}

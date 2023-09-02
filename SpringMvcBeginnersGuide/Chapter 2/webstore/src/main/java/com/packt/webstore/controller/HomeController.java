package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
public class HomeController extends HttpServlet implements ServletConfigAware {
	@Autowired
	private ServletContext servletContext;

	private ServletConfig servletConfig;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;
	}

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!2");
		model.addAttribute("tagline", "The one and only amazing web store2");

		return "welcome";
	}

	@RequestMapping("/test")
	public String test(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		String contextParam = servletContext.getInitParameter("email");
		Enumeration params = servletContext.getInitParameterNames();
		System.out.println("context-params: ");
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			System.out.println(name + " = " + servletContext.getInitParameter(name));
		}

		Enumeration initParams = servletConfig.getInitParameterNames();

		System.out.println("init-params: ");
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			System.out.println(name + " = " + servletConfig.getInitParameter(name));
		}
//		ServletConfig servletConfig2 = WebApplicationContextUtils.getWebApplicationContext(servletContext).getServletConfig();
//
//		servletContext.con

		pw.println(getServletContext().getInitParameter("email"));
		return null;
	}



}

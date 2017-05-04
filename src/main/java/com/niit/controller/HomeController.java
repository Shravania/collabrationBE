package com.niit.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomeController {
	@CrossOrigin(origins="http://localhost:8081")
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

}

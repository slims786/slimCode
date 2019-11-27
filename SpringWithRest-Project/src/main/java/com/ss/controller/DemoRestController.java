package com.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
@RequestMapping(value = "/wish", method = RequestMethod.GET )
	public String welcome() {
		return "Welcome to Spring with Rest";
	}
}

package com.uk.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	@RequestMapping("/")
	private String homePage() {
		return "Hi This is a home page for spring boot jpa.";
	}
}

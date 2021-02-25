package com.jooboard.joo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main.joo")
		public String getMain() {
			return "main";
	}
	@RequestMapping("/admin/admin.joo")
		public String getAdmin() {
			return "admin/admin";
	}
}

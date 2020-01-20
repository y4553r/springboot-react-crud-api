package com.y4553r.springboot.demo.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class FormController {
	
	@GetMapping("/addForm")
	public String renderForm(Model model) {
		return "form";
	}
	
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;


@Controller
public class TestController {
	
	@Autowired
	TestRepository testRepository;

	@GetMapping("/test")
	public String index(Model model) {
		Test aa = testRepository.findById(1).get();
	
		
		model.addAttribute("test", aa);
		
		return "test";
		
		
	}
}

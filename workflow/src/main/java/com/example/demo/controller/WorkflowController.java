package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Workflow;
import com.example.demo.repository.WorkflowRepository;

@Controller
@RequestMapping("/workflow")
public class WorkflowController {

	@Autowired
	WorkflowRepository workflowRepository;

	@GetMapping({ "/", "" })
	public String index() {
		return "workflow/index";
	}
	
	@GetMapping("/create")
	public String createWorkflow(Model model) {
		List<Integer> orderList = new ArrayList<>();
		orderList.add(10);
		orderList.add(20);
		orderList.add(30);
		model.addAttribute("orderList", orderList);
		
		
		return "workflow/create";
	}
	
	@GetMapping("/draft/{id}")
	public String checkWorkflow() {
		
		return "redirect:/workflow/";
	}

	@GetMapping("/all")
	public String all(Model model) {
		List<Workflow> wfList = workflowRepository.findAll();
		System.out.println(wfList);
		model.addAttribute("wfList", wfList);
		
		return "workflow/all";
	}

}

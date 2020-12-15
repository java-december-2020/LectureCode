package com.matthew.sampleProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/addJoke", method=RequestMethod.POST)
	public String addJoke(@RequestParam("name") String name, @RequestParam("joke") String joke, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("joke", joke);
		return "showJoke.jsp";
	}
	
	@RequestMapping(value="/colors/{color}", method=RequestMethod.GET)
	public String coolColors(@PathVariable("color") String color, Model viewModel) {
		viewModel.addAttribute("color", color);
		return "color.jsp";
	}
	
	
}

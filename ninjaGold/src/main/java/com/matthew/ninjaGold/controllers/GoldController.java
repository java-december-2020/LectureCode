package com.matthew.ninjaGold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	@RequestMapping("/")
	@GetMapping("/Gold")
	public String index(HttpSession session, Model viewModel) {
		ArrayList<String> activityLog = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activityLog);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("gold"));
		viewModel.addAttribute("activityLog", session.getAttribute("activity"));
		return "index.jsp";
	}
	
	@PostMapping("/addGold")
	public String addGold(@RequestParam("building") String building, HttpSession session) {
		int gold = (int)session.getAttribute("gold");
		ArrayList<String> activityLog = (ArrayList<String>)session.getAttribute("activity");
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		int goldThisTurn;
		if(building.equals("farm")) {
			goldThisTurn = r.nextInt((20 - 10) + 1) + 10;
			activityLog.add("You entered a farm and got " + goldThisTurn + " gold!" + " " + formatter.format(now));
		} else if (building.equals("cave")) {
			goldThisTurn = r.nextInt((10 - 5) + 1) + 5;
			activityLog.add("You entered a cave and got " + goldThisTurn + " gold!" + " " + formatter.format(now));
		} else if(building.equals("house")) {
			goldThisTurn = r.nextInt((5 - 2) + 1) + 2;
			activityLog.add("You entered a house and got " + goldThisTurn + " gold!" + " " + formatter.format(now));
		} else {
			goldThisTurn = r.nextInt((50 + 50) + 1) -50;
			if(goldThisTurn > 0) {
				activityLog.add("You entered a casino and got " + goldThisTurn + " gold!" + " " + formatter.format(now));
			} else {
				activityLog.add("You entered a casino and lost " + goldThisTurn + " gold!" + " " + formatter.format(now));
			}
			
		}
		session.setAttribute("gold", gold + goldThisTurn);
		session.setAttribute("activity", activityLog);
		return "redirect:/Gold";
	}
	
	@GetMapping("/logout")
	public String seshClear(HttpSession session) {
		session.invalidate();
		return "redirect:/Gold";
	}
}

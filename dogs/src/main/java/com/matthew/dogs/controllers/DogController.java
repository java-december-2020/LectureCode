package com.matthew.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.Rating;
import com.matthew.dogs.models.Tag;
import com.matthew.dogs.models.User;
import com.matthew.dogs.services.DogService;
import com.matthew.dogs.services.TagService;
import com.matthew.dogs.services.UserService;

@Controller
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	@Autowired
	private UserService uService;
	
	
	@GetMapping("/")
	public String login(Model viewModel) {
		List<User> users = this.uService.allUsers();
		viewModel.addAttribute("users", users);
		return "landing.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userToLogin") Long id, HttpSession session, Model viewModel) {
		if(session.getAttribute("user_id") == null) {
			session.setAttribute("user_id", id);
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		System.out.println(userId);
		User user = this.uService.findOneUser(userId);
		List<Dog> allDogs = this.dService.getAllDogs();
		viewModel.addAttribute("allDogs", allDogs);
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String addDog(@ModelAttribute("dog") Dog dog) {
		return "add.jsp";
	}
	
	
	@PostMapping("/addNewDog")
	public String addNewDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.dService.createDog(dog);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag, @ModelAttribute("dog") Dog dog, @ModelAttribute("rating") Rating rating) {
		viewModel.addAttribute("dog", this.dService.getSingleDog(id));
		return "show.jsp";
	}
	
	
	@PostMapping("/edit/{id}")
	public String updateDog(@Valid @ModelAttribute("dog") Dog newDog, BindingResult result, @PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getSingleDog(id));
			return "show.jsp";
		}
		this.dService.updateDog(newDog);
		return "redirect:/" + id;
	}
	
	@PostMapping("/addTag")
	public String creatTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model viewModel) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getSingleDog(dogId));
			return "show.jsp";
		}
		this.tService.create(tag);
		return "redirect:/" + dogId;
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long UserId = (Long)session.getAttribute("user_id");
		Long petId = id;
		User liker = this.uService.findOneUser(UserId);
		Dog likedDog = this.dService.getSingleDog(petId);
		this.dService.addLiker(liker, likedDog);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long UserId = (Long)session.getAttribute("user_id");
		Long petId = id;
		User liker = this.uService.findOneUser(UserId);
		Dog likedDog = this.dService.getSingleDog(petId);
		this.dService.removeLiker(liker, likedDog);
		return "redirect:/dashboard";
	}
	
	// Old Way Of Doing Normal HTML Forms + Validations from scratch
	@PostMapping("/addDog")
	public String newDog(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttrs) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")){
		  errors.add("Hey there - you forgot to add a name");
		}
		if(breed.equals("")) {
			errors.add("You Forgot To Add a Breed!");
		}
		if(errors.size() > 0){
		  for(String e: errors){
		    redirectAttrs.addFlashAttribute("errors", e);
		  }  
		  return "redirect:/add";
		}
		this.dService.createDog(name, breed, age);
		return "redirect:/";
	}
}

package com.company.df.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.df.model.User;
import com.company.df.model.UserRepository;

@Controller    
@RequestMapping(path="/demo") 
public class UserController {
	@Autowired 
	private UserRepository userRepository;

	@GetMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		try {
			userRepository.save(n);	
		} catch (Exception e) {
			// TODO: handle exception
			return "error :  " + e.getMessage();
		}
		
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		
		return userRepository.findAll();
	}
}
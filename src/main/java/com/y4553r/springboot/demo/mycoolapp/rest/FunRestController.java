package com.y4553r.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${team.name}")
	private String teamName;
	
	@Value("${team.coach}")
	private String teamCoach;
	
	// expose a "/" end point that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello Worlds. Time on the server is: " + LocalDateTime.now();
	}
	
	// expose "/workout" end point that returns "GO TO GYM"
	@GetMapping("/workout")
	public String getWorkout() {
		return "GO TO GYM! With " + this.teamCoach;
	}
	
	// expose "/fortune" end point that returns "You are great <3"
	@GetMapping("/fortune")
	public String getFortune() {
		return "You are great team " + this.teamName + " <3";
	}
	
}

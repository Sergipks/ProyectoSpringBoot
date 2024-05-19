package com.joverpenalva.proyectospringboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class IndexController {
	
	@GetMapping({"/index", "/", "/home"})
	public String index(){
		return "index";
	}
}

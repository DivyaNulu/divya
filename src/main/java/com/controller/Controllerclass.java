package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Modelclass;
import com.service.Serviceclass;


@RestController
public class Controllerclass {
	@Autowired
	Serviceclass springservice;

	@PostMapping("/insert") 
	public String insert(@RequestBody Modelclass springpojo) {
		return springservice.insertdata(springpojo);
	}

	@GetMapping("/read")  
	public List<Map<String, Object>> sub(Modelclass springpojo) {
		return springservice.readdata(springpojo);
	}

	@PutMapping("/update") 
	public String change(@RequestBody Modelclass springpojo) {
		return springservice.change(springpojo);
	}

	@DeleteMapping("/delete") 
	public String delete(@RequestBody Modelclass springpojo) {
		return springservice.delete(springpojo);
	}
}

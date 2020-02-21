package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Alien;
import com.spring.service.AlienServiceImpl;

@RestController
@ResponseBody
public class AlienController {
	
	@Autowired
	private AlienServiceImpl service;

	@RequestMapping("/api")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	// Registration page
	@PostMapping("/add")
	public ResponseEntity<Alien> addAlien(@Valid @RequestBody Alien alien) {
		if (alien == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(service.addAlien(alien));
	}

	// Update Page
	@PutMapping("/update/{id}")
	public ResponseEntity<Alien> updateAlien(@PathVariable int id, @Valid @RequestBody Alien alien) {
		if (service.getAlien(id) == null)
			return ResponseEntity.notFound().build();
		else {
			Alien a = service.getAlien(id); // fetch current user
			a.setName(alien.getName());
			a.setPassword(alien.getPassword());
			return ResponseEntity.ok(service.updateAlien(a));
		}
	}

	// Get one field
	@GetMapping("/getone/{id}")
	public ResponseEntity<Alien> getOne(@PathVariable("id") int aid) {
		if (aid == 0)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(service.getAlien(aid));
	}

	// Get All data
	@GetMapping("/getAll")
	public ResponseEntity<List<Alien>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	// Delete one
	@DeleteMapping("/delete/{id}")
	public String deleteAlien(@PathVariable int id) {
		if (service.getAlien(id) != null) {
			service.deleteAlien(id);
			return "Data removed successfully...";
		} else
			return "Sorry File is empty";
	}
}

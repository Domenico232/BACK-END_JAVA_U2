package com.proj.alb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.alb.entity.Allarm;
import com.proj.alb.service.AllarmService;

@RestController
@RequestMapping("/api/allarms")
public class AllarmController {
	@Autowired
	AllarmService as;

	@GetMapping
	public ResponseEntity<List<Allarm>> getAllallarm() {

		return ResponseEntity.ok(as.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAllarmByid(@PathVariable Long id) {
		return ResponseEntity.ok(as.getById(id));
	}

	@PostMapping
	public ResponseEntity<Allarm> createAllarm(@RequestBody Allarm allarm) {
		return ResponseEntity.ok(as.create (allarm));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAllarm(@RequestBody Allarm allarm, @PathVariable Long id) {
		return ResponseEntity.ok(as.update (allarm, id));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAllarmByid(@PathVariable Long id) {

		return ResponseEntity.ok(as.delete(id));

	}
}

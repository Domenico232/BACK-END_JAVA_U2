package com.weekproj.springII.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekproj.springII.entity.Device;
import com.weekproj.springII.service.DeviceService;


@RestController
@RequestMapping("/api/devices")

public class DeviceController {
	@Autowired
	DeviceService ds;

	@GetMapping
	public ResponseEntity<List<Device>> getAlldevices() {

		return ResponseEntity.ok(ds.getAll());
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> getDeviceByid(@PathVariable Long id) {
		return ResponseEntity.ok(ds.getById(id));
	}

	@PostMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Device> createDevice(@RequestBody Device device) {
		return ResponseEntity.ok(ds.create(device));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> updateDevice(@RequestBody Device device, @PathVariable Long id) {
		return ResponseEntity.ok(ds.update(device, id));

	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteDeviceByid(@PathVariable Long id) {

		return ResponseEntity.ok(ds.remove(id));

	}
}
package com.weekproj.springII.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekproj.springII.entity.Device;
import com.weekproj.springII.repository.DeviceRepository;


import jakarta.persistence.EntityExistsException;
@Service
public class DeviceService {
	// Dependency injection Repository
	@Autowired
	DeviceRepository dr;

	// get all users
	public List<Device> getAll() {
		return dr.findAll();
	}

	// get user by id
	public Device getById(Long id) {
		if (!dr.existsById(id)) {
			throw new EntityExistsException("Device not Exists");
		}
		return dr.findById(id).get();
	}

	// create user
	public Device create(Device device) {
		return dr.save(device);
	}
	public Device update(Device device, Long id) {
		if (!dr.existsById(id)) {
			throw new EntityExistsException("Device not Exists");
		}
		return dr.save(device);
	}

	// delete user
	public String remove(Long id) {
		if (!dr.existsById(id)) {
			throw new EntityExistsException("Device not Exists");
		}
		dr.deleteById(id);
		return "Device Deleted!!";
	}
}

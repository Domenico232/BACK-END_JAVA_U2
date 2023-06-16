package com.proj.alb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.alb.entity.Allarm;
import com.proj.alb.repository.AllarmRepo;

import jakarta.persistence.EntityExistsException;

@Service
public class AllarmService {
	
	@Autowired AllarmRepo ar;
	
	public List<Allarm> getAll() {
		return ar.findAll();
	}
	
	public Allarm getById(Long id) {
		return ar.findById(id).get();
	}
	
	public Allarm create(Allarm allarm) {
		return ar.save(allarm);
	}
	
	public Allarm update(Allarm allarm,Long id) {
		if (!ar.existsById(id)) {
			throw new EntityExistsException("User not Exists");
		}
		return ar.save(allarm);
	}
	
	public String delete(Long id) {
		if (!ar.existsById(id)) {
			throw new EntityExistsException("Allarm doesn't Exists");
		}
		ar.deleteById(id);
		return "Cancellato!!";
	}
	
	
	
}

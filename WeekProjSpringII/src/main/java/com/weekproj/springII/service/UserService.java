package com.weekproj.springII.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weekproj.springII.entity.User;
import com.weekproj.springII.repository.UserRepository;
import jakarta.persistence.EntityExistsException;


@Service
public class UserService {
	// Dependency injection Repository
	@Autowired
	UserRepository ur;

	// get all users
	public List<User> getAll() {
		return ur.findAll();
	}

	// get user by id
	public User getById(Long id) {
		// necessaria gestione di un errore, id non presente
		// .get() necessario
		if (!ur.existsById(id)) {
			throw new EntityExistsException("User not Exists");
		}
		return ur.findById(id).get();
	}

	// create user
	public User create(User user) {
		// necessaria gestione di un errore, utente con stessa email
		return ur.save(user);
	}

	// update user usa sempre il metodo save ma bisogna passare anche l'id dell
	// utente nel parametro
	public User update(User user, Long id) {
		// necessaria gestione di un errore, id non presente
		if (!ur.existsById(id)) {
			throw new EntityExistsException("User not Exists");
		}
		return ur.save(user);
	}

	// delete user
	public String remove(Long id) {
		// necessaria gestione di un errore, id non presente
		if (!ur.existsById(id)) {
			throw new EntityExistsException("User not Exists");
		}
		ur.deleteById(id);
		return "User Deleted!!";
	}

}


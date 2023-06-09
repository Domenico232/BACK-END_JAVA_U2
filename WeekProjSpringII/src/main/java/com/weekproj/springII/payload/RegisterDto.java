package com.weekproj.springII.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
	private String name;
	private String username;
	private String email;
	private String password;
	// Passagio di ruoli dal client (Facoltativo)
	private Set<String> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

// Il client dovrà inviare un oggetto JSON nel body con questa forma
/*
 * { "name": "Francesca Neri", "username": "francescaneri", "email":
 * "f.neri@example.com", "password": "qwerty", "roles": ["MODERATOR", "USER"] }
 */

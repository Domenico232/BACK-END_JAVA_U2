package com.weekproj.springII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weekproj.springII.entity.ERole;
import com.weekproj.springII.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}

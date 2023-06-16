package com.proj.alb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.alb.entity.Allarm;
@Repository
public interface AllarmRepo extends JpaRepository<Allarm, Long> {

}

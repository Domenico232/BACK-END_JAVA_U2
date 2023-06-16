package com.proj.alb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Allarm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long lon;
	private Long lat;
	private Integer smokeLevel;
	
	
	
	public Allarm() {
	}
	public Allarm(Long id, Long lon, Long lat, Integer smokeLevel) {
		super();
		this.id = id;
		this.lon = lon;
		this.lat = lat;
		this.smokeLevel = smokeLevel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLon() {
		return lon;
	}
	public void setLon(Long lon) {
		this.lon = lon;
	}
	public Long getLat() {
		return lat;
	}
	public void setLat(Long lat) {
		this.lat = lat;
	}
	public Integer getSmokeLevel() {
		return smokeLevel;
	}
	public void setSmokeLevel(Integer smokeLevel) {
		this.smokeLevel = smokeLevel;
	}
	
	 
	
}

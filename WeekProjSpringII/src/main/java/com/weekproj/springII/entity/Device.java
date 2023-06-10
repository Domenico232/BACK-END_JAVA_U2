package com.weekproj.springII.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="devices")
@Data
public class Device {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Enumerated(EnumType.STRING)
 private EDeviceType type;
 
 @Enumerated(EnumType.STRING)
 private EDeviceStatus status;

public Device(Long id, EDeviceType type, EDeviceStatus status) {
	super();
	this.id = id;
	this.type = type;
	this.status = status;
}


public Device() {
	// TODO Auto-generated constructor stub
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public EDeviceType getType() {
	return type;
}

public void setType(EDeviceType type) {
	this.type = type;
}

public EDeviceStatus getStatus() {
	return status;
}


public void setStatus(EDeviceStatus status) {
	this.status = status;
}

 
 
}

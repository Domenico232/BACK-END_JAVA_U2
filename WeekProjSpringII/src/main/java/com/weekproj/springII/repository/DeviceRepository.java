package com.weekproj.springII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weekproj.springII.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}

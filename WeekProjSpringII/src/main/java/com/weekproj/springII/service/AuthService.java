package com.weekproj.springII.service;

import com.weekproj.springII.payload.LoginDto;
import com.weekproj.springII.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}

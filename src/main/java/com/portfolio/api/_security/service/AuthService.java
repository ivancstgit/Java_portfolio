package com.portfolio.api._security.service;


import com.portfolio.api._security.entity.dto.AuthRequest;
import com.portfolio.api._security.entity.dto.AuthResponse;
import com.portfolio.api._security.entity.dto.RegRequest;

public interface AuthService {
    
    AuthResponse signUp(RegRequest signUpUser); 

    AuthResponse signIn(AuthRequest signInUser); 
    
} 

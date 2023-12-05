package com.portfolio.api._security.service;


import com.portfolio.api._security.dto.AuthRequest;
import com.portfolio.api._security.dto.AuthResponse;
import com.portfolio.api._security.dto.RegRequest;

public interface AuthService {
    
    AuthResponse signUp(RegRequest signUpUser); 

    AuthResponse signIn(AuthRequest signInUser); 
    
} 

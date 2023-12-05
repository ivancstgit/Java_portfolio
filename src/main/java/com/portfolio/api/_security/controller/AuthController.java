package com.portfolio.api._security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.api._security.dto.AuthRequest;
import com.portfolio.api._security.dto.AuthResponse;
import com.portfolio.api._security.dto.RegRequest;
import com.portfolio.api._security.service.AuthService;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  public AuthService authService;

  @PostMapping("/signup")
  public ResponseEntity<AuthResponse> register(@RequestBody RegRequest request) {
    return ResponseEntity.ok(authService.signUp(request));
  }

  @PostMapping("/signin")
  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
    return ResponseEntity.ok(authService.signIn(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    // authService.refreshToken(request, response);
  }

}

package com.portfolio.api._security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.api._security.entity.Role;
import com.portfolio.api._security.entity.User;
import com.portfolio.api._security.entity.dto.AuthRequest;
import com.portfolio.api._security.entity.dto.AuthResponse;
import com.portfolio.api._security.entity.dto.RegRequest;
import com.portfolio.api._security.jwt.JwtService;
import com.portfolio.api._security.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    @Override
    public AuthResponse signUp(RegRequest request) {
        User user = getUser(request);
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
            .accessToken(jwtToken)
            .build();
    }

    private User getUser(RegRequest request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        return user;
    }


    @Override
    public AuthResponse signIn(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                     request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
            .accessToken(jwtToken)
            .build();
    }

}

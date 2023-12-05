package com.portfolio.api._security.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.api._security.dto.AuthRequest;
import com.portfolio.api._security.dto.AuthResponse;
import com.portfolio.api._security.dto.RegRequest;
import com.portfolio.api._security.entity.User;
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

        AuthRequest authRequest = new AuthRequest(request.getEmail(),request.getPassword());
        return signIn(authRequest);
    }

    private User getUser(RegRequest request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        return user;
    }


    @Override
    public AuthResponse signIn(AuthRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
                    );

        authenticationManager.authenticate(authToken);
                
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User Not Found"));


        String jwtToken = jwtService.generateToken(user, generateExtraClaims(user));

        return AuthResponse.builder()
            .accessToken(jwtToken)
            .build();
    }

    private Map<String,Object> generateExtraClaims(User user) {
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getFirstname());
        extraClaims.put("role",user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());
        
        return extraClaims;

    }

}

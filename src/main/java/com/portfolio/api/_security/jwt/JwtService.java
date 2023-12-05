package com.portfolio.api._security.jwt;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.refresh-expiration}")
    private Long refreshExpiration;


    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> defaultClaims = new HashMap<>();
        defaultClaims.put("roles", Arrays.asList("USER", "ADMIN"));
        return generateToken(defaultClaims, userDetails);
    }
    
      public String generateToken(
          Map<String, Object> extraClaims,
          UserDetails userDetails
      ) {
        return buildToken(extraClaims, userDetails, expiration);
      }
    
      public String generateRefreshToken(
          UserDetails userDetails
      ) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
      }
    
      private String buildToken(
              Map<String, Object> extraClaims,
              UserDetails userDetails,
              long expiration
      ) {
        
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
      }
    

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);    
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    } 

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
}
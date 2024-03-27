package com.example.registerlogin.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.expirationMs}")
    private long expirationMs;
    @Value("${jwt.secret}")
    private String secret;
    public String generateTokenFromUsername(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expirationMs)).signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

package org.healthcare.AppointmentBooking.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secretKey = "ASRSBG13";

    // Token Creation
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 ঘণ্টা পরে এক্সপায়ার হবে
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // extraction username from JWT
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Claims JWT Token
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // To Validate JWT Token
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }


}

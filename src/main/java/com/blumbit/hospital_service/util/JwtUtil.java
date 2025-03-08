package com.blumbit.hospital_service.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretkey;

    private String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject){

        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .signWith(getSigningKey())
                .compact();
    }

    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver){
        Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts.parser()
        .build()
        .parseEncryptedClaims(token)
        .getPayload();
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername());
    }

    private boolean isTokenExpired(String token) {
        Date expirationDate = getClaimsFromToken(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretkey.getBytes());
    }
}

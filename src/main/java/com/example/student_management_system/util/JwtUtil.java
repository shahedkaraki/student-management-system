package com.example.student_management_system.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "mysecretkeymysecretkeymysecretkey123".getBytes()
            );

            private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 1 day


    // Generate Token
    public static String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    // Extract Username from token
    public static String extractUsername(String token) {
    return Jwts.parser()
            .verifyWith(SECRET_KEY)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
}

// Validate Token
public static boolean validateToken(String token) {

    try {
        Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token);

        return true;

    } catch (Exception e) {
        return false;
    }
}

}
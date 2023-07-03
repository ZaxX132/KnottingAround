package com.zaxx.KnottingAround.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;
@Component
public class JwtUtil {
    private static Algorithm ALGORITHM;
    JwtUtil(@Value("${security.jwt.secret}") String jwtSecret){
       ALGORITHM = Algorithm.HMAC256(jwtSecret);
    }
    @Value("${security.jwt.ttldays}")
    private static int timeInDays;


    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("knotting-around")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }
    public boolean isValid(String jwt){
        try{
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
        }catch(JWTVerificationException ex){
            return  false;
        }
        return true;
    }
    public String getUsername(String jwt){
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}

package com.blumbit.hospital_service.util;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public static final String SECRET = "321321321321dsadasd32edsaczxcxzc.dsadasd123341";

    private String createToken(){
        return "";
    }

    private boolean isValidToken(String token) {
        return true;
    }
}

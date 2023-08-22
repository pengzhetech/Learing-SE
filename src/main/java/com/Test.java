package com;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;

public class Test {

    @org.junit.Test
    public void test() {
        System.out.println("123");
    }

    @org.junit.Test
    public void testIoJsonWebToken() {
        String key = "myKey";
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "get");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setClaims(map)
                .compact();
        System.out.println(jwt); // eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZ2V0In0.RiKlMMNgv3XRDcZtxgukAEpOHv_Q9pQQjDPPuPa-Dw0
    }

    @org.junit.Test
    public void parseJsonWebToken() {
        String key = "myKey";
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZ2V0In0.RiKlMMNgv3XRDcZtxgukAEpOHv_Q9pQQjDPPuPa-Dw0");
        System.out.println(jws.getBody());
        System.out.println(jws.getBody().get("name"));
    }
}



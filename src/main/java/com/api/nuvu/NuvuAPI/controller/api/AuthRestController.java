package com.api.nuvu.NuvuAPI.controller.api;

import com.api.nuvu.NuvuAPI.model.UserLogin;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin("*")
public class AuthRestController {

    private final String BEARER = "Bearer ";

    @PostMapping("/login")
    public String login(@RequestBody UserLogin user) {
        if(user!=null) {
            return getToken(user.getUser());
        }
        return null;
    }



    public String getToken(String userName) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String token = Jwts.builder()
                .setId("nuvuJWT")
                .setSubject(userName)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(key, SignatureAlgorithm.HS512).compact();
        return BEARER + token;
    }
}


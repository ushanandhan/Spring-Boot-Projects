package com.example.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JWTUsernameAndPasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTUsernameAndPasswordAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Authentication authentication = null;
        try {
            UsernameAndPasswordAuthRequest authRequest = new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthRequest.class);
            Authentication authenticate = new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword());
            authentication = authenticationManager.authenticate(authenticate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(Keys.hmacShaKeyFor("securedsecuredsecuredsecuredsecuredsecuredsecuredsecuredsecuredsecured".getBytes()))
                .compact();
        response.addHeader("Authorization","Bearer "+token);
    }
}

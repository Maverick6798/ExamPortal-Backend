package com.self.ExamPortal.service.impl;

import com.self.ExamPortal.config.JwtUtils;
import com.self.ExamPortal.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public String authenticate(String username, String password){
        String token = null;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            token = jwtUtils.generateToken(userDetails);
        } catch (DisabledException ex) {
            ex.printStackTrace();
            System.out.println("User Disabled");
        } catch (BadCredentialsException ex) {
            ex.printStackTrace();
            System.out.println("Invalid Credentials");
            throw new BadCredentialsException("Invalid Credentials");
        }
        catch (ExpiredJwtException ex){
            ex.printStackTrace();
            System.out.println("Token Expired");
            throw new ExpiredJwtException(ex.getHeader(),ex.getClaims(),ex.getMessage());
        }
        return token;

    }
}

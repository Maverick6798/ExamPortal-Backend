package com.self.ExamPortal.controller;

import com.self.ExamPortal.exceptionHandling.UserNotFoundException;
import com.self.ExamPortal.models.JwtRequest;
import com.self.ExamPortal.models.JwtResponse;
import com.self.ExamPortal.models.User;
import com.self.ExamPortal.service.JwtService;
import com.self.ExamPortal.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @PostMapping("/generate-token/")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        String token;
        try {
            token = jwtService.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        } catch (UsernameNotFoundException ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException("User Not Found");
        }
        return ResponseEntity.ok(new JwtResponse(token));

    }
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return (User)this.userDetailsService.loadUserByUsername(principal.getName());




    }
}

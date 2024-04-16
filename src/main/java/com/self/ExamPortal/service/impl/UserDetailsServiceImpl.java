package com.self.ExamPortal.service.impl;

import com.self.ExamPortal.exceptionHandling.UserNotFoundException;
import com.self.ExamPortal.models.User;
import com.self.ExamPortal.repo.UserRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepoitory userRepoitory;
    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user=userRepoitory.findByUsername(username);
        if (user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

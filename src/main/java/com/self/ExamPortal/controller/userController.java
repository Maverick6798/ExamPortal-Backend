package com.self.ExamPortal.controller;

import com.self.ExamPortal.models.Role;
import com.self.ExamPortal.models.User;
import com.self.ExamPortal.models.UserRole;
import com.self.ExamPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles=new HashSet<>();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRole userRole=new UserRole();
        Role role=new Role();
        role.setRoleName("User");
        role.setRoleId(66);
        userRole.setRole(role);
        userRole.setUser(user);
        roles.add(userRole);
        return this.userService.createUser(user,roles);

    }
    @GetMapping("/{username}")
    public User findUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }
    @DeleteMapping("/id/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
    }
    @DeleteMapping("/username/{username}")
    public void deleteUserByUserName(@PathVariable("username") String username){
        this.userService.deleteUser(username);
    }


}

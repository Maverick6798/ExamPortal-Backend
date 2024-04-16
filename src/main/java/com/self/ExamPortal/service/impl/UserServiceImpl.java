package com.self.ExamPortal.service.impl;

import com.self.ExamPortal.exceptionHandling.UserFoundException;
import com.self.ExamPortal.models.User;
import com.self.ExamPortal.models.UserRole;
import com.self.ExamPortal.repo.RoleRepository;
import com.self.ExamPortal.repo.UserRepoitory;
import com.self.ExamPortal.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepoitory userRepoitory;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local= this.userRepoitory.findByUsername(user.getUsername());
        if (local!=null){
            System.out.println("User already Exist!!!");
            throw new UserFoundException("User already Exist!!!");
        }
        else{
//            Create User
            for(UserRole ur: userRoles){
                this.roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepoitory.save(user);
        }

        return local;
    }

    @Override
    public User getUser(String username) {

        return this.userRepoitory.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepoitory.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        this.userRepoitory.deleteByUsername(username);
    }
}

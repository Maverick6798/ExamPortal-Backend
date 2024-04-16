package com.self.ExamPortal.service;

import com.self.ExamPortal.models.User;
import com.self.ExamPortal.models.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username);
    public void deleteUser(Long id);
    public void deleteUser(String username);
}



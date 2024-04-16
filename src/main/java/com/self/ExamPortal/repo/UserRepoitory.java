package com.self.ExamPortal.repo;

import com.self.ExamPortal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoitory extends JpaRepository<User, Long> {

    User findByUsername(String username);

    void deleteByUsername(String username);
}

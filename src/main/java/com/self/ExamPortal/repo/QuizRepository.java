package com.self.ExamPortal.repo;

import com.self.ExamPortal.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

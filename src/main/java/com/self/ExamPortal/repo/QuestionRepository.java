package com.self.ExamPortal.repo;

import com.self.ExamPortal.models.exam.Question;
import com.self.ExamPortal.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}

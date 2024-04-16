package com.self.ExamPortal.controller;

import com.self.ExamPortal.models.exam.Quiz;
import com.self.ExamPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        Quiz newQuiz = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(newQuiz);
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        Quiz updatedQuiz = this.quizService.updateQuiz(quiz);
        return ResponseEntity.ok(updatedQuiz);
    }

    @GetMapping("/")
    public ResponseEntity<Set<Quiz>> getQuizzes() {
        Set<Quiz> quizzes = this.quizService.getQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long id) {
        Quiz quiz = this.quizService.getQuiz(id);
        return ResponseEntity.ok(quiz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        this.quizService.deleteQuiz(id);
        return ResponseEntity.ok().build();
    }
}
package com.self.ExamPortal.controller;

import com.self.ExamPortal.models.exam.Question;
import com.self.ExamPortal.models.exam.Quiz;
import com.self.ExamPortal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question newQuestion = this.questionService.addQuestion(question);
        return ResponseEntity.ok(newQuestion);
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        Question updatedQuestion = this.questionService.updateQuestion(question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @GetMapping("/")
    public ResponseEntity<Set<Question>> getQuestions() {
        Set<Question> questions = this.questionService.getQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        Question question = this.questionService.getQuestion(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<Set<Question>> getQuestionsOfQuiz(@PathVariable Long quizId) {
        Quiz quiz = new Quiz();
        quiz.setQid(quizId);
        Set<Question> questions = this.questionService.getQuestionsOfQuiz(quiz);
//        Collections.shuffle(questions);
        int numberOfQuestions = quiz.getNumberOfQuestions();
        Set<Question> limitedQuestions = questions.stream().limit(numberOfQuestions).collect(Collectors.toSet());
        return ResponseEntity.ok(limitedQuestions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        this.questionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }
}
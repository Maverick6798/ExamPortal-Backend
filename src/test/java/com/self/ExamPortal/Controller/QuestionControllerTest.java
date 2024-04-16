package com.self.ExamPortal.Controller;

import com.self.ExamPortal.controller.QuestionController;
import com.self.ExamPortal.models.exam.Question;
import com.self.ExamPortal.models.exam.Quiz;
import com.self.ExamPortal.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class QuestionControllerTest {

    @InjectMocks
    QuestionController questionController;

    @Mock
    QuestionService questionService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question();
        question.setQuesId(1L);

        when(questionService.addQuestion(any(Question.class))).thenReturn(question);

        ResponseEntity<Question> response = questionController.addQuestion(question);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getQuesId());
    }

    @Test
    public void testUpdateQuestion() {
        Question question = new Question();
        question.setQuesId(1L);

        when(questionService.updateQuestion(any(Question.class))).thenReturn(question);

        ResponseEntity<Question> response = questionController.updateQuestion(question);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getQuesId());
    }

    @Test
    public void testGetQuestions() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question();
        question1.setQuesId(1L);
        questions.add(question1);

        Question question2 = new Question();
        question2.setQuesId(2L);
        questions.add(question2);

        when(questionService.getQuestions()).thenReturn(questions);

        ResponseEntity<Set<Question>> response = questionController.getQuestions();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetQuestion() {
        Question question = new Question();
        question.setQuesId(1L);

        when(questionService.getQuestion(1L)).thenReturn(question);

        ResponseEntity<Question> response = questionController.getQuestion(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getQuesId());
    }

    @Test
    public void testGetQuestionsOfQuiz() {
        Quiz quiz = new Quiz();
        quiz.setQid(1L);
        quiz.setNumberOfQuestions(2);

        Set<Question> questions = new HashSet<>();
        Question question1 = new Question();
        question1.setQuesId(1L);
        questions.add(question1);

        Question question2 = new Question();
        question2.setQuesId(2L);
        questions.add(question2);

        when(questionService.getQuestionsOfQuiz(quiz)).thenReturn(questions);

        ResponseEntity<Set<Question>> response = questionController.getQuestionsOfQuiz(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBod
//    public void testDeleteQuestion() {
//        when(questionService.deleteQuestion(1L)).thenReturn(true);
//
//        ResponseEntity<Void> response = questionController.deleteQuestion(1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//    }
}
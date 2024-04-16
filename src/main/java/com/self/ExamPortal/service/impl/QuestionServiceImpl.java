package com.self.ExamPortal.service.impl;

import com.self.ExamPortal.models.exam.Question;
import com.self.ExamPortal.models.exam.Quiz;
import com.self.ExamPortal.repo.QuestionRepository;
import com.self.ExamPortal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return new LinkedHashSet<>(this.questionRepository.findByQuiz(quiz));
    }

    @Override
    public void deleteQuestion(Long quesId) {
        this.questionRepository.deleteById(quesId);
    }
}
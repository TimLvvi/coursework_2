package org.skypro.exam.service.impl;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.MathQuestionService;
import org.skypro.exam.service.api.QuestionService;
import org.skypro.exam.service.api.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private  JavaQuestionService javaQuestionService;
    private MathQuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(
             JavaQuestionService javaQuestionService,
             MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestionsJava(int amount) {
        if (amount > javaQuestionService.getQuestions().size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST);
        }
        Collection<Question> randomQuestions = new HashSet<>();
        while (amount > randomQuestions.size()) {
            randomQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return randomQuestions;
    }

    @Override
    public Collection<Question> getQuestionsMath(int amount) {
        if (amount > mathQuestionService.getQuestions().size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST);}
        Collection<Question> randomQuestions = new HashSet<>();
        while (amount > randomQuestions.size()) {
            randomQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}


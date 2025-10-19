package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.api.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController

public class MathQuestionController {

    private QuestionService questionService;

    @Autowired
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/math/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.addQuestion(question, answer);
        return "вопрос добавлен";
    }

    @GetMapping("/math/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.removeQuestion(question, answer);
        return "вопрос удален";
    }

    @GetMapping("/math")
    public Collection<Question> getAll() {
        return questionService.getQuestions();
    }

}
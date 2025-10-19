package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.skypro.exam.repository.QuestionRepository;
import org.skypro.exam.service.api.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Qualifier("mathQuestionService")
@Service
public class MathQuestionService implements QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void addQuestion(String question, String answer) {

        questionRepository.addQuestion(new Question(question, answer));
    }

    @Override
    public void removeQuestion(String question, String answer) {
        questionRepository.removeQuestion(new Question(question, answer));
    }

    @Override
    public Collection<Question> getQuestions() {
        return questionRepository.getAll();
    }


    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestion = new ArrayList<>();
        randomQuestion.addAll(questionRepository.getAll());
        Random random = new Random();
        int randomIndex = random.nextInt(questionRepository.getAll().size());
        return randomQuestion.get(randomIndex);
    }
}
package org.skypro.exam.service.api;

import org.skypro.exam.model.Question;

import java.util.Collection;

public interface QuestionService {


    void addQuestion(String question, String answer);

    void removeQuestion(String question, String answer);

    Collection<Question> getQuestions();

    Question getRandomQuestion();


}

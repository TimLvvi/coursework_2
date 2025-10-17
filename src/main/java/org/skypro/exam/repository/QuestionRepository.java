package org.skypro.exam.repository;

import org.skypro.exam.model.Question;

import java.util.Collection;

public interface QuestionRepository {


    void addQuestion(Question question);


    void removeQuestion(Question question);


    Collection<Question> getAll();
}
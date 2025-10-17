package org.skypro.exam.service.api;

import org.skypro.exam.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestionsJava(int amount);

    Collection<Question> getQuestionsMath(int amount);
}

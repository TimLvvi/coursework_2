package org.skypro.exam.repository;

import org.skypro.exam.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;


@Repository
@Qualifier("mathQuestionRepository")
public class MathQuestionRepository implements QuestionRepository {
    private Collection<Question> questionsMath = new HashSet<>();

    public MathQuestionRepository() {
        questionsMath.add(new Question("Чему равно π ?", "3,14"));
        questionsMath.add(new Question("10-x=5.Чему равен x?", "x=5"));
        questionsMath.add(new Question("10+y=20.Чему равен y?", "y=10"));
        questionsMath.add(new Question("3*z=9. Чему равен z?", "z=3"));
        questionsMath.add(new Question("8/a=4. Чему равен a?", "a=2"));
    }

    @Override
    public void addQuestion(Question question) {
        questionsMath.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questionsMath.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionsMath;
    }

}

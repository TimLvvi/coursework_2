package org.skypro.exam.repository;

import org.skypro.exam.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Repository
@Qualifier("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository {
    private Collection<Question> questionsJava = new HashSet<>();

    public JavaQuestionRepository() {
        questionsJava.add(new Question("Что такое main-метод в Java?", "Это точка входа в программу. Выполнение кода начинается с него."));
        questionsJava.add(new Question("Какие есть основные примитивные типы в Java?", "int, double, boolean, char, byte, short, long, float"));
        questionsJava.add(new Question("Что такое JVM?", "Виртуальная машина Java"));
        questionsJava.add(new Question("Чем класс отличается от объекта?", "Класс - это шаблон или описание, а объект - конкретный экземпляр класса."));
        questionsJava.add(new Question("Что такое наследование в Java?", "Механизм, позволяющий одному классу (потомку) перенимать поля и методы другого класса (родителя)."));
    }

    @Override
    public void addQuestion(Question question) {
        questionsJava.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questionsJava.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionsJava;
    }


}

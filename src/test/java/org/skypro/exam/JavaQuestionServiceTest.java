package org.skypro.exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;
import org.skypro.exam.repository.JavaQuestionRepository;
import org.skypro.exam.service.JavaQuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

@Mock
 private JavaQuestionRepository javaQuestionRepository;

 @InjectMocks
 private JavaQuestionService javaQuestionService;

    //Метод getQuestions возвращает пустой список вопросов, если репозиторий пуст
    @Test
    public void getAllQuestions_WhenRepositoryIsEmpty_ThenReturnEmptyCollection() {
        when(javaQuestionRepository.getAll()).thenReturn(Collections.emptySet());

        Collection<Question> questions = javaQuestionService.getQuestions();

        assertTrue(questions.isEmpty());
    }

    //Метод getQuestions возвращает список вопросов, если репозиторий сожержит вопросы
    @Test
    public void getAllQuestions_WhenRepositoryHasQuestions_ThenReturnQuestionCollection() {
        Collection<Question> allquestions = new HashSet<>();
        allquestions.add(new Question("вопрос по java1", "ответ по java1"));
        allquestions.add(new Question("вопрос по java2", "ответ по java2"));
        allquestions.add(new Question("вопрос по java3", "ответ по java3"));

        when(javaQuestionRepository.getAll()).thenReturn(allquestions);

        Collection<Question> questions = javaQuestionService.getQuestions();

        assertFalse(questions.isEmpty());
        assertEquals(3,questions.size());

    }


    //Добавление вопроса вызывает метод addQuestion у мока JavaQuestionRepository
    @Test
    public void WhenAdding_ThenCallAddQuestion() {

        javaQuestionService.addQuestion("java вопрос", "java ответ");

        verify(javaQuestionRepository).addQuestion(new Question("java вопрос", "java ответ"));
    }

    //Удаление вопроса вызывает метод removeQuestion у мока JavaQuestionRepository
    @Test
    public void WhenRemoving_ThenCallRemoveQuestion() {


        javaQuestionService.removeQuestion("java вопрос", "java ответ");

        verify(javaQuestionRepository).removeQuestion(new Question("java вопрос", "java ответ"));
    }

    //метод getRandomQuestion возвращает случайный вопрос.
    @Test
    public void getRandomQuestion_WhenRepositoryHasQuestions_ThenReturnRandomQuestion() {
        Collection<Question> allquestions = new HashSet<>();
        allquestions.add(new Question("вопрос по java1", "ответ по java1"));
        allquestions.add(new Question("вопрос по java2", "ответ по java2"));
        allquestions.add(new Question("вопрос по java3", "ответ по java3"));

        when(javaQuestionRepository.getAll()).thenReturn(allquestions);

        Question question = javaQuestionService.getRandomQuestion();

        assertNotNull(question);
        assertTrue(allquestions.contains(question));

    }
}

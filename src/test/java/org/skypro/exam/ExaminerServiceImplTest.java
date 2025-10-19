package org.skypro.exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.MathQuestionService;
import org.skypro.exam.service.api.ExaminerService;
import org.skypro.exam.service.api.QuestionService;
import org.skypro.exam.service.impl.ExaminerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    // Метод getQuestionsJava возвращает заданное количесво случайных вопросов
    @Test
    public void getQuestionsJava_ThenReturnNumberOfRandomQuestions() {
        int amount = 4;
        Question question1 = new Question("java вопрос1", "java ответ1");
        Question question2 = new Question("java вопрос2", "java ответ2");
        Question question3 = new Question("java вопрос3", "java ответ3");
        Question question4 = new Question("java вопрос4", "java ответ4");
        Collection<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        when(javaQuestionService.getQuestions()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(question1).thenReturn(question2).thenReturn(question3).thenReturn(question4);

        Collection<Question> result = examinerServiceImpl.getQuestionsJava(amount);

        assertEquals(amount, result.size());
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
        assertTrue(questions.contains(question3));
        assertTrue(questions.contains(question4));

    }

    // Метод getQuestionsJava возвращает исключение при запросе количесва вопросов большего чем в списке
    @Test
    public void getQuestionsJava_WhenAmountExceedsAvailableQuestions_ThenThrowResponseStatusException() {
        int amount = 5;
        Question question1 = new Question("java вопрос1", "java ответ1");
        Question question2 = new Question("java вопрос2", "java ответ2");
        Question question3 = new Question("java вопрос3", "java ответ3");
        Question question4 = new Question("java вопрос4", "java ответ4");
        Collection<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        when(javaQuestionService.getQuestions()).thenReturn(questions);

        assertThrows(ResponseStatusException.class,
                () -> examinerServiceImpl.getQuestionsJava(amount)
        );
    }

    // Метод getQuestionsJava возвращает заданное количесво случайных вопросов
    @Test
    public void getQuestionsMath_ThenReturnNumberOfRandomQuestions() {
        int amount = 4;
        Question question1 = new Question("math вопрос1", "math ответ1");
        Question question2 = new Question("math вопрос2", "math ответ2");
        Question question3 = new Question("math вопрос3", "math ответ3");
        Question question4 = new Question("math вопрос4", "math ответ4");
        Collection<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        when(mathQuestionService.getQuestions()).thenReturn(questions);
        when(mathQuestionService.getRandomQuestion()).thenReturn(question1).thenReturn(question2).thenReturn(question3).thenReturn(question4);

        Collection<Question> result = examinerServiceImpl.getQuestionsMath(amount);

        assertEquals(amount, result.size());
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
        assertTrue(questions.contains(question3));
        assertTrue(questions.contains(question4));

    }

    // Метод getQuestionsJava возвращает исключение при запросе количесва вопросов большего чем в списке
    @Test
    public void getQuestionsMath_WhenAmountExceedsAvailableQuestions_ThenThrowResponseStatusException() {
        int amount = 5;
        Question question1 = new Question("math вопрос1", "math ответ1");
        Question question2 = new Question("math вопрос2", "math ответ2");
        Question question3 = new Question("math вопрос3", "math ответ3");
        Question question4 = new Question("math вопрос4", "math ответ4");
        Collection<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        when(mathQuestionService.getQuestions()).thenReturn(questions);

        assertThrows(ResponseStatusException.class,
                () -> examinerServiceImpl.getQuestionsMath(amount)
        );
    }

}

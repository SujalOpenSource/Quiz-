package com.Quiz.Quiz;

import com.Quiz.Quiz.data.QuestionBank;
import com.Quiz.Quiz.service.QuizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuizApplication.class, args);

		QuestionBank questionBank = new QuestionBank();

		questionBank.loadQuestions("questions.txt");

		QuizService quizService = new QuizService(questionBank);

		quizService.startQuiz();
	}
}
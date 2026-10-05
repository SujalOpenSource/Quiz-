
        package com.Quiz.Quiz.service;

import com.Quiz.Quiz.data.QuestionBank;
import com.Quiz.Quiz.model.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QuizService {

    private final QuestionBank questionBank;
    private final Scanner scanner;

    // Stores IDs of questions that have been attempted
    private final Set<Long> attemptedQuestionIds = new HashSet<>();

    public QuizService(QuestionBank questionBank) {
        this.questionBank = questionBank;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {

        int score = 0;

        ArrayList<Question> questions = questionBank.getQuestions();

        System.out.println("================================");
        System.out.println("         WELCOME TO QUIZ");
        System.out.println("================================");

        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        for (Question question : questions) {

            System.out.println();

            question.displayQuestion();

            char answer;

            while (true) {

                System.out.print("Enter your answer (A/B/C/D): ");

                answer = scanner.next().charAt(0);

                answer = Character.toUpperCase(answer);

                if (answer == 'A'
                        || answer == 'B'
                        || answer == 'C'
                        || answer == 'D') {

                    break;
                }

                System.out.println(
                        "Invalid answer! Please enter A, B, C, or D."
                );
            }

            // Add the question ID to the HashSet
            attemptedQuestionIds.add(question.getId());

            if (question.isCorrect(answer)) {

                System.out.println("Correct!");
                score++;

            } else {

                System.out.println("Wrong!");
            }

            System.out.println("--------------------------------");
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("          QUIZ FINISHED");
        System.out.println("================================");

        System.out.println("Total Questions: " + questions.size());
        System.out.println("Attempted Questions: " + attemptedQuestionIds.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.size() - score));
        System.out.println("Your Score: " + score + "/" + questions.size());

        System.out.println("================================");
    }
}


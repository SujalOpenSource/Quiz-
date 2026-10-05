package com.Quiz.Quiz.service;

import com.Quiz.Quiz.model.QuizResult;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultService {

    public void saveResult(QuizResult result) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("quiz_results.txt", true))) {

            writer.println("===== QUIZ RESULT =====");
            writer.println("Total Questions: " + result.getTotalQuestions());
            writer.println("Correct Answers: " + result.getCorrectAnswers());
            writer.println("Wrong Answers: " + result.getWrongAnswers());
            writer.println("Percentage: " + result.getPercentage() + "%");
            writer.println("-----------------------");

            System.out.println("Quiz result saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving quiz result: " + e.getMessage()
            );
        }
    }
}
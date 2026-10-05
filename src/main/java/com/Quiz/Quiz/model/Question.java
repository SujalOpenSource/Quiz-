package com.Quiz.Quiz.model;

import com.Quiz.Quiz.enums.Category;

import java.util.LinkedHashMap;

public class Question {

    private long id;
    private Category category;
    private String questionText;
    private LinkedHashMap<Character, String> options;
    private char correctAnswer;


    public Question(long id, Category category, String questionText,
                    LinkedHashMap<Character, String> options,
                    char correctAnswer)
    {
        this.id = id;
        this.category = category;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }


    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public LinkedHashMap<Character, String> getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) ==
                Character.toUpperCase(correctAnswer);
    }


    public void displayQuestion() {

        System.out.println("\nQuestion " + id);
        System.out.println("Category: " + category);
        System.out.println(questionText);

        for (var option : options.entrySet()) {
            System.out.println(
                    option.getKey() + ": " + option.getValue()
            );
        }
    }
}
package com.Quiz.Quiz.model;

public class QuizResult {

    private final int totalQuestions;

    private final int correctAnswers;

    private final int wrongAnswers;

    private final double percentage;

    public QuizResult(int totalQuestions, int correctAnswers) {

        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;

        this.wrongAnswers = totalQuestions - correctAnswers;

        this.percentage =
                ((double) correctAnswers / totalQuestions) * 100;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public double getPercentage() {
        return percentage;
    }
}
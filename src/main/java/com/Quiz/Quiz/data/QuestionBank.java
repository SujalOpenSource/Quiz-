package com.Quiz.Quiz.data;

import com.Quiz.Quiz.enums.Category;
import com.Quiz.Quiz.model.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class QuestionBank {

    private final ArrayList<Question> questions = new ArrayList<>();

    private final Set<Long> questionIds = new HashSet<>();

    public void loadQuestions(String fileName) {

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            String line;
            long id = 0;
            Category category = null;
            String questionText = null;
            char correctAnswer = '\0';

            LinkedHashMap<Character, String> options = new LinkedHashMap<>();

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.equals("---")) {

                    if (questionIds.contains(id)) {
                        System.out.println(
                                "Duplicate question ID: " + id
                        );
                        continue;
                    }

                    Question question = new Question(
                            id,
                            category,
                            questionText,
                            options,
                            correctAnswer
                    );

                    questions.add(question);
                    questionIds.add(id);

                    options = new LinkedHashMap<>();

                    continue;
                }

                if (line.startsWith("ID:")) {
                    id = Long.parseLong(
                            line.substring(3).trim()
                    );
                }

                else if (line.startsWith("CATEGORY:")) {

                    category = Category.valueOf(
                            line.substring(9).trim()
                    );
                }

                else if (line.startsWith("QUESTION:")) {

                    questionText = line.substring(9).trim();
                }

                else if (line.matches("[A-D]:.*")) {

                    char optionKey = line.charAt(0);

                    String optionValue = line.substring(2).trim();

                    options.put(optionKey, optionValue);
                }

                else if (line.startsWith("ANSWER:")) {

                    correctAnswer = line.substring(7)
                            .trim()
                            .toUpperCase()
                            .charAt(0);
                }
            }

            System.out.println(
                    "Questions loaded: " + questions.size()
            );

        } catch (IOException e) {

            System.out.println(
                    "Error reading questions file: " + e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Invalid category or question data: "
                            + e.getMessage()
            );
        }
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
package pl.sda.mg.genericquestionnaire;

import lombok.extern.log4j.Log4j;
import pl.sda.mg.genericquestionnaire.model.Question;

import java.util.Map;
import java.util.Scanner;


@Log4j
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do{
            log.info("Please enter command [listQuestions]:");
            command = scanner.nextLine();
            if(command.startsWith("listQuestions")){
                handleLoadAndPrintQuestions();
            }else if (command.startsWith("addQuestion")){
                handleAddQuestion(command);
            }
        }while (!command.equalsIgnoreCase("quit"));

    }

    private static void handleAddQuestion(String command) {
        String[] words = command.split(" ",2);
        String questionContent = words[1];

    }

    private static void handleLoadAndPrintQuestions(){
        FileLoader<Question> questionFileLoader = new FileLoader<>(Question.class);
        Map<Long, Question> questionMap = questionFileLoader.load();

        for (Map.Entry<Long, Question> longQuestionEntry : questionMap.entrySet()) {
            log.info(longQuestionEntry.getKey() + " -> " + longQuestionEntry.getValue());
        }
    }
}

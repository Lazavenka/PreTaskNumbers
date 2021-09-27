package by.epam.webdevelopment;

import by.epam.webdevelopment.entity.CustomNumber;

import by.epam.webdevelopment.exception.ProjectException;
import by.epam.webdevelopment.service.*;
import by.epam.webdevelopment.utils.NumberReader;
import by.epam.webdevelopment.validation.NumberValidator;
import by.epam.webdevelopment.validation.NumberValidatorByStringPattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class.getSimpleName());

    public static void main(String[] args) {
        NumberValidator validator = new NumberValidatorByStringPattern();
        NumberReader reader = new NumberReader(validator);
        NumbersProcessing numbersProcessing = new NumbersProcessing();

        List<ArithmeticAction> actions = new ArrayList<>();
        actions.add(new Addition());
        actions.add(new Multiplication());
        actions.add(new Subtraction());
        actions.add(new Division());

        List<CustomNumber> numbers;

        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/numbers");
            numbers = reader.readNumbersFromInputStream(inputStream);
            double answer;
            for (ArithmeticAction action: actions) {
                numbersProcessing.setAction(action);
                answer = numbersProcessing.processNumbers(numbers);
                LOGGER.printf(Level.INFO, action.getClass().getSimpleName() + " result: %.5f", answer);
            }
        } catch (FileNotFoundException | ProjectException e) {
            e.printStackTrace();
        }


    }
}

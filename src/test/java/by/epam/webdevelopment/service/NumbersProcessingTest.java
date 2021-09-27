package by.epam.webdevelopment.service;

import by.epam.webdevelopment.entity.CustomNumber;
import by.epam.webdevelopment.exception.ProjectException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersProcessingTest {
    final NumbersProcessing numbersProcessing = new NumbersProcessing(); //addition action by default
    CustomNumber numberOne = new CustomNumber(5);
    CustomNumber numberTwo = new CustomNumber(10);

    @Test
    void processNumbers() throws ProjectException {
        List<CustomNumber> numberList = List.of(numberOne, numberTwo);

        double actionResult = numbersProcessing.processNumbers(numberList);

        assertEquals(15, actionResult);

        numbersProcessing.setAction(new Subtraction());

        actionResult = numbersProcessing.processNumbers(numberList);

        assertEquals(-5, actionResult);

        numbersProcessing.setAction(new Multiplication());

        actionResult = numbersProcessing.processNumbers(numberList);

        assertEquals(50, actionResult, 0.0001);

        numbersProcessing.setAction(new Division());

        actionResult = numbersProcessing.processNumbers(numberList);

        assertEquals(0.5, actionResult, 0.0001);
    }

    @Test
    void processNumbers_EmptyListException(){
        List<CustomNumber> numberList = Collections.emptyList();
        Exception exception = assertThrows(ProjectException.class, () -> numbersProcessing.processNumbers(numberList));

        String expectedMessage = "Provided empty list...";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void processNumbers_MoreThanTwoNumberException(){
        CustomNumber numberThree = new CustomNumber(0);
        List<CustomNumber> numberList = List.of(numberOne, numberTwo, numberThree);
        Exception exception = assertThrows(ProjectException.class, () -> numbersProcessing.processNumbers(numberList));

        String expectedMessage = "Not implemented yet...";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
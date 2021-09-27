package by.epam.webdevelopment.service;

import by.epam.webdevelopment.entity.CustomNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
    final Addition addition = new Addition();
    @Test
    void doSomeMath() {

        CustomNumber numberOne = new CustomNumber(10);
        CustomNumber numberTwo = new CustomNumber(2);

        double result = addition.doSomeMath(numberOne, numberTwo);

        assertEquals(12, result, 0.0001);
    }
}
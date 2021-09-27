package by.epam.webdevelopment.service;

import by.epam.webdevelopment.entity.CustomNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {
    final Subtraction subtraction = new Subtraction();
    @Test
    void doSomeMath() {
        CustomNumber numberOne = new CustomNumber(10);
        CustomNumber numberTwo = new CustomNumber(2);

        double result = subtraction.doSomeMath(numberOne, numberTwo);

        assertEquals(8, result, 0.0001);
    }
}
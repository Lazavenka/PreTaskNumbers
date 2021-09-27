package by.epam.webdevelopment.service;

import by.epam.webdevelopment.entity.CustomNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    final Division division = new Division();
    @Test
    void doSomeMath() {
        CustomNumber numberOne = new CustomNumber(10);
        CustomNumber numberTwo = new CustomNumber(2);

        double result = division.doSomeMath(numberOne, numberTwo);

        assertEquals(5, result, 0.0001);
    }

    @Test
    void doSomeMath_Infinity() {
        CustomNumber numberOne = new CustomNumber(10);
        CustomNumber numberTwo = new CustomNumber(0);

        double result = division.doSomeMath(numberOne, numberTwo);

        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    void doSomeMath_Zero() {
        CustomNumber numberOne = new CustomNumber(10);
        CustomNumber numberTwo = new CustomNumber(Double.POSITIVE_INFINITY);

        double result = division.doSomeMath(numberOne, numberTwo);

        assertEquals(0, result);
    }
}
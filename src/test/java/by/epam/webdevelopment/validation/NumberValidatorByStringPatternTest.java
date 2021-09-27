package by.epam.webdevelopment.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberValidatorByStringPatternTest {
    private final NumberValidator validator = new NumberValidatorByStringPattern();

    @Test
    void isNumberCorrect() {
        final String line = "55.599";

        final boolean result = validator.isNumber(line);

        assertTrue(result);
    }

    @Test
    void isNumber_Incorrect() {
        final String line = "55,599";
        final String line2 = "55.59.9";
        final String line3 = "";
        final String line4 = "   99.355";

        final boolean result = validator.isNumber(line);
        final boolean result2 = validator.isNumber(line2);
        final boolean result3 = validator.isNumber(line3);
        final boolean result4 = validator.isNumber(line4);

        assertFalse(result);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }
}
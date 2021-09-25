package by.epam.webdevelopment.validation;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorByStringPatternTest {

    @org.junit.jupiter.api.Test
    void isNumberCorrect() {
        final NumberValidator validator = new NumberValidatorByStringPattern();
        final String line = "55.599";

        final boolean result = validator.isNumber(line);

        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void isNumberIncorrect() {
        final NumberValidator validator = new NumberValidatorByStringPattern();
        final String line = "55,599";
        final String line2 = "55.59.9";

        final boolean result = validator.isNumber(line);
        final boolean result2 = validator.isNumber(line2);

        assertFalse(result);
        assertFalse(result2);
    }
}
package by.epam.webdevelopment.utils;

import by.epam.webdevelopment.entity.CustomNumber;
import by.epam.webdevelopment.validation.NumberValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberReader {
    private final Logger logger = LogManager.getLogger(NumberReader.class.getSimpleName());

    private final NumberValidator numberValidator;

    public NumberReader(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public List<CustomNumber> readNumbersFromInputStream(InputStream is) {
        List<CustomNumber> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line != null && !line.isEmpty()) {
                line = line.trim();
                if (numberValidator.isNumber(line)) {
                    var numberObject = NumberFactory.getNumberFromLine(line);
                    logger.log(Level.INFO, "Read number: " + line);
                    numbers.add(numberObject);
                } else {
                    logger.log(Level.INFO, "Incorrect number format in line: " + line);
                }
            }
        }
        return numbers;
    }
}

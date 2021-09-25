package by.epam.webdevelopment.service;

import by.epam.webdevelopment.entity.CustomNumber;
import by.epam.webdevelopment.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class NumbersProcessing {
    private final static Logger LOGGER = LogManager.getLogger(NumbersProcessing.class.getSimpleName());

    private ArithmeticAction action;

    public NumbersProcessing() {
        this.action = new Addition(); //by default
    }

    public NumbersProcessing(ArithmeticAction action) {
        this.action = action;
    }

    public ArithmeticAction getAction() {
        return action;
    }

    public void setAction(ArithmeticAction action) {
        this.action = action;
    }

    public double processNumbers(List<CustomNumber> numbers) throws ProjectException {
        if (numbers.size() == 2) {
            double result = action.doSomeMath(numbers.get(0), numbers.get(1));
            LOGGER.printf(Level.INFO, action.getClass().getSimpleName() + " result: %.5f", result);
            return result;
        } else {
            LOGGER.log(Level.DEBUG, "More than 2 numbers!");
            throw new ProjectException("Not implemented yet...");
        }
    }
}

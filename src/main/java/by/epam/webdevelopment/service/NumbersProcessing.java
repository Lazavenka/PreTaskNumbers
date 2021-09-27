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
        if (numbers.size() == 1){
            LOGGER.log(Level.INFO, "Provided only 1 number!");
            return numbers.get(0).getValue();
        }else if (numbers.size() == 2) {
            return action.doSomeMath(numbers.get(0), numbers.get(1));
        } else if (numbers.isEmpty()){
            throw new ProjectException("Provided empty list...");
        }else {
            LOGGER.log(Level.INFO, "More than 2 numbers!");
            throw new ProjectException("Not implemented yet...");
        }
    }
}

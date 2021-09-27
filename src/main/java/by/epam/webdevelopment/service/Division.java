package by.epam.webdevelopment.service;

import by.epam.webdevelopment.entity.CustomNumber;

public class Division implements ArithmeticAction {
    @Override
    public double doSomeMath(CustomNumber customNumberOne, CustomNumber customNumberTwo) {
        return customNumberOne.getValue() / customNumberTwo.getValue();
    }
}

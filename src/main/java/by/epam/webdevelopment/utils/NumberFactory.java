package by.epam.webdevelopment.utils;

import by.epam.webdevelopment.entity.CustomNumber;

public class NumberFactory {
    public static CustomNumber getNumberFromLine(String line){
        double value = Double.parseDouble(line);
        return new CustomNumber(value);
    }
}

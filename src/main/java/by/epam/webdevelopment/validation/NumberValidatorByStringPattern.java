package by.epam.webdevelopment.validation;

public class NumberValidatorByStringPattern implements NumberValidator{
    private final String NUMBER_FORMAT_PATTERN = "^[+-]?([0-9]*[.])?[0-9]+$";
    @Override
    public boolean isNumber(String line) {
        return line.matches(NUMBER_FORMAT_PATTERN);
    }
}

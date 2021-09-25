package by.epam.webdevelopment.entity;

public class CustomNumber implements Comparable<CustomNumber>{
    private final double value;

    public CustomNumber(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(CustomNumber o) {
        return Double.compare(this.getValue(), o.getValue());
    }

    public String toStringValue() {
        return "value = " + value;
    }
}

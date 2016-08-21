package bg.softuni.temperature_converter;

public class Fahrenheit {

    private double gradus;

    public Fahrenheit(double tempC) {
        this.gradus = tempC * 1.8 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.2f Fahrenheit", gradus);
    }
}

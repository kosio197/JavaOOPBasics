package bg.softuni.temperature_converter;

public class Celsius {

    private double gradus;

    public Celsius(double tempF) {

        this.gradus = (tempF - 32) / 1.8;
    }

    public double getGradus() {
        return gradus;
    }

    @Override
    public String toString() {
        return String.format("%.2f Celsius", gradus);
    }
}

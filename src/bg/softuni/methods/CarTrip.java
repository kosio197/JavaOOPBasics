package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarTrip {
    private double speed;
    private double fuel;
    private double economy;
    private double distance;

    public CarTrip(double speed, double fuel, double economy) {
        this.speed = speed;
        this.fuel = fuel;
        this.economy = economy;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFuel() {
        return fuel;
    }

    public double getEconomy() {
        return economy;
    }

    public double getDistance() {
        return distance;
    }

    public void travel(double travelDistance) {

        double maxDistance = (fuel * 100) / economy;
        double remFuel = fuel - (economy * travelDistance) / 100;

        fuel = remFuel > 0 ? remFuel : 0;

        if (fuel == 0) {
            distance += maxDistance;
        } else {
            distance += travelDistance;
        }
    }

    public void refuel(double liters) {
        fuel += liters;
    }

    public String getTime() {
        int h = (int) (distance / speed);
        int min = (int) (60 * ((distance / speed) % h) / 10);

        return String.format("%d hours and %d minutes", h, min);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] carData = br.readLine().split("\\s+");

        CarTrip car = new CarTrip(Double.valueOf(carData[0]), Double.valueOf(carData[1]), Double.valueOf(carData[2]));
        String command = br.readLine();

        while (!command.equalsIgnoreCase("END")) {

            switch (command.split("\\s")[0]) {
            case "Travel":
                car.travel(Double.valueOf(command.split("\\s")[1]));
                break;
            case "Refuel":
                car.refuel(Double.valueOf(command.split("\\s")[1]));
                break;
            case "Distance":
                System.out.printf("Total distance: %.1f kilometers\n", car.getDistance());
                break;
            case "Time":
                System.out.printf("Total time: %s\n", car.getTime());
                break;
            case "Fuel":
                System.out.printf("Fuel left: %.1f liters\n", car.getFuel());
                break;
            default:
                break;
            }

            command = br.readLine();
        }

        br.close();
    }
}

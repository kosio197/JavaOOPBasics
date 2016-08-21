package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpeedRacing {

    private static class Car {
        @SuppressWarnings("unused")
        String model;
        double fuelAmount;
        double fuelCost;
        int distanceTraveled;

        public Car(String model, double fuelAmount, double fuelCost) {
            this.model = model;
            this.fuelAmount = fuelAmount;
            this.fuelCost = fuelCost;
            this.distanceTraveled = 0;
        }

        public boolean checkTravel(double distance) {

            return (fuelAmount - (fuelCost * distance)) >= 0 ? true : false;
        }
    }

    private static Map<String, Car> cars = new LinkedHashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countCars = Integer.valueOf(br.readLine());
        for (int i = 0; i < countCars; i++) { // AudiA4 23 0.3
            String newCar[] = br.readLine().split("\\s+");
            cars.put(newCar[0], new Car(newCar[0], Double.valueOf(newCar[1]), Double.valueOf(newCar[2])));
        }

        String command = br.readLine();
        while (!command.equals("End")) {

            processCommand(command);
            command = br.readLine();
        }

        printresult();
    }

    private static void printresult() {
        for (Map.Entry<String, Car> car : cars.entrySet()) {
            System.out.printf("%s %.2f %d\n", car.getKey(), car.getValue().fuelAmount, car.getValue().distanceTraveled);
        }

    }

    private static void processCommand(String command) {

        String name = command.split("\\s+")[1];
        double distance = Double.valueOf(command.split("\\s+")[2]);

        Car car = cars.get(name);
        if (car.checkTravel(distance)) {
            car.fuelAmount -= car.fuelCost * distance;
            car.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }

    }
}

package bg.softuni.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String dataCar[] = br.readLine().split("\\s+");
        Car car = new Car(Double.valueOf(dataCar[1]), Double.valueOf(dataCar[2]), Double.valueOf(dataCar[3]));

        String dataTruck[] = br.readLine().split("\\s+");
        Truck truck = new Truck(Double.valueOf(dataTruck[1]), Double.valueOf(dataTruck[2]),
                Double.valueOf(dataTruck[3]));

        String busInfo[] = br.readLine().split("\\s+");
        Bus bus = new Bus(Double.valueOf(busInfo[1]), Double.valueOf(busInfo[2]), Double.valueOf(busInfo[3]));

        int commandCount = Integer.valueOf(br.readLine());

        for (int i = 0; i < commandCount; i++) {

            String command[] = br.readLine().split("\\s+");
            double currentValue = Double.valueOf(command[2]);

            try {

                switch (command[1]) {

                    case "Bus":
                        switch (command[0]) {
                            case "Drive":
                                bus.tryDriven(currentValue);
                                break;
                            case "Refuel":
                                bus.refuel(currentValue);
                                break;
                            case "DriveEmpty":
                                bus.setPeople(false);
                                bus.tryDriven(currentValue);
                                bus.setPeople(true);
                                break;
                        }
                        break;
                    case "Car":
                        switch (command[0]) {
                            case "Drive":
                                car.tryDriven(currentValue);
                                break;
                            case "Refuel":
                                car.refuel(currentValue);
                                break;
                        }

                        break;
                    case "Truck":
                        switch (command[0]) {
                            case "Drive":
                                truck.tryDriven(currentValue);
                                break;
                            case "Refuel":
                                truck.refuel(currentValue);
                                break;
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("Car: %.2f\nTruck: %.2f\nBus: %.2f", car.getFuelQuantity(), truck.getFuelQuantity(),
                bus.getFuelQuantity());
    }
}

package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RawData {
    static class Engine {

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        int speed;
        int power;
    }

    static class Tire {
        public Tire(double p, int a) {
            this.presure = p;
            this.age = a;
        }

        double presure;
        int age;
    }

    static class Car {

        String model;
        Engine engine;
        int cargoWeight;
        String cargoType;
        Tire[] tires;

        public Car(String model, int speed, int power, int weight, String type, double p1, int a1, double p2, int a2,
                double p3, int a3, double p4, int a4) {
            this.model = model;
            this.engine = new Engine(speed, power);
            this.cargoWeight = weight;
            this.cargoType = type;
            this.tires = new Tire[4];
            tires[0] = new Tire(p1, a1);
            tires[1] = new Tire(p2, a2);
            tires[2] = new Tire(p3, a3);
            tires[3] = new Tire(p4, a4);
        }
    }

    private static Map<String, List<Car>> carsByType = new LinkedHashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int carCount = Integer.valueOf(br.readLine());
        for (int i = 0; i < carCount; i++) {
            String[] car = br.readLine().split("\\s+");
            List<Car> cars = carsByType.get(car[4]);
            if (cars == null) {
                cars = new ArrayList<>();
            }
            cars.add(new Car(car[0], Integer.valueOf(car[1]), Integer.valueOf(car[2]), Integer.valueOf(car[3]), car[4],
                    Double.valueOf(car[5]), Integer.valueOf(car[6]), Double.valueOf(car[7]), Integer.valueOf(car[8]),
                    Double.valueOf(car[9]), Integer.valueOf(car[10]), Double.valueOf(car[11]),
                    Integer.valueOf(car[12])));
            carsByType.put(car[4], cars);
        }
        String byType = br.readLine();
        br.close();
        printResult(byType);
    }

    private static void printResult(String byType) {

        List<Car> cars = carsByType.get(byType);
        if (cars != null) {

            for (Car car : cars) {
                if (byType.equals("flamable") && car.engine.power > 250) {
                    System.out.println(car.model);
                } else if (byType.equals("fragile") && getPresure(car)) {
                    System.out.println(car.model);
                }
            }
        }
    }

    private static boolean getPresure(Car car) {
        for (Tire t : car.tires) {
            if (t.presure < 1) {
                return true;
            }
        }
        return false;
    }
}

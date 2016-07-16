package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Engine {// model, power, displacement and efficiency V4-33 140 28 B
    String model;
    int power;
    String displacement;
    String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }
}

class Car { // model, engine, weight and color. VolkswagenGolf V4-33 Orange
    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }
}

public class CarSalesman {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int engineCount = Integer.valueOf(br.readLine());
        for (int i = 0; i < engineCount; i++) {
            creatEngine(br.readLine());
        }

        int carCount = Integer.valueOf(br.readLine());
        for (int i = 0; i < carCount; i++) {
            createCar(br.readLine());
        }
        br.close();
        processCars();
    }

    private static List<Car> cars = new ArrayList<Car>();
    private static Map<String, Engine> engines = new HashMap<>();

    private static void creatEngine(String str) {

        String e[] = str.split("\\s");
        Engine next = new Engine(e[0], Integer.valueOf(e[1]));
        if (e.length == 3) {
            if (e[2].charAt(0) > 47 && e[2].charAt(0) < 58) {
                next.displacement = e[2];
            } else {
                next.efficiency = e[2];
            }
        } else if (e.length == 4) {
            next.displacement = e[2];
            next.efficiency = e[3];
        }
        engines.put(e[0], next);
    }

    private static void createCar(String str) {

        String c[] = str.split("\\s");
        Car car = new Car(c[0], engines.get(c[1]));
        if (c.length == 3) {
            if (c[2].charAt(0) > 47 && c[2].charAt(0) < 58) {
                car.weight = c[2];
            } else {
                car.color = c[2];
            }
        } else if (c.length == 4) {
            car.weight = c[2];
            car.color = c[3];
        }
        cars.add(car);
    }

    private static void processCars() {/*
     * <CarModel>: <EngineModel>:
     * Power:<EnginePower>
     * Displacement:<EngineDisplacement>
     * Efficiency:<EngineEfficiency> Weight:
     * <CarWeight> Color: <CarColor>
     */

        for (Car car : cars) {
            System.out.println(car.model + ":");
            System.out.println(" " + car.engine.model + ":");
            System.out.println("  Power: " + car.engine.power);
            System.out.println("  Displacement: " + car.engine.displacement);
            System.out.println("  Efficiency: " + car.engine.efficiency);
            System.out.println(" Weight: " + car.weight);
            System.out.println(" Color: " + car.color);
        }
    }
}

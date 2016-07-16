package bg.softuni.polimorphism.vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle implements VehicleManipulation {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double getFuelConsumption() {

        if (summer) {
            return super.getFuelConsumption() + 0.9;
        }
        return super.getFuelConsumption();
    }

    @Override
    public void tryDriven(double distance) {
        if (distance * getFuelConsumption() < getFuelQuantity()) {
            setFuelQuantity(getFuelQuantity() - distance * getFuelConsumption());
            System.out.printf("Car travelled %s km\n", DecimalFormat.getInstance().format(distance));

        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        if (getFuelQuantity() + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(this.fuelQuantity + liters);

    }
}

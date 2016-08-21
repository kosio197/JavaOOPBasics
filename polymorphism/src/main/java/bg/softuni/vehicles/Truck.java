package bg.softuni.vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle implements VehicleManipulation {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double getFuelConsumption() {

        if (summer) {
            return super.getFuelConsumption() + 1.6;
        }
        return super.getFuelConsumption();
    }

    @Override
    public void refuel(double liters) {
        liters = liters * 0.95;
        super.setFuelQuantity(this.fuelQuantity + liters);
    }

    @Override
    public void tryDriven(double distance) {
        if (distance * getFuelConsumption() < getFuelQuantity()) {
            setFuelQuantity(getFuelQuantity() - distance * getFuelConsumption());
            System.out.printf("Truck travelled %s km\n", DecimalFormat.getNumberInstance().format(distance));

        } else {
            System.out.println("Truck needs refueling");
        }
    }
}

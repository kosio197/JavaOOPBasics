package bg.softuni.vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle implements VehicleManipulation {

    private boolean people;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setPeople(true);
    }

    public boolean isPeople() {
        return people;
    }

    public void setPeople(boolean people) {
        this.people = people;
    }

    @Override
    public double getFuelConsumption() {
        if (people) {
            return this.fuelConsumption + 1.4;
        }
        return super.getFuelConsumption();
    }

    @Override
    public void tryDriven(double distance) {
        if (distance * getFuelConsumption() < getFuelQuantity()) {
            setFuelQuantity(getFuelQuantity() - distance * getFuelConsumption());
            System.out.printf("Bus travelled %s km\n", DecimalFormat.getInstance().format(distance));

        } else {
            System.out.println("Bus needs refueling");
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

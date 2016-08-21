package bg.softuni.vehicles;

public abstract class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;
    protected boolean summer;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {

        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
        this.summer = true;
    }

    public boolean isSummer() {
        return summer;
    }

    public void setSummer(boolean summer) {
        this.summer = summer;
    }


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}

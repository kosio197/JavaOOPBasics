package bg.softuni.exam.systemsplit.model;

public abstract class Software {
    // name, a type, capacity consumption and memory consumption.
    protected String type;
    protected String name;
    protected int capacityConsumption;
    protected int memoryConsumption;

    public Software(String type, String name, int capacityConsumption, int memoryConsumption) {
        this.type = type;
        this.name = name;
        setCapacityConsumption(capacityConsumption);
        setMemoryConsumption(memoryConsumption);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getCapacityConsumption() {
        return capacityConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

}

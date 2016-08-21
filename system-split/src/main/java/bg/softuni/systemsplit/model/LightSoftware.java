package bg.softuni.systemsplit.model;

public class LightSoftware extends Software{
    //increases its given capacity consumption by 50% and decreases its given memory consumption by 50%.

    private static final double INCREASESCAPACITYCONSUMPTION = 1.5;
    private static final double DECREASESMEMORYCONSUMPTION = 0.5;

    public LightSoftware(String type, String name, int capacityConsumption, int memoryConsumption) {
        super(type, name, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = (int) (capacityConsumption * INCREASESCAPACITYCONSUMPTION);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = (int) (memoryConsumption * DECREASESMEMORYCONSUMPTION);
    }
}

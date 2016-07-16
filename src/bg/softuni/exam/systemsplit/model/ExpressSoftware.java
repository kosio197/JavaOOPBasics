package bg.softuni.exam.systemsplit.model;

public class ExpressSoftware extends Software {
    // doubles its given memory consumption.
    private static int INCESECONSUMPTION = 2;

    public ExpressSoftware(String type, String name, int capacityConsumption, int memoryConsumption) {
        super(type, name, capacityConsumption, memoryConsumption);
        setMemoryConsumption(memoryConsumption * INCESECONSUMPTION);
    }
}

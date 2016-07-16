package bg.softuni.exam.systemsplit.model;

public class PowerHardware extends Hardware {

    // decreases 75% of its given capacity, and increases its memory by 75%.
    private static final double DECREASESCAPACITYPERSENT = 0.75;
    private static final double INCREASESMEMORYPERSENT = 0.75;

    public PowerHardware(String type, String name, int maximumcCapacity, int maximumMemory) {
        super(type, name, maximumcCapacity, maximumMemory);
    }

    @Override
    public void setMaximumcCapacity(int maximumcCapacity) {
        this.maximumcCapacity = (int) (maximumcCapacity * DECREASESCAPACITYPERSENT);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = (int) (maximumMemory + (maximumMemory * INCREASESMEMORYPERSENT));
    }
}

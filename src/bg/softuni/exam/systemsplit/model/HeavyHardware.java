package bg.softuni.exam.systemsplit.model;

public class HeavyHardware extends Hardware {

    // decreases 25% of its given memory and doubles its given capacity.
    private static final double DECREASESMEMORYPERSENT = 25;
    private static final int INCREASESCAPACITY = 2;

    public HeavyHardware(String type, String name, int maximumcCapacity, int maximumMemory) {
        super(type, name, maximumcCapacity, maximumMemory);
    }

    @Override
    public void setMaximumcCapacity(int maximumcCapacity) {
        this.maximumcCapacity = (int) (maximumcCapacity * DECREASESMEMORYPERSENT);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory * INCREASESCAPACITY;
    }
}

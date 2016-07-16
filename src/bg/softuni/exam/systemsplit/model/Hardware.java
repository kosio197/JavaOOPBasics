package bg.softuni.exam.systemsplit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Hardware {
    //Hardware components have a name, a type, a maximum capacity and a maximum memory.

    protected String type;
    protected String name;
    protected int maximumcCapacity;
    protected int currentCapacity;
    protected int maximumMemory;
    protected int currentMemory;
    List<Software> currentSoft;

    public String getName() {
        return name;
    }

    public Hardware(String type, String name, int maximumcCapacity, int maximumMemory) {
        this.type = type;
        this.name = name;

        setMaximumcCapacity(maximumcCapacity);
        setMaximumMemory(maximumMemory);
        this.currentCapacity = this.maximumcCapacity;
        this.currentMemory = this.maximumMemory;
        currentSoft = new ArrayList<>();
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getCurrentMemory() {
        return currentMemory;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public List<Software> getCurrentSoft() {
        return Collections.unmodifiableList(currentSoft);
    }

    public void setCurrentSoft(List<Software> currentSoft) {
        this.currentSoft = new ArrayList<>();
        this.currentSoft.addAll(currentSoft);
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getMaximumcCapacity() {
        return maximumcCapacity;
    }

    protected void setMaximumcCapacity(int maximumcCapacity) {
        this.maximumcCapacity = maximumcCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public void addSoft(Software soft) {
        if (this.currentCapacity > soft.capacityConsumption && this.currentMemory > soft.memoryConsumption) {
            currentSoft.add(soft);
            setMaximumcCapacity(this.currentCapacity - soft.capacityConsumption);
            setMaximumMemory(this.currentMemory - soft.memoryConsumption);
        }
    }

    public void remuveSoft(Software soft) {

        currentSoft.remove(soft);
        setMaximumcCapacity(this.currentCapacity + soft.capacityConsumption);
        setMaximumMemory(this.currentMemory + soft.memoryConsumption);
    }
}

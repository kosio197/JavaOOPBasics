package bg.softuni.kermen.model;

import java.util.ArrayList;
import java.util.List;

import bg.softuni.kermen.model.item.ElConsumer;

public abstract class Home {

    private int persons;
    protected int countRooms;
    protected double roomElectricCost;
    protected double profit;
    private List<ElConsumer> consumers;
    private List<Child> children;
    protected double currentMany;

    public Home(double profit, List<ElConsumer> consumers) {

        this.profit = profit;

        this.consumers = new ArrayList<>();
        this.consumers.addAll(consumers);
        this.children = new ArrayList<>();

    }

    protected void addChildren(List<Child> children) {
        this.children.addAll(children);
    }

    public double getAllConsumption() {
        double elcons = 0;
        for (ElConsumer elc : consumers) {
            elcons += elc.consumption;
        }

        double childCost = 0;
        for (Child child : children) {
            childCost += child.getChildCost();
        }
        return this.countRooms * this.roomElectricCost + elcons + childCost;
    }

    public void paySalary() {
        this.currentMany += profit;
    }

    public boolean payBills() {
        if (this.currentMany >= getAllConsumption()) {
            this.currentMany -= getAllConsumption();
            return true;
        } else {
            return false;
        }
    }

    public int getPersonsCount() {
        return persons + children.size();
    }

    protected void setPersonCount(int countPerson) {
        this.persons = countPerson;
    }

    protected void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    protected void setRoomElectricCost(double roomElectricCost) {
        this.roomElectricCost = roomElectricCost;
    }

}

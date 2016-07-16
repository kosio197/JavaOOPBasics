package bg.softuni.exam.kermen.model;

import java.util.List;

import bg.softuni.exam.kermen.model.item.ElConsumer;

public class YoungCoupleWithChildren extends YoungCouple {

    private static final int PERSONS = 2;
    private static final int ROOM_COUNT = 2;
    private static final double ROOM_CONSUMER = 30;

    public YoungCoupleWithChildren(double salary1, double salary2, List<ElConsumer> consumers, List<Child> children) {
        super(salary1, salary2, consumers);
        this.addChildren(children);
        this.setPersonCount(PERSONS);
        this.setCountRooms(ROOM_COUNT);
        this.setRoomElectricCost(ROOM_CONSUMER);
    }
}

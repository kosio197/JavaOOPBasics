package bg.softuni.exam.kermen.model;

import java.util.List;

import bg.softuni.exam.kermen.model.item.ElConsumer;

public class YoungCouple extends Couple {

    private static final int PERSONS = 2;
    private static final int ROOM_COUNT = 2;
    private static final double ROOM_CONSUMER = 20;

    public YoungCouple(double salary1, double salary2, List<ElConsumer> consumers) {
        super(salary1 + salary2, consumers);
        this.setPersonCount(PERSONS);
        this.setCountRooms(ROOM_COUNT);
        this.setRoomElectricCost(ROOM_CONSUMER);
    }
}

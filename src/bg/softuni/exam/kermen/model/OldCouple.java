package bg.softuni.exam.kermen.model;

import java.util.List;

import bg.softuni.exam.kermen.model.item.ElConsumer;

public class OldCouple extends Couple {

    private static final int PERSONS = 2;
    private static final int ROOM_COUNT = 3;
    private static final double ROOM_CONSUMER = 15;

    public OldCouple(double pension1, double pension2, List<ElConsumer> consumers) {
        super(pension1 + pension2, consumers);
        this.setPersonCount(PERSONS);
        this.setCountRooms(ROOM_COUNT);
        this.setRoomElectricCost(ROOM_CONSUMER);
    }
}

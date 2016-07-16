package bg.softuni.exam.kermen.model;

import java.util.List;

import bg.softuni.exam.kermen.model.item.ElConsumer;

public class AloneYoung extends Home {

    private static final int PERSONS = 1;
    private static final int ROOM_COUNT = 1;
    private static final double ROOM_CONSUMER = 10;

    public AloneYoung(double salary, List<ElConsumer> consumers) {
        super(salary, consumers);
        this.setPersonCount(PERSONS);
        this.setCountRooms(ROOM_COUNT);
        this.setRoomElectricCost(ROOM_CONSUMER);
    }
}

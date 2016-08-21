package bg.softuni.kermen.model;

import java.util.ArrayList;

import bg.softuni.kermen.model.item.ElConsumer;

public class AloneOld extends Home {

    private static final int PERSONS = 1;
    private static final int ROOM_COUNT = 1;
    private static final double ROOM_CONSUMER = 15;

    public AloneOld(double pension) {
        super(pension, new ArrayList<ElConsumer>());
        this.setPersonCount(PERSONS);
        this.setCountRooms(ROOM_COUNT);
        this.setRoomElectricCost(ROOM_CONSUMER);
    }
}

package bg.softuni.exam.kermen.model;

import java.util.List;

import bg.softuni.exam.kermen.model.item.ElConsumer;

public abstract class Couple extends Home {

    public Couple(double profit, List<ElConsumer> consumers) {
        super(profit, consumers);
    }

}

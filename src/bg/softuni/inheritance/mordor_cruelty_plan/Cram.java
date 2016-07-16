package bg.softuni.inheritance.mordor_cruelty_plan;

public class Cram extends FoodFactory {

    public Cram() {
        this("Cram", 2);
    }

    public Cram(String name, int point) {
        super(name, point);
    }
}

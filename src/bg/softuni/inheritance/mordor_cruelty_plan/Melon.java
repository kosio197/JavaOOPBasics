package bg.softuni.inheritance.mordor_cruelty_plan;

public class Melon extends FoodFactory {

    public Melon() {
        this("Melon", 1);
    }

    public Melon(String name, int point) {
        super(name, point);
    }

}

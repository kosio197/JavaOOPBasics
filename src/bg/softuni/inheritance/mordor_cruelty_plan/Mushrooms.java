package bg.softuni.inheritance.mordor_cruelty_plan;

public class Mushrooms extends FoodFactory {

    public Mushrooms() {
        this("Mushrooms", -10);
    }

    public Mushrooms(String name, int point) {
        super(name, point);
    }
}

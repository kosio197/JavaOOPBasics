package bg.softuni.inheritance.mordor_cruelty_plan;

public class EverythingElse extends FoodFactory {

    public EverythingElse() {
        this("EverythingElse", -1);
    }

    public EverythingElse(String name, int point) {
        super(name, point);
    }
}

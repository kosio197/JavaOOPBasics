package bg.softuni.inheritance.mordor_cruelty_plan;

public class Apple extends FoodFactory {

    public Apple() {
        this("Apple", 1);
    }

    public Apple(String name, int point) {
        super(name, point);
    }

}

package bg.softuni.mordor_cruelty_plan;

public class HoneyCake extends FoodFactory {

    public HoneyCake() {
        this("HoneyCake", 5);
    }

    public HoneyCake(String name, int point) {
        super(name, point);
    }
}

package bg.softuni.mordor_cruelty_plan;

public class Happy extends MoodFactory {

    public Happy(int point) {
        this("Happy", point);
    }

    public Happy(String name, int point) {
        super(name, point);
    }
}

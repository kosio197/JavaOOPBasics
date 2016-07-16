package bg.softuni.inheritance.mordor_cruelty_plan;

public class Angry extends MoodFactory {

    public Angry(int point) {
        this("Angry", point);
    }

    public Angry(String name, int point) {
        super(name, point);
    }

}

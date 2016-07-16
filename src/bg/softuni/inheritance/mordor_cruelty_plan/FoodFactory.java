package bg.softuni.inheritance.mordor_cruelty_plan;

public abstract class FoodFactory {

    protected String name;
    protected int point;

    public FoodFactory(String name, int point) {
        setName(name);
        setPoint(point);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}

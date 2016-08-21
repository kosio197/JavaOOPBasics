package bg.softuni.mordor_cruelty_plan;

public class MoodFactory {
    protected String name;
    protected int point;

    public MoodFactory(String name, int point) {
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

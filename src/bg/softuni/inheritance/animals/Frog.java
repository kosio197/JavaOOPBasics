package bg.softuni.inheritance.animals;

public class Frog extends Animals implements Voice {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }

}

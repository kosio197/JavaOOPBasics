package bg.softuni.inheritance.animals;

public class Kittens extends Cat {

    public Kittens(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}

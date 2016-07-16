package bg.softuni.inheritance.animals;

public class Dog extends Animals implements Voice {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }

}

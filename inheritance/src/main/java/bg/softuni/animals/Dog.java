package bg.softuni.animals;

public class Dog extends Animals implements Voice {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }

}

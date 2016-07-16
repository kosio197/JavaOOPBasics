package bg.softuni.inheritance.person;

public class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d", this.getName(), this.getAge()));

        return stringBuilder.toString();
    }
}

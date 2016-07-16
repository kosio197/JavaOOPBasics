package bg.softuni.inheritance.animals;

public abstract class Animals implements Voice {

    protected String name;
    protected String gender;
    protected int age;

    public Animals(String name, int age, String gender) {

        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }
    //
    // @Override
    // public String produceSound() {
    // return "Not implemented!";
    // }

}

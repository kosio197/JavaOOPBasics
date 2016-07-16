package bg.softuni.polimorphism.wildfarm;

public abstract class Animal {

    protected String animalName;
    protected String animalType;
    protected double animalWeigth;
    protected int foodEaten;

    public Animal(String animalName, String animalType, double animalWeigth) {
        setAnimalName(animalName);
        setAnimalType(animalType);
        setAnimalWeigth(animalWeigth);
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public double getAnimalWeigth() {
        return animalWeigth;
    }

    public void setAnimalWeigth(double animalWeigth) {
        this.animalWeigth = animalWeigth;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public void makeSound() {

    }

    public void eateFood(Food food) {

    }

}

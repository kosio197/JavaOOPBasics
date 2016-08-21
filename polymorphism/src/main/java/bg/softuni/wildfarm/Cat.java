package bg.softuni.wildfarm;

public class Cat extends Feline {

    private String breed;

    public Cat(String animalName, String animalType, double animalWeigth, String livingRegion, String breed) {
        super(animalName, animalType, animalWeigth, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eateFood(Food food) {
        this.foodEaten += food.cuantity;
    }
}

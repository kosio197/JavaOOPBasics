package bg.softuni.wildfarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeigth, String livingRegion) {
        super(animalName, animalType, animalWeigth, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eateFood(Food food) {
        if (food instanceof Vegitable) {
            this.foodEaten += food.cuantity;
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}

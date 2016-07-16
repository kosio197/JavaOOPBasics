package bg.softuni.polimorphism.wildfarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, double animalWeigth, String livingRegion) {
        super(animalName, animalType, animalWeigth, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eateFood(Food food) {
        if (food instanceof Vegitable) {
            this.foodEaten += food.cuantity;
            System.out.println("A cheese was just eaten!");
        } else {
            System.out.println("Mouses are not eating that type of food!");
        }
    }
}

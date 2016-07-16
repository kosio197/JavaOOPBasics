package bg.softuni.polimorphism.wildfarm;

public class Tiger extends Feline {

    public Tiger(String animalName, String animalType, double animalWeigth, String livingRegion) {
        super(animalName, animalType, animalWeigth, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eateFood(Food food) {

        if (food instanceof Meat) {
            this.foodEaten += food.cuantity;
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}

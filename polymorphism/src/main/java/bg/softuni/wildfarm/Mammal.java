package bg.softuni.wildfarm;

public abstract class Mammal extends Animal {

    protected String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeigth, String livingRegion) {
        super(animalName, animalType, animalWeigth);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override // Zebra[Doncho, 500, Africa, 150]
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(getAnimalWeigth());
        if (str.indexOf('.') > 0) {
            while (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
            }
        }

        sb.append(getAnimalType() + "[");
        sb.append(getAnimalName() + ", ");
        if (this instanceof Cat) {
            sb.append(((Cat) this).getBreed() + ", ");
        }
        sb.append(str + ", ");
        sb.append(getLivingRegion() + ", ");
        sb.append(getFoodEaten() + "]");

        return sb.toString();
    }
}

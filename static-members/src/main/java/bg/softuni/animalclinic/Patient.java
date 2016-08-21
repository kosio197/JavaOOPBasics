package bg.softuni.animalclinic;

public class Patient {

    private Animal animal;
    private int animalId;
    private String status;

    public Patient(Animal animal, int id, String status) {
        this.animal = animal;
        this.animalId = id;
        this.status = status;
    }

    public Animal getAnimal() {
        return animal;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Patient %d: [%s (%s)] has been %s!", animalId, animal.getName(), animal.getBreed(),
                status.equals("heal") ? "healed" : "rehabilitated");
    }
}

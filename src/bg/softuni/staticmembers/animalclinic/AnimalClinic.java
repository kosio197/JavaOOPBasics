package bg.softuni.staticmembers.animalclinic;

import java.util.ArrayList;
import java.util.List;

public class AnimalClinic {

    private static int patientId;
    private static int healedAnimalsCount;
    private static int rehabilitedAnimalsCount;

    public AnimalClinic() {
        patientId = 0;
        healedAnimalsCount = 0;
        rehabilitedAnimalsCount = 0;
    }

    public static int getPatientId() {
        return patientId;
    }

    public static int getHealedAnimalsCount() {
        return healedAnimalsCount;
    }

    public static int getRehabilitedAnimalsCount() {
        return rehabilitedAnimalsCount;
    }

    private static List<Animal> allHeals = new ArrayList<>();
    private static List<Animal> allRehabilited = new ArrayList<>();

    public static void addClient(String name, String breed, String status) {

        Animal animal = new Animal(name, breed);
        Patient pacient = new Patient(animal, ++patientId, status);

        if (status.equals("heal")) {
            allHeals.add(animal);
        } else {
            allRehabilited.add(animal);
        }

        System.out.println(pacient.toString());
    }

    public static String getHealdCount() {
        return String.format("Total healed animals: %d", allHeals.size());
    }

    public static String getRehabilitedCount() {
        return String.format("Total rehabilitated animals: %d", allRehabilited.size());
    }

    public static List<Animal> getAllHealed() {
        return new ArrayList<>(allHeals);
    }

    public static List<Animal> getAllRehabilited() {
        return new ArrayList<>(allRehabilited);
    }
}

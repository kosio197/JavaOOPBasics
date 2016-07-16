package bg.softuni.encapsulation.animalfarm;

public class Chicken {

    private static String ChickenName;
    private static int ChickenAge;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public static String getChickenName() {
        return ChickenName;
    }

    public static int getChickenAge() {
        return ChickenAge;
    }

    private static void setName(String name) {
        if (name == null || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        ChickenName = name;
    }

    private static void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        ChickenAge = age;
    }

    public String productPerDay() {
        return String.format("Chicken %s (age %d) can produce %d eggs per day.", ChickenName, ChickenAge,
                CalculateProductPerDay());
    }

    private static int CalculateProductPerDay() {
        switch (ChickenAge) {
            case 0:
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
            case 7:
                return 3;
            case 8:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                return 1;
        }
    }
}

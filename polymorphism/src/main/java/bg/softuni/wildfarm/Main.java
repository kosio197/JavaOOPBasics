package bg.softuni.wildfarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        while (!inp.equals("End")) {

            String animalInfo[] = inp.split("\\s+");
            String foodInfo[] = br.readLine().split("\\s+");

            Mammal mammal;
            Food food;
            switch (animalInfo[0]) {
                case "Cat":
                    mammal = new Cat(animalInfo[1], animalInfo[0], Double.valueOf(animalInfo[2]), animalInfo[3],
                            animalInfo[4]);
                    break;
                case "Tiger":
                    mammal = new Tiger(animalInfo[1], animalInfo[0], Double.valueOf(animalInfo[2]), animalInfo[3]);
                    break;
                case "Mouse":
                    mammal = new Mouse(animalInfo[1], animalInfo[0], Double.valueOf(animalInfo[2]), animalInfo[3]);
                    break;
                case "Zebra":
                    mammal = new Zebra(animalInfo[1], animalInfo[0], Double.valueOf(animalInfo[2]), animalInfo[3]);
                    break;

                default:
                    mammal = null;
                    break;
            }

            switch (foodInfo[0]) {
                case "Vegetable":
                    food = new Vegitable(Integer.parseInt(foodInfo[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodInfo[1]));
                    break;

                default:
                    food = null;
                    break;
            }

            if (mammal != null && food != null) {
                mammal.makeSound();
                mammal.eateFood(food);
                System.out.println(mammal);
            }
            inp = br.readLine();
        }
        br.close();
    }
}

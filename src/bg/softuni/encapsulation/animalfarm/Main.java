package bg.softuni.encapsulation.animalfarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int age = Integer.valueOf(br.readLine());

        br.close();
        try {

            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken.productPerDay());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

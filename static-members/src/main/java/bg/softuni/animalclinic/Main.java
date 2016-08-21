package bg.softuni.animalclinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals("End")) {

            String data[] = input.split("\\s+");
            String name = data[0];
            String breed = data[1];
            String status = data[2];

            AnimalClinic.addClient(name, breed, status);

            input = br.readLine();
        }

        System.out.println(AnimalClinic.getHealdCount());
        System.out.println(AnimalClinic.getRehabilitedCount());

        String command = br.readLine();
        br.close();

        if (command.equals("heal")) {
            for (Animal a : AnimalClinic.getAllHealed()) {
                System.out.println(a.getName() + " " + a.getBreed());
            }
        } else {
            for (Animal a : AnimalClinic.getAllRehabilited()) {
                System.out.println(a.getName() + " " + a.getBreed());
            }
        }
    }
}


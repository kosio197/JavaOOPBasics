package bg.softuni.animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        List<Animals> animals = new ArrayList<>();


        while (inp != null && !inp.trim().equals("") && !inp.equalsIgnoreCase("Beast!")) {
            try {
                String type = inp;
                inp = br.readLine();

                Animals a = null;

                String data[] = inp.split("\\s+");

                switch (type.toLowerCase()) {
                    case "cat":
                        a = new Cat(data[0], Integer.valueOf(data[1]), data[2]);
                        animals.add(a);

                        break;
                    case "dog":
                        a = new Dog(data[0], Integer.valueOf(data[1]), data[2]);
                        animals.add(a);

                        break;
                    case "frog":
                        a = new Frog(data[0], Integer.valueOf(data[1]), data[2]);
                        animals.add(a);

                        break;
                    case "tomcat":
                        a = new Tomcat(data[0], Integer.valueOf(data[1]), "Male");
                        animals.add(a);

                        break;
                    case "kitten":
                        a = new Kittens(data[0], Integer.valueOf(data[1]), "Female");

                        break;
                    default:
                        System.out.println("not implemented!");
                        break;
                }

                if (a != null) {
                    System.out.printf("%s \n%s %d %s\n%s\n", type, a.getName(), a.getAge(), a.getGender(),
                            a.produceSound());
                }



            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            inp = br.readLine();
        }
    }
}

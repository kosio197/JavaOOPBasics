package bg.softuni.encapsulation.shoppingspree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static Map<String, Person> persons = new LinkedHashMap<>();
    private static Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String allPersons[] = br.readLine().split(";");

        try {
            for (String str : allPersons) {
                String next[] = str.split("=");
                Person nextPerson = new Person(next[0], Double.valueOf(next[1]));
                persons.put(next[0], nextPerson);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String allProducts[] = br.readLine().split(";");

        try {
            for (String str : allProducts) {
                String next[] = str.split("=");
                Product nextProduct = new Product(next[0], Double.valueOf(next[1]));
                products.put(next[0], nextProduct);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = br.readLine();
        while (!command.equalsIgnoreCase("END") && command.split(" ").length == 2) {

            processCommand(command);
            command = br.readLine();
        }

        printResult();
    }

    private static void printResult() {

        for (Map.Entry<String, Person> e : persons.entrySet()) {
            Person p = e.getValue();
            System.out.print(p.getName() + " - ");
            if (p.getBag().size() == 0) {
                System.out.print("Nothing bought");
            } else {
                for (int i = 0; i < p.getBag().size() - 1; i++) {
                    System.out.print(p.getBag().get(i).getName() + ", ");
                }
                System.out.print(p.getBag().get(p.getBag().size() - 1).getName());
            }
            System.out.println();
        }
    }

    private static void processCommand(String command) {

        Person person = persons.get(command.split(" ")[0]);
        Product product = products.get(command.split(" ")[1]);

        if (person == null || product == null) {
            return;
        }
        if (person.getMoney() >= product.getCost()) {
            person.addToBag(product);
            person.setMoney(person.getMoney() - product.getCost());
            System.out.printf("%s bought %s\n", person.getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s\n", person.getName(), product.getName());
        }
    }
}

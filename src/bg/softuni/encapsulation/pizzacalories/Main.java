package bg.softuni.encapsulation.pizzacalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bg.softuni.encapsulation.pizzacalories.Dough.Technique;
import bg.softuni.encapsulation.pizzacalories.Dough.Type;
import bg.softuni.encapsulation.pizzacalories.Topping.ToppingType;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        Pizza pizza = null;
        double numberOfToppic = 0;

        while (!inp.equals("END")) {
            String data[] = inp.split("\\s+");
            Dough d;
            Topping t;

            switch (data[0]) {
                case "Dough":
                    try {
                        d = new Dough(Type.valueOf(data[1].toUpperCase()),
                                Technique.valueOf(data[2].toUpperCase()), Double.valueOf(data[3]));

                        if (pizza == null) {
                            System.out.printf("%.2f\n", d.getCal());

                        } else {
                            pizza.setDough(d);
                        }


                    } catch (IllegalArgumentException e) {
                        if (e.getMessage().startsWith("No enum")) {
                            System.out.println("Invalid type of dough.");
                            return;
                        } else {
                            System.out.println(e.getMessage());
                            return;
                        }
                    }
                    break;

                case "Topping":

                    try {
                        t = new Topping(ToppingType.valueOf(data[1].toUpperCase()), Double.valueOf(data[2]));

                        if (pizza == null) {
                            System.out.printf("%.2f\n", t.getToppicCall());
                        } else {
                            pizza.addTopping(t);
                            numberOfToppic--;
                            if (numberOfToppic < 0) {
                                break;
                            }
                        }

                    } catch (IllegalArgumentException e) {
                        if (e.getMessage().startsWith("No enum")) {
                            System.out.printf("Cannot place %s on top of your pizza.\n", data[1]);
                            return;
                        } else {
                            System.out.printf("%s weight should be in the range [1..50].", data[1]);
                            return;
                        }
                    }

                    break;

                case "Pizza":
                    try {
                        numberOfToppic = Double.valueOf(data[2]);
                        if (numberOfToppic < 0 || numberOfToppic > 10) {
                            System.out.println("Number of toppings should be in range [0..10].");
                            return;
                        }
                        pizza = new Pizza(data[1]);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return;
                    }
                    break;

                default:
                    throw new RuntimeException();

            }

            inp = br.readLine();
        }

        br.close();
        if (pizza != null) {
            System.out.printf("%s - %.2f Calories.", pizza.getName(), pizza.getAllCaloryes());
        }
    }
}

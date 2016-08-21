package bg.softuni.pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name) {
        setName(name);
        toppings = new ArrayList<>(10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("") || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping t) {

        toppings.add(t);
    }

    public double getAllCaloryes() {
        double result = dough.getCal();
        for (Topping topping : toppings) {
            result += topping.getToppicCall();
        }
        return result;
    }
}

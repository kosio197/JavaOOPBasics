package bg.softuni.pizzacalories;

public class Topping {
    public enum ToppingType {
        MEAT(1.2), VEGGIES(0.8), CHEESE(1.1), SAUCE(0.9);

        private double cal;

        private ToppingType(double cal) {
            this.cal = cal;
        }

        public double getCal() {
            return cal;
        }
    }

    private ToppingType type;
    private double toppingGrams;

    public Topping(ToppingType type, double grams) {
        this.type = type;
        setToppingGrams(grams);
    }


    public ToppingType getType() {
        return type;
    }

    public double getToppingGrams() {
        return toppingGrams;
    }

    public void setToppingGrams(double grams) {
        if (grams < 1 || grams > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", type.name()));
        }
        toppingGrams = grams;
    }

    public double getToppicCall() {
        return (2 * toppingGrams) * type.getCal();
    }
}

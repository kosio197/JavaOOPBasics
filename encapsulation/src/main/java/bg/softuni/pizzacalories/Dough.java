package bg.softuni.pizzacalories;

public class Dough {

    public enum Type {

        WHITE(1.5), WHOLEGRAIN(1);

        private double cal;

        private Type(double cal) {
            this.cal = cal;
        }

        public double getCal() {
            return cal;
        }
    }

    public enum Technique {

        CRISPY(0.9), CHEWY(1.1), HOMEMADE(1.0);

        private double cal;

        private Technique(double cal) {
            this.cal = cal;
        }

        public double getCal() {
            return cal;
        }
    }

    private Type type;
    private Technique technique;
    private double grams;

    public Dough(Type type, Technique technique, double grams) {
        this.type = type;
        this.technique = technique;
        setGrams(grams);
    }

    public Type getType() {
        return type;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public void setGrams(double grams) {
        if (grams < 1 || grams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.grams = grams;
    }

    public double getCal() {// (2 * 100) * 1.5 * 1.1 =
        return (2 * grams) * type.getCal() * technique.getCal();
    }
}

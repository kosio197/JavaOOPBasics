package bg.softuni.planckconstant;

public class Calculation {

    private static final double planck;
    private static final double pi;

    static {
        planck = 6.62606896e-34;
        pi = 3.14159;
    }

    public static double getCalc() {
        return planck / (2 * pi);
    }
}

package bg.softuni.staticmembers.basicmath;

public class MathUtil {

    private double a;
    private double b;

    public MathUtil(double a, double b) {
        this.a = a;
        this.b = b;
    }


    public double getA() {
        return a;
    }


    public double getB() {
        return b;
    }


    public static double getSum(double a, double b) {
        return a + b;
    }

    public static double getSubtract(double a, double b) {
        return a - b;
    }

    public static double getMultiply(double a, double b) {
        return a * b;
    }

    public static double getDivide(double dividend, double divisor) {
        return dividend / divisor;
    }

    public static double getPercentage(double totalNumber, double percentOfNumber) {
        return (totalNumber * percentOfNumber) / 100;
    }

    public static void printResult(double value) {
        System.out.printf("%.2f\n", value);
    }
}

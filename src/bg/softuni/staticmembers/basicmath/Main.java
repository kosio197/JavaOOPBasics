package bg.softuni.staticmembers.basicmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            double a = Double.valueOf(input.split(" ")[1]);
            double b = Double.valueOf(input.split(" ")[2]);
            double value = 0;

            switch (command) {
                case "Sum":
                    value = MathUtil.getSum(a, b);
                    break;
                case "Subtract":
                    value = MathUtil.getSubtract(a, b);
                    break;
                case "Multiply":
                    value = MathUtil.getMultiply(a, b);
                    break;
                case "Divide":
                    value = MathUtil.getDivide(a, b);
                    break;
                case "Percentage":
                    value = MathUtil.getPercentage(a, b);
                    break;
                default:
                    break;
            }
            MathUtil.printResult(value);
            input = br.readLine();
        }
    }
}

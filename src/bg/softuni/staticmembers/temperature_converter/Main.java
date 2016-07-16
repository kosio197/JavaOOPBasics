package bg.softuni.staticmembers.temperature_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /*
         * T(°F) = T(°C) × 9/5 + 32 T(°F) = T(°C) × 1.8 + 32
         */
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            switch (data[1]) {
                case "Celsius":
                    Fahrenheit frh = new Fahrenheit(Double.valueOf(data[0]));
                    System.out.println(frh.toString());
                    break;

                case "Fahrenheit":
                    Celsius cel = new Celsius(Double.valueOf(data[0]));
                    System.out.println(cel.toString());
                    break;
                default:
                    break;
            }

            input = br.readLine();
        }
        br.close();
    }
}

package bg.softuni.staticmembers.beercounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            BeerCounter.BuyBeer(Integer.valueOf(data[0]));
            BeerCounter.DrinkBeer(Integer.valueOf(data[1]));
            input = br.readLine();
        }
        br.close();
        System.out.println(BeerCounter.getBeerInStock() + " " + BeerCounter.getBeersDrankCount());
    }
}

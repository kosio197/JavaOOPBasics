package bg.softuni.kermen.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;

import bg.softuni.kermen.factory.FactoryHome;
import bg.softuni.kermen.model.Home;
import bg.softuni.kermen.repository.City;

public class Main {

    private static City city = new City();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        int inputCounter = 1;
        while (!inp.equals("Democracy")) {
            if (inputCounter++ % 3 == 0) {
                if (inp.startsWith("EVN bill")) {
                    city.paySalary();
                    processInputData(inp);
                    inp = br.readLine();
                    continue;
                }else {
                    processInputData(inp);
                    city.paySalary();
                    inp = br.readLine();
                    continue;
                }
            }

            processInputData(inp);

            inp = br.readLine();
        }
        br.close();
        printTotalPopulation();
    }

    private static void processInputData(String inp) {

        switch (inp) {
            case "EVN bill":
                city.payBill();
                break;
            case "EVN":
                printTotalConsumption();
                break;

            default:
                city.addHome(FactoryHome.createNewHome(inp));
                break;
        }
    }


    static List<Home> homes = city.getAllHome();
    private static void printTotalPopulation() {
        int total = 0;

        for (Home home : homes) {
            total += home.getPersonsCount();
        }

        System.out.printf("Total population: %d", total);
    }

    private static void printTotalConsumption() {

        DecimalFormat format = new DecimalFormat("0.0############################");
        double total = 0;
        for (Home home : homes) {
            total += home.getAllConsumption();
        }

        System.out.printf("Total consumption: %s\n", format.format(total));
    }
}


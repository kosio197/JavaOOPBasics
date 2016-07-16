package bg.softuni.exam.systemsplit.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import bg.softuni.exam.systemsplit.factory.FactoryHard;
import bg.softuni.exam.systemsplit.factory.FactorySoft;
import bg.softuni.exam.systemsplit.model.Hardware;
import bg.softuni.exam.systemsplit.model.Software;
import bg.softuni.exam.systemsplit.repository.MySystem;

public class Main {

    private static MySystem system = new MySystem();

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String command = br.readLine();
        while (!command.equals("System Split")) {
            makeCommand(command);
            command = br.readLine();
        }

        printInfoAboutSystem();
    }

    private static void makeCommand(String command) {

        if (command.startsWith("RegisterPowerHardware") || command.startsWith("RegisterHeavyHardware")) {
            system.addHardwarer(FactoryHard.processHardCommand(command));

        } else if (command.startsWith("RegisterExpressSoftware") || command.startsWith("RegisterLightSoftware")) {

            Hardware hard = null;
            String commandInfo[] = command.substring(0, command.length() - 1).split("\\(");
            for (Hardware h : system.getHarduers()) {
                if (h.getName().equals(commandInfo[1].split(",")[0].trim())) {
                    hard = h;
                }
            }
            if (hard != null)
                FactorySoft.processSoftComand(hard, command);

        } else if (command.startsWith("ReleaseSoftwareComponent")) {

            remuveSoft(command);

        } else if (command.startsWith("Analyze()")) {
            prntStatistic();
        }
    }

    private static void remuveSoft(String command) {

        String inp = command.substring(0, command.length() - 1).split("\\(")[1];
        String hardName = inp.split(",")[0].trim();
        String softName = inp.split(",")[1].trim();
        for (Hardware hard : system.getHarduers()) {
            if (hard.getName().equals(hardName)) {
                Iterator<Software> iterator = hard.getCurrentSoft().iterator();
                while (iterator.hasNext()) {
                    Software soft = iterator.next();
                    if (soft.getName().equals(softName)) {
                        hard.remuveSoft(soft);
                    }
                }
            }
        }
    }

    private static void printInfoAboutSystem() {
        // TODO Auto-generated method stub

    }

    private static void prntStatistic() {

        long softCount = 0;
        long totalmemoryUsed = 0;
        long maxMemory = 0;
        long totalCapacityUsed = 0;
        long maxCapacity = 0;

        for (Hardware hard : system.getHarduers()) {
            totalmemoryUsed += hard.getMaximumMemory() - hard.getCurrentMemory();
            maxMemory += hard.getMaximumMemory();
            totalCapacityUsed += hard.getMaximumcCapacity() - hard.getCurrentCapacity();
            maxCapacity += hard.getMaximumcCapacity();
            softCount += hard.getCurrentSoft().size();
        }

        System.out.println("System Analysis");
        System.out.printf("Hardware Components: %d\n", system.getHarduers().size());
        System.out.printf("Software Components: %d\n", softCount);
        System.out.printf("Total Operational Memory: %d | %d\n", totalmemoryUsed, maxMemory);
        System.out.printf("Total Capacity Taken: %d | %d\n", totalCapacityUsed, maxCapacity);
    }
}

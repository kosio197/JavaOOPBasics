package bg.softuni.systemsplit.factory;

import bg.softuni.systemsplit.model.ExpressSoftware;
import bg.softuni.systemsplit.model.Hardware;
import bg.softuni.systemsplit.model.LightSoftware;

public class FactorySoft {

    public static Hardware processSoftComand(Hardware hard, String command) {
        // RegisterExpressSoftware(hardwareComponentName, name, capacity,
        // memory)

        String commandInfo[] = command.substring(0, command.length() - 1).split("\\(");
        String softInfo[] = commandInfo[1].split(",");

        String name = softInfo[1].trim();
        int capacity = Integer.valueOf(softInfo[2].trim());
        int memory = Integer.valueOf(softInfo[3].trim());

        switch (commandInfo[0]) {
            case "RegisterExpressSoftware":
                hard.addSoft(new ExpressSoftware("ExpressSoftware", name, capacity, memory));
                break;
            case "RegisterLightSoftware":
                hard.addSoft(new LightSoftware("LightSoftware", name, capacity, memory));
                break;
        }

        return hard;
    }

}

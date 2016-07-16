package bg.softuni.exam.systemsplit.factory;

import bg.softuni.exam.systemsplit.model.Hardware;
import bg.softuni.exam.systemsplit.model.HeavyHardware;
import bg.softuni.exam.systemsplit.model.PowerHardware;

public class FactoryHard {

    public static Hardware processHardCommand(String command) { // RegisterPowerHardware(name,
        // capacity, memory)

        String commandInfo[] = command.substring(0, command.length() - 1).split("\\(");
        String softInfo[] = commandInfo[1].split(",");
        String name = softInfo[0].trim();
        int capacity = Integer.valueOf(softInfo[1].trim());
        int memory = Integer.valueOf(softInfo[2].trim());

        Hardware hard;
        switch (commandInfo[0]) {
            case "RegisterPowerHardware":
                hard = new PowerHardware("PowerHardware", name, capacity, memory);
                break;
            case "RegisterHeavyHardware":
                hard = new HeavyHardware("HeavyHardware", name, capacity, memory);
                break;
            default:
                hard = null;
                break;
        }

        return hard;
    }

}

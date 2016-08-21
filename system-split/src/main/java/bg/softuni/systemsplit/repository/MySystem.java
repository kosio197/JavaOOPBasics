package bg.softuni.systemsplit.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.softuni.systemsplit.model.Hardware;

public class MySystem {

    private List<Hardware> hardware;

    public MySystem() {
        this.hardware = new ArrayList<>();
    }

    public List<Hardware> getHarduers() {
        return Collections.unmodifiableList(hardware);
    }

    public void setHarduers(List<Hardware> hardware) {

        this.hardware = new ArrayList<>();
        this.hardware.addAll(hardware);
    }

    public void addHardwarer(Hardware hard) {
        hardware.add(hard);
    }

    public void removeHardwarer(Hardware hard) {
        hardware.remove(hard);
    }

}

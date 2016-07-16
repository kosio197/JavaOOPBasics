package bg.softuni.exam.kermen.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import bg.softuni.exam.kermen.model.Home;

public class City {

    private List<Home> homes;

    public City() {
        this.homes = new ArrayList<>();
    }

    public void addHome(Home home) {
        homes.add(home);
    }

    public List<Home> getAllHome() {
        return Collections.unmodifiableList(homes);
    }

    public void paySalary() {
        for (Home home : homes) {
            home.paySalary();
        }
    }

    public void payBill() {
        Iterator<Home> iterator = homes.iterator();

        while (iterator.hasNext()) {
            Home home = iterator.next();
            if (!home.payBills()) {
                iterator.remove();
            }
        }
    }
}

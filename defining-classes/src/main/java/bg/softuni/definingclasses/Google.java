package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Google {

    static class Car {
        String model;
        String speed;

        public Car(String model, String speed) {
            this.model = model;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return model + " " + speed;
        }
    }

    static class Company {
        String name;
        String department;
        String salary;

        public Company(String name, String department, String salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " " + department + " " + salary;
        }
    }

    static class Pokemon {
        String name;
        String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return name + " " + type;
        }
    }

    static class Parent {
        String name;
        String birthday;

        public Parent(String name, String birthday) {
            this.birthday = birthday;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " " + birthday;
        }
    }

    static class Children {
        String name;
        String birthday;

        public Children(String name, String birthday) {
            this.birthday = birthday;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " " + birthday;
        }
    }

    static class Person {

        String name;
        Company company;
        Car car;
        List<Parent> parents;
        List<Children> childrens;
        List<Pokemon> pokemons;

        public Person(String name) {
            this.name = name;
            this.parents = new ArrayList<>();
            this.childrens = new ArrayList<>();
            this.pokemons = new ArrayList<>();
        }

    }

    private static Map<String, Person> persons = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        while (!data.equals("End")) {
            addPersons(data);
            data = br.readLine();
        }

        String name = br.readLine();
        printData(name);
    }

    private static void addPersons(String data) {

        String str[] = data.split("\\s");
        Person p = persons.get(str[0]);
        if (p == null) {
            p = new Person(str[0]);
            persons.put(str[0], p);
        }
        switch (str[1]) {
            case "company":
                p.company = new Company(str[2], str[3], str[4]);
                break;
            case "pokemon":
                p.pokemons.add(new Pokemon(str[2], str[3]));
                break;
            case "parents":
                p.parents.add(new Parent(str[2], str[3]));
                break;
            case "children":
                p.childrens.add(new Children(str[2], str[3]));
                break;
            case "car":
                p.car = new Car(str[2], str[3]);
                break;
            default:
                break;
        }
    }

    private static void printData(String name) {

        Person p = persons.get(name);
        StringBuilder sb = new StringBuilder();

        sb.append(name + "\n");
        sb.append("Company:\n");
        sb.append(p.company == null? "": p.company.toString()+"\n");
        sb.append("Car:\n");
        sb.append(p.car==null? "": p.car.toString()+"\n");
        sb.append("Pokemon:\n");
        if (p.pokemons != null) {
            for (Pokemon pok : p.pokemons) {
                sb.append(pok + "\n");
            }
        }
        sb.append("Parents:\n");
        if (p.parents.size() > 0) {
            for (Parent par : p.parents) {
                sb.append(par.toString() + "\n");
            }
        }
        sb.append("Children:\n");
        if (p.childrens.size() > 0) {
            for (Children c : p.childrens) {
                sb.append(c.toString() + "\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}

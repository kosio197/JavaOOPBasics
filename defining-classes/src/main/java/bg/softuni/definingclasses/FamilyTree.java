package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    static class Person {

        String name;
        String birthData;
        Person children;

        public Person(String name, String birthData) {
            this.name = name;
            this.birthData = birthData;
        }

        @Override
        public String toString() {
            return name + " " + birthData + " : " + children.name + " " + children.birthData;
        }
    }

    private static List<Person> persons = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();
        Person par;
        if (isDigit(data)) {
            par = new Person("zero", data);
        } else {
            par = new Person(data, "zero");

        }
        persons.add(par);

        data = br.readLine();
        while (!data.equals("End")) {
            addPersonsData(data);
            data = br.readLine();
        }
        br.close();
        printData();
    }

    private static void printData() {

        Person zero = persons.get(0);
        System.out.println(zero.name + " " + zero.birthData + "\nParents:");
        for (int i = 1; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.children.name.equals(zero.name) || p.children.birthData.equals(zero.birthData))
                System.out.println(p.name + " " + p.birthData);
        }
        System.out.println("Children:");
        for (int i = 1; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.name.equals(zero.name) || p.birthData.equals(zero.birthData))
                System.out.println(p.children.name + " " + p.children.birthData);
        }
    }

    private static void addPersonsData(String data) {

        String first;
        String last;

        if (!data.contains("-")) {
            first = data.split(" ")[0] + " " + data.split(" ")[1];
            last = data.split(" ")[2];

            for (int i = 0; i < persons.size(); i++) {
                Person p = persons.get(i);
                if (p.name.equals(first)) {
                    p.birthData = last;

                } else if (p.birthData.equals(last)) {
                    p.name = first;

                } else if (i != 0 && p.children.name.equals(first)) {
                    p.children.birthData = last;

                } else if (i != 0 && p.children.birthData.equals(last)) {
                    p.children.name = first;

                }
            }
            return;
        }

        data = data.replace('-', ' ');
        String[] inp = data.split("\\s+");

        if (inp.length == 2) {
            first = inp[0];
            last = inp[1];
        } else if (inp.length == 4) {
            first = inp[0] + " " + inp[1];
            last = inp[2] + " " + inp[3];
        } else {
            if (isDigit(inp[0])) {
                first = inp[0];
                last = inp[1] + " " + inp[2];
            } else {
                first = inp[0] + " " + inp[1];
                last = inp[2];
            }
        }

        Person par;
        Person cld;

        if (isDigit(first)) {
            par = new Person("", first);
        } else {
            par = new Person(first, "");
        }

        if (isDigit(last)) {
            cld = new Person("", last);
        } else {
            cld = new Person(last, "");
        }

        par.children = cld;
        persons.add(par);
    }

    private static boolean isDigit(String str) {
        return str.charAt(0) > 47 && str.charAt(0) < 58;
    }
}

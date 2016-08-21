package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OpinionPoll {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name) {
            this(name, 1);
        }

        public Person(int age) {
            this("No name", age);
        }

        public Person() {
            this("No name", 1);
        }
    }
    private static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());
        for (int i = 0; i < count; i++) {
            String personData[] = br.readLine().split("\\s+");
            persons.add(new Person(personData[0], Integer.valueOf(personData[1])));
        }
        br.close();

        List<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.age > 30) {
                result.add(p);
            }
        }
        Collections.sort(result, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        for (Person p : result) {
            System.out.println(p.name + " - " + p.age);
        }
    }
}

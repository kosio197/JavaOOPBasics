package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private String occupation;
    private int age;

    public Person(String name, String occupation, int age) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation(){
        return occupation;
    }

    @Override
    public String toString() {
        return name + " - age: " + age + ", occupation: " + occupation;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.getAge();
    }
}

public class PrintPeople {
    private static List<Person> persons = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        while (!line.equals("END")) {
            String[] data = line.split("\\s+");

            persons.add(new Person(data[0], data[2], Integer.valueOf(data[1])));

            line = br.readLine();
        }

        br.close();

        persons.stream().sorted().forEach(p -> System.out.println(p.toString()));

    }
}

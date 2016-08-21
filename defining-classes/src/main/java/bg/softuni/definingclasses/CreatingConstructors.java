package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class CreatingConstructors {

    public static class Person {
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
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class<Person> personClass = Person.class;
        Constructor<Person> emptyCtor = personClass.getDeclaredConstructor();
        Constructor<Person> ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor<Person> nameAgeCtor = personClass.getDeclaredConstructor(String.class, int.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person basePerson = emptyCtor.newInstance();
        Person personWithAge = ageCtor.newInstance(age);
        Person personFull = nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }
}

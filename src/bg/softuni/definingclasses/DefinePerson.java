package bg.softuni.definingclasses;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;
}

public class DefinePerson {

    public static void main(String[] args) throws Exception {
        Class<Person> person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}

package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OldestFamilyMember {

    static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    static class Family {

        private List<Person> persons;

        public Family() {
            this.persons = new ArrayList<>();
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }

        public void addFamilyMember(Person member) {
            persons.add(member);
        }

        public Person getOldestMember(){

            int temp = -1000000;
            int index=0;
            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).age > temp) {
                    temp = persons.get(i).age;
                    index = i;
                }
            }
            return persons.get(index);
        }

    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException,
    NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        Family family = new Family();
        for (int i = 0; i < n; i++) {
            String[] inp = br.readLine().split("\\s+");
            Person member = new Person(inp[0], Integer.valueOf(inp[1]));
            family.addFamilyMember(member);
        }

        Person oldPerson = family.getOldestMember();
        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addFamilyMember", Person.class);

        System.out.println(oldPerson.name + " " + oldPerson.age);
    }
}

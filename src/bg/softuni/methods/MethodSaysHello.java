package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MethodSaysHello {

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String sayHello() {
            return String.format("%s says \"Hello\"!", name);
        }
    }

    public static void main(String[] args) throws SecurityException, ClassNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        Person p = new Person(name);
        System.out.println(p.sayHello());
    }
}

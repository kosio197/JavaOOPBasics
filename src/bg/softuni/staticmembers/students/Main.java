package bg.softuni.staticmembers.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        StudentGroup sgroup = new StudentGroup();

        while (!name.equals("End")) {
            Student student = new Student(name);
            sgroup.getSet().add(student.getName());
            name = br.readLine();
        }
        br.close();

        System.out.println(sgroup.getSet().size());
    }
}

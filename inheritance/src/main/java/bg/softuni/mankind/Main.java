package bg.softuni.mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Student student = tryCreateStudent(br.readLine());
        if (student == null)
            return;
        Worker worker = tryCreateWorker(br.readLine());
        if (worker == null)
            return;

        br.close();


        printResult(student, worker);
    }

    private static void printResult(Student student, Worker worker) {
        System.out.println(student.toString());
        System.out.println(worker.toString());
    }

    private static Worker tryCreateWorker(String inp) {
        Worker worker = null;

        try {
            String data[] = inp.split(" ");
            if (data.length == 4) {
                worker = new Worker(data[0], data[1], Double.valueOf(data[2]), Double.valueOf(data[3]));
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return worker;
    }

    private static Student tryCreateStudent(String inp) {
        Student student = null;

        try {
            String data[] = inp.split(" ");
            student = new Student(data[0], data[1], data[2]);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return student;
    }
}

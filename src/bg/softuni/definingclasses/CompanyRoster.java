package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyRoster {

    private static class Employee { // name, salary, position, department, email
        // and age

        String name;
        double salary;
        @SuppressWarnings("unused")
        String position;
        String department;
        String email;
        int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }
    }

    private static Map<String, List<Employee>> departmentAverage = new HashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countInput = Integer.valueOf(br.readLine());
        for (int i = 0; i < countInput; i++) {
            processInput(br.readLine());
        }

        printDepartment(getHighAverage());
    }

    private static void printDepartment(String highAverage) {
        System.out.println("Highest Average Salary: " + highAverage);

        List<Employee> resultList = departmentAverage.get(highAverage);
        Collections.sort(resultList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.salary != e2.salary) {
                    return e1.salary > e2.salary ? -1 : 1;
                } else {
                    return 0;
                }
            }
        });

        for (Employee e : resultList) {
            System.out.printf("%s %.2f %s %d\n", e.name, e.salary, e.email, e.age);
        }
    }

    private static String getHighAverage() {

        String result = "";
        double maxDep = Double.MIN_VALUE;
        for (Map.Entry<String, List<Employee>> map : departmentAverage.entrySet()) {
            double temp = 0;
            for (Employee e : map.getValue()) {
                temp += e.salary;
            }
            if (temp > maxDep) {
                maxDep = temp;
                result = map.getKey();
            }
        }
        return result;
    }

    private static void processInput(String line) {
        String data[] = line.split("\\s+");
        Employee next = new Employee(data[0], Double.valueOf(data[1]), data[2], data[3]);
        if (data.length > 4) {
            if (data[4].indexOf('@') >= 0) {
                next.email = data[4];
            } else {
                next.age = Integer.valueOf(data[4]);
            }
        }
        if (data.length > 5) {
            next.age = Integer.valueOf(data[5]);
        }
        List<Employee> empList = departmentAverage.get(data[3]);
        if (empList == null) {
            empList = new ArrayList<>();
            departmentAverage.put(next.department, empList);
        }
        departmentAverage.get(data[3]).add(next);
    }
}

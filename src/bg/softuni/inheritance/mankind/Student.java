package bg.softuni.inheritance.mankind;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Human {

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {

        Pattern p = Pattern.compile("([a-zA-Z0-9]+)$");
        Matcher m = p.matcher(facultyNumber);

        if (!m.matches() || facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {

        return String.format("First Name: %s\nLast Name: %s\nFaculty number: %s\n", firstName, lastName, facultyNumber);
    }
}

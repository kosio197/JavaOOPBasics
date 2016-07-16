package bg.softuni.inheritance.mankind;

public class Human {

    protected String firstName;
    protected String lastName;

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        char c = firstName.charAt(0);
        if (c < 65 || c > 90) {
            throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");
        }

        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
        }

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        char c = lastName.charAt(0);
        if (c < 65 || c > 90) {
            throw new IllegalArgumentException("Expected upper case letter! Argument: lastName");
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols! Argument: lastName");
        }

        this.lastName = lastName;
    }
}

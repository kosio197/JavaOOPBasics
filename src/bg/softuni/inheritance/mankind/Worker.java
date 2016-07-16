package bg.softuni.inheritance.mankind;

public class Worker extends Human {

    private double weekSalary;
    private double workHours;

    public Worker(String firstName, String lastName, double weekSalary, double workHours) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHours(workHours);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        if (workHours < 1 || workHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch! Argument: workHoursPerDay");
        }

        this.workHours = workHours;
    }

    private double getSalaryPerHour() {
        return weekSalary / (workHours * 7);
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols! Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return String.format(
                "First Name: %s\nLast Name: %s\nWeek Salary: %.2f\nHours per day: %.2f\nSalary per hour: %.2f",
                firstName, lastName, weekSalary, workHours, getSalaryPerHour());
    }

}

package employee;

import java.time.LocalDate;

public abstract class Employee {
    protected int ID;
    protected String FirstName, LastName;
    protected LocalDate Birthday, DateOfEmployment;

    public Employee(int ID, String FirstName, String LastName,
                       LocalDate Birthday, LocalDate DateOfEmployment) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthday = Birthday;
        this.DateOfEmployment = DateOfEmployment;
    }

    public abstract double getSalariedCoefficient();
    public abstract double calculateSalary();

    public int getID() {
        return ID;
    }
}


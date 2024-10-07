package employee;

import java.time.LocalDate;

public class Employee {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalariedCoefficient() {
        double SalariedCoefficient = 0;
        return SalariedCoefficient;
    }

    public double calculateSalary() {
        return 0;
    }
}


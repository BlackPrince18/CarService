package employee;

import java.time.LocalDate;

public class Employee {
    protected int ID;
    protected String FirstName, LastName;
    protected LocalDate Birthday, DateOfEmployment;
    protected double SalariedCoefficient;

    protected Employee(int ID, String FirstName, String LastName,
                       LocalDate Birthday, LocalDate DateOfEmployment) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthday = Birthday;
        this.DateOfEmployment = DateOfEmployment;
        this.SalariedCoefficient = 2;
    }
}


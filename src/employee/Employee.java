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

<<<<<<< HEAD
    public abstract double getSalariedCoefficient();
    public abstract double calculateSalary();

    public int getID() {
        return ID;
=======
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
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
    }
}


package employee;

import java.time.LocalDate;
import java.time.Period;

public final class Director extends Employee {
    private final double SalariedCoefficient = 2;

    public Director(int ID, String FirstName, String LastName,
                    LocalDate Birthday, LocalDate DateOfEmployment) {
        super(ID, FirstName, LastName, Birthday, DateOfEmployment);
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Director\n" + FirstName + " " + LastName
                + "\nID: " + ID + "\nBirthday: " + Birthday +
                "\nDate Of Employment: " + DateOfEmployment + '\n';
    }
=======
        String result = "Director\n" + FirstName + " " + LastName
                + "\nID: " + ID + "\nBirthday: " + Birthday +
                "\nDate Of Employment: " + DateOfEmployment + '\n';
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f

    @Override
    public double getSalariedCoefficient() {
        return SalariedCoefficient;
    }

    @Override
    public double calculateSalary() {
        LocalDate today = LocalDate.now();

        if(today.getYear() == DateOfEmployment.getYear()) return 1 * SalariedCoefficient * 1000;
        else return Period.between(DateOfEmployment, today).getYears() * SalariedCoefficient * 1000;
    }

    @Override
    public double getSalariedCoefficient() {
        return SalariedCoefficient;
    }

    @Override
    public double calculateSalary() {
        LocalDate today = LocalDate.now();

        if(today.getYear() == DateOfEmployment.getYear()) return 1 * SalariedCoefficient * 1000;
        else return Period.between(DateOfEmployment, today).getYears() * SalariedCoefficient * 1000;
    }
}

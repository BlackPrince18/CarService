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
        return "Director\n" + FirstName + " " + LastName
                + "\nID: " + ID + "\nBirthday: " + Birthday +
                "\nDate Of Employment: " + DateOfEmployment + '\n';
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

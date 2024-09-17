package employee;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public final class Director extends Employee {

    public Director(int ID, String FirstName, String LastName,
                    LocalDate Birthday, LocalDate DateOfEmployment) {
        super(ID, FirstName, LastName, Birthday, DateOfEmployment);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/YYYY");
        String result = "Director\n" + FirstName + " " + LastName
                + "\nID: " + ID + "\nBirthday: " + Birthday +
                "\nDate Of Employment: " + DateOfEmployment;

        return result;
    }
}

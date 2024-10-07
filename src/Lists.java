import employee.Assistant;
import employee.Director;
import employee.Employee;
import employee.Mechanic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Lists {
    public static List<Employee> initializeList() {
        List<Employee> employees = new ArrayList<>();

        var director = new Director(0, "Purcaru", "Mihnea",
                LocalDate.of(2004, 2, 18),
                LocalDate.of(2024, 6, 24));
        var mechanic = new Mechanic(1, "Popescu", "Andrei",
                LocalDate.of(2003, 1, 20),
                LocalDate.of(2021, 12, 12));
        var assistant = new Assistant(2, "Popa", "Alexandru",
                LocalDate.of(2000, 10, 15),
                LocalDate.of(2020, 9, 21));

        employees.add(director);
        employees.add(mechanic);
        employees.add(assistant);

        return employees;
    }

    public static List<Employee> addNewEmployee(List<Employee> employees) {
        var scanner = new Scanner(System.in);
        boolean verify = false;
        String option = "";

        while (verify != true) {
            System.out.println("What do you want to add? (D/M/A)");
            option = scanner.nextLine();
            verify = Menu.verifyOption(option);
        }
                
        Menu.enterCredentials(employees, option);

        return employees;
    }

    public static void removeEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("The Employee list is empty!");
            return;
        }

        var ID = enterID(employees);
        employees.remove(ID);
    }

    public static void editEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("The Employee list is empty!");
            return;
        }

        var ID = enterID(employees);

        for (int i=0; i < employees.size(); i++) {
            if(employees.get(i).getID() == ID) {
                Employee employee = Menu.replaceCredentials(employees.get(i));
                employees.set(i, employee);
                break;
            }
        }
    }

    public static void showSalary(List<Employee> employees) {
        var ID = enterID(employees);
        for (int i=0; i<employees.size(); i++) {
            if(employees.get(i).getID() == ID) {
                System.out.println(employees.get(i).calculateSalary());
                break;
            }
        }
    }

    private static boolean containsID(List<Employee> employees, int ID) {
        for (int i=0; i<employees.size(); i++)
            if (employees.get(i).getID() == ID) return true;

        return false;
    }

    private static int enterID(List<Employee> employees) {
        int ID = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);


        while (!verify) {
            System.out.println("Which employee do you want to edit (ID) ? ");
            ID = scanner.nextInt();
            verify = Lists.containsID(employees, ID);
            if (!verify) System.out.println("The ID does not exists!");
        }

        return ID;
    }
}

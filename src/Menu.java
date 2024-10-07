import employee.Assistant;
import employee.Director;
import employee.Employee;
import employee.Mechanic;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void show() {
        System.out.println("\t\t\t\tCar Service");
        System.out.println("1. Employees");
        System.out.println("2. Vehicles");
        System.out.println("3. Service Activity");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    public static void firstChoice(List<Employee> employees, int choice2) {
        Scanner scanner = new Scanner(System.in);

        while (choice2 != 6) {
            Menu.showEmployeeMenu();
            choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println(employees);
                    break;
                case 2:
                    Lists.addNewEmployee(employees);
                    break;
                case 3:
                    Lists.removeEmployee(employees);
                    break;
                case 4:
                    Lists.editEmployee(employees);
                    break;
                case 5:
                    Lists.showSalary(employees);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } System.out.println();
    }

    private static void showEmployeeMenu() {
        System.out.println();
        System.out.println("\t\t\t\tEmployees");
        System.out.println("1. Show Employees");
        System.out.println("2. Add Employee");
        System.out.println("3. Remove Employee");
        System.out.println("4. Edit Employee");
        System.out.println("5. Calculate Salary");
        System.out.println("6. Exit");
    }

    public static void enterCredentials(List<Employee> employees, String option) {
        int ID = employees.getLast().getID()+1;
        System.out.print("First Name: ");
        String FirstName = "";
        FirstName = enterName(FirstName);
        System.out.print("Last Name: ");
        String LastName = "";
        LastName = enterName(LastName);
        LocalDate Birthday = enterBirthday();
        LocalDate DateOfEmployment = enterDateOfEmployment();

        Employee newEmployee;
        if (option.equals("D") || option.equals("d")) {
            newEmployee = new Director(ID, FirstName, LastName, Birthday, DateOfEmployment);
        } else if (option.equals("M") || option.equals("m")) {
            newEmployee = new Mechanic(ID, FirstName, LastName, Birthday, DateOfEmployment);
        } else {
            newEmployee = new Assistant(ID, FirstName, LastName, Birthday, DateOfEmployment);
        }

        employees.add(newEmployee);
    }

    public static Employee replaceCredentials(Employee employee) {
        int ID = employee.getID();
        System.out.print("First Name: ");
        String FirstName = "";
        FirstName = enterName(FirstName);
        System.out.print("Last Name: ");
        String LastName = "";
        LastName = enterName(LastName);
        LocalDate Birthday = enterBirthday();
        LocalDate DateOfEmployment = enterDateOfEmployment();

        Employee result;
        if (employee.getSalariedCoefficient() == 2) {
            result = new Director(ID, FirstName, LastName, Birthday, DateOfEmployment);
        } else if (employee.getSalariedCoefficient() == 1.5) {
            result = new Mechanic(ID, FirstName, LastName, Birthday, DateOfEmployment);
        } else {
            result = new Assistant(ID, FirstName, LastName, Birthday, DateOfEmployment);
        }

        return result;
    }

    private static String enterName(String Name) {
        var scanner = new Scanner(System.in);
        boolean verify = false;

        while (!verify) {
            Name = scanner.nextLine();
            if (Name.isEmpty()) {
                System.out.println("Invalid Name!");
            }
            else if (Name.length() > 30) {
                System.out.println("The name should not be longer than 30 characters!");
            }
            else verify = true;
        }

        return Name;
    }

    private static LocalDate enterBirthday() {
        var scanner = new Scanner(System.in);
        boolean verify = false;
        int day = 0, month = 0, year = 0;

        while(!verify) {
            System.out.print("Birthday: ");
            day = scanner.nextInt();
            month = scanner.nextInt();
            year = scanner.nextInt();
            LocalDate Birthday = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            if (!verifyBirthday(Birthday, today)) {
                System.out.println("Invalid Date!");
            }
            else verify = true;
        }

        return LocalDate.of(year, month, day);
    }

    private static LocalDate enterDateOfEmployment() {
        var scanner = new Scanner(System.in);
        boolean verify = false;
        int day = 0, month = 0, year = 0;

        while(!verify) {
            System.out.print("Date of Employment: ");
            day = scanner.nextInt();
            month = scanner.nextInt();
            year = scanner.nextInt();
            LocalDate DateOfEmployment = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            if (!verifyDateOfEmployment(DateOfEmployment, today)) {
                System.out.println("Invalid Date!");
            }
            else verify = true;
        }

        return LocalDate.of(year, month, day);
    }

    private static boolean verifyBirthday(LocalDate start, LocalDate end) {
        if (Period.between(start, end).getYears() < 18) return false;
        else if (Period.between(start, end).getYears() == 18) {
            if (Period.between(start, end).getMonths() < 0) return false;
            else if (Period.between(start, end).getMonths() == 0) {
                if (Period.between(start, end).getDays() < 0) return false;
            }
        }

        return true;
    }

    private static boolean verifyDateOfEmployment(LocalDate DateOfEmployment, LocalDate today) {
        if (DateOfEmployment.isAfter(today)) return false;
        else return true;
    }

    public static boolean verifyOption(String option) {
        if (!option.equals("d") && !option.equals("D"))
            if (!option.equals("m") && !option.equals("M"))
                if (!option.equals("a") && !option.equals("A")) {
                    System.out.println("Invalid option! Try again!");
                    return false;
                }

        return true;
    }
}

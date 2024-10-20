import car.Car;
import employee.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        List<Employee> employees = Lists.initializeEmployeeList();
        List<Car> cars = Lists.initializeCarList();
        int choice1 = 0;

        while (choice1 != 5) {
            Menu.show();
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    Menu.firstChoice(employees);
                    break;
                case 2:
                    Menu.secondChoice(cars);
                    break;
                case 3, 4:
                    System.out.println("Temporary Unavailable!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            } System.out.println();
        }

        scanner.close();
    }
}
<<<<<<< HEAD
import car.Car;
=======
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
import employee.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
<<<<<<< HEAD
        List<Employee> employees = Lists.initializeEmployeeList();
        List<Car> cars = Lists.initializeCarList();
        int choice1 = 0;
=======
        List<Employee> employees = Lists.initializeList();
        int choice1 = 0, choice2 = 0;
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f

        while (choice1 != 5) {
            Menu.show();
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
<<<<<<< HEAD
                    Menu.firstChoice(employees);
                    break;
                case 2:
                    Menu.secondChoice(cars);
                    break;
                case 3, 4:
=======
                    Menu.firstChoice(employees, choice2);
                    break;
                case 2, 3, 4:
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
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
import employee.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        List<Employee> employees = Lists.initializeList();
        int choice1 = 0, choice2 = 0;

        while (choice1 != 5) {
            Menu.show();
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    Menu.firstChoice(employees, choice2);
                    break;
                case 2, 3, 4:
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
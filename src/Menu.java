import car.Bus;
import car.Car;
import car.StandardCar;
import car.Truck;
import employee.Assistant;
import employee.Director;
import employee.Employee;
import employee.Mechanic;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void show() {
        System.out.println("\t\t\t\tCar Service");
        System.out.println("1. Employees");
        System.out.println("2. Cars");
        System.out.println("3. Service Activity");
        System.out.println("4. Report");
        System.out.println("5. Exit");
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

    private static void showCarMenu() {
        System.out.println();
        System.out.println("\t\t\t\tCars");
        System.out.println("1. Show Cars");
        System.out.println("2. Add Car");
        System.out.println("3. Remove Car");
        System.out.println("4. Edit Car");
        System.out.println("5. Calculate Insurance");
        System.out.println("6. Exit");
    }

    public static void firstChoice(List<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        int choice2 = 0;

        while (choice2 != 6) {
            showEmployeeMenu();
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

    public static void secondChoice(List<Car> cars) {
        var scanner = new Scanner(System.in);
        int choice2 = 0;

        while (choice2 != 6) {
            showCarMenu();
            choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println(cars);
                    break;
                case 2:
                    Lists.addNewCar(cars);
                    break;
                case 3:
                    Lists.removeCar(cars);
                    break;
                case 4:
                    Lists.editCar(cars);
                    break;
                case 5:
                    System.out.println("The Insurance for the selected car is: " + Lists.calculateInsurance(cars));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            } System.out.println();
        }
    }

    public static void enterEmployeeCredentials(List<Employee> employees, String option) {
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

    public static void enterCarCredentials(List<Car> cars, String option) {
        int ID = cars.getLast().getID()+1;
        int odometer = enterOdometer();
        int year = enterYear();
        char indicator = enterIndicator();

        Car newCar;
        if (option.equals("SC") || option.equals("sc")) {
            String transmission = enterTransmission();
            newCar = new StandardCar(ID, odometer, year, indicator, transmission);
        } else if (option.equals("B") || option.equals("b")) {
            int places = enterNumberOfPlaces();
            newCar = new Bus(ID, odometer, year, indicator, places);
        } else {
            double weight = enterWeight();
            newCar = new Truck(ID, odometer, year, indicator, weight);
        }

        cars.add(newCar);
    }

    public static Employee replaceEmployeeCredentials(Employee employee) {
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

    public static Car replaceCarCredentials(Car car) {
       int ID = car.getID();
       int odometer = enterOdometer();
       int year = enterYear();
       char indicator = enterIndicator();

        StandardCar sc = new StandardCar(0, 0, 0, '\0', "\0");
        Bus b = new Bus(0, 0,0, '\0', 0);
        Car result;
        if (car.getClass() == sc.getClass()) {
            String transmission = enterTransmission();
            result = new StandardCar(ID, odometer, year, indicator, transmission);
        } else if (car.getClass() == b.getClass()) {
            int places = enterNumberOfPlaces();
            result = new Bus(ID, odometer, year, indicator, places);
        } else {
            double weight = enterWeight();
            result = new Truck(ID, odometer, year, indicator, weight);
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

    private static int enterOdometer() {
        int odometer = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);

        while (!verify) {
            System.out.print("Odometer: ");
            odometer = scanner.nextInt();
            if (odometer < 0) System.out.println("Invalid odometer!");
            else verify = true;
        }

        return odometer;
    }

    private static int enterYear() {
        int year = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);

        while (!verify) {
            System.out.print("Year: ");
            year = scanner.nextInt();
            LocalDate today = LocalDate.now();
            if (year > today.getYear()) System.out.println("Invalid Year!");
            else verify = true;
        }

        return  year;
    }

    private static char enterIndicator() {
        char indicator = '\0';
        boolean verify = false;
        var scanner = new Scanner(System.in);

        while (!verify) {
            System.out.print("Indicator: ");
            indicator = scanner.next().charAt(0);
            if (indicator != 'D' && indicator != 'd') {
                if (indicator != 'B' && indicator != 'b') {
                    System.out.println("Invalid indicator!");
                } else verify = true;
            } else verify = true;
        }

        return indicator;
    }

    private static String enterTransmission() {
        String transmission = "";
        var scanner = new Scanner(System.in);
        boolean verify = false;
        scanner.nextLine();

        while (!verify) {
            System.out.print("Transmission: ");
            transmission = scanner.nextLine();
            if (!transmission.equals("manual") && !transmission.equals("Manual")) {
                if (!transmission.equals("automatic") && !transmission.equals("Automatic")) {
                    System.out.println("Invalid transmission!");
                } else verify = true;
            } else verify = true;
        }

        return transmission;
    }

    private static int enterNumberOfPlaces() {
        int places = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);

        while (!verify) {
            System.out.print("Places: ");
            places = scanner.nextInt();
            if (places < 0 || places > 50) System.out.println("Invalid number of places!");
            else verify = true;
        }

        return places;
    }

    private static double enterWeight() {
        double weight = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);

        while (!verify) {
            System.out.print("Weight: ");
            weight = scanner.nextDouble();
            if(weight < 0 || weight > 50) System.out.println("Invalid weight!");
            else verify = true;
        }

        return weight;
    }

    private static boolean verifyBirthday(LocalDate start, LocalDate end) {
        if (Period.between(start, end).getYears() < 18) return false;
        else if (Period.between(start, end).getYears() == 18) {
            if (Period.between(start, end).getMonths() < 0) return false;
            else if (Period.between(start, end).getMonths() == 0) {
                return Period.between(start, end).getDays() >= 0;
            }
        }

        return true;
    }

    private static boolean verifyDateOfEmployment(LocalDate DateOfEmployment, LocalDate today) {
        return !DateOfEmployment.isAfter(today);
    }

    public static boolean verifyEmployeeOption(String option) {
        if (!option.equals("d") && !option.equals("D"))
            if (!option.equals("m") && !option.equals("M"))
                if (!option.equals("a") && !option.equals("A")) {
                    System.out.println("Invalid option! Try again!");
                    return false;
                }

        return true;
    }

    public static boolean verifyCarOption(String option) {
        if (!option.equals("SC") && !option.equals("sc"))
            if (!option.equals("B") && !option.equals("b"))
                if (!option.equals("T") && !option.equals("t")) {
                    System.out.println("Invalid option! Try again!");
                    return false;
                }

        return true;
    }
}

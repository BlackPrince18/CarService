<<<<<<< HEAD
import car.Bus;
import car.Car;
import car.StandardCar;
import car.Truck;
=======
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
import employee.Assistant;
import employee.Director;
import employee.Employee;
import employee.Mechanic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Lists {
<<<<<<< HEAD
    public static List<Employee> initializeEmployeeList() {
=======
    public static List<Employee> initializeList() {
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
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

<<<<<<< HEAD
    public static List<Car> initializeCarList() {
        List<Car> cars = new ArrayList<>();

        var bus = new Bus(0, 532502, 2006, 'D', 21);
        var standardcar = new StandardCar(1, 239214, 2010, 'B', "Manual");
        var truck = new Truck(2, 732140, 2008, 'B', 15);

        cars.add(bus);
        cars.add(standardcar);
        cars.add(truck);

        return cars;
    }

    public static void addNewEmployee(List<Employee> employees) {
=======
    public static List<Employee> addNewEmployee(List<Employee> employees) {
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
        var scanner = new Scanner(System.in);
        boolean verify = false;
        String option = "";

<<<<<<< HEAD
        while (!verify) {
            System.out.println("What do you want to add? (D/M/A)");
            option = scanner.nextLine();
            verify = Menu.verifyEmployeeOption(option);
        }
                
        Menu.enterEmployeeCredentials(employees, option);
    }

    public static void addNewCar(List<Car> cars) {
        var scanner = new Scanner(System.in);
        boolean verify = false;
        String option = "";

        while (!verify) {
            System.out.println("What do you want to add? (SC/B/T)");
            option = scanner.nextLine();
            verify = Menu.verifyCarOption(option);
        }

        Menu.enterCarCredentials(cars, option);
=======
        while (verify != true) {
            System.out.println("What do you want to add? (D/M/A)");
            option = scanner.nextLine();
            verify = Menu.verifyOption(option);
        }
                
        Menu.enterCredentials(employees, option);

        return employees;
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
    }

    public static void removeEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("The Employee list is empty!");
            return;
        }

<<<<<<< HEAD
        var ID = enterEmployeeID(employees);
        employees.remove(ID);
    }

    public static void removeCar(List<Car> cars) {
        if(cars.isEmpty()) {
            System.out.println("The Car list is empty!");
            return;
        }

        var ID = enterCarID(cars);
        cars.remove(ID);
    }

=======
        var ID = enterID(employees);
        employees.remove(ID);
    }

>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
    public static void editEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("The Employee list is empty!");
            return;
        }

<<<<<<< HEAD
        var ID = enterEmployeeID(employees);

        for (int i=0; i < employees.size(); i++) {
            if(employees.get(i).getID() == ID) {
                Employee employee = Menu.replaceEmployeeCredentials(employees.get(i));
=======
        var ID = enterID(employees);

        for (int i=0; i < employees.size(); i++) {
            if(employees.get(i).getID() == ID) {
                Employee employee = Menu.replaceCredentials(employees.get(i));
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
                employees.set(i, employee);
                break;
            }
        }
    }

<<<<<<< HEAD
    public static void editCar(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("The Employee list is empty!");
            return;
        }

        var ID = enterCarID(cars);

        for (int i=0; i < cars.size(); i++) {
            if(cars.get(i).getID() == ID) {
                Car car = Menu.replaceCarCredentials(cars.get(i));
                cars.set(i, car);
                break;
            }
        }
    }

    public static void showSalary(List<Employee> employees) {
        var ID = enterEmployeeID(employees);
        for (Employee employee : employees) {
            if (employee.getID() == ID) {
                System.out.println(employee.calculateSalary());
=======
    public static void showSalary(List<Employee> employees) {
        var ID = enterID(employees);
        for (int i=0; i<employees.size(); i++) {
            if(employees.get(i).getID() == ID) {
                System.out.println(employees.get(i).calculateSalary());
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
                break;
            }
        }
    }

<<<<<<< HEAD
    public static double calculateInsurance(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("The Car list is empty!");
            return 0;
        }
        var scanner = new Scanner(System.in);
        boolean verify = false;
        int option = 0;

        while (!verify) {
            System.out.println("\nSelect an option:\n1. Standard\n2. Discount");
            option = scanner.nextInt();
            if (option == 1) verify = true;
            else if (option == 2) verify = true;
            else System.out.println("Invalid option!");
        }

        Car sc = new StandardCar(0, 0, 0, 'd', "automatic");
        Car b = new Bus(0, 0, 0, 'b', 1);

        var ID = enterCarID(cars);
        for (Car car : cars) {
            if (ID == car.getID()) {
                if (car.getClass() == sc.getClass()) {
                    if (option == 1) return ((StandardCar) car).calculateStandardCarInsurance();
                    else return ((StandardCar) car).calculateStandardCarInsurance() - 0.05 * ((StandardCar) car).calculateStandardCarInsurance();
                } else if (car.getClass() == b.getClass()) {
                    if (option == 1) return ((Bus) car).calculateBusInsurance();
                    else return ((Bus) car).calculateBusInsurance() - 0.1 * ((Bus) car).calculateBusInsurance();
                } else {
                    if (option == 1) return ((Truck) car).calculateTruckInsurance();
                    else return ((Truck) car).calculateTruckInsurance() - 0.15 * ((Truck) car).calculateTruckInsurance();
                }
            }
        }
        return 0;
    }

    private static boolean containsEmployeeID(List<Employee> employees, int ID) {
        for (Employee employee : employees)
            if (employee.getID() == ID) return true;
=======
    private static boolean containsID(List<Employee> employees, int ID) {
        for (int i=0; i<employees.size(); i++)
            if (employees.get(i).getID() == ID) return true;
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f

        return false;
    }

<<<<<<< HEAD
    private static boolean containsCarID(List<Car> cars, int ID) {
        for (Car car : cars)
            if (car.getID() == ID) return true;

        return false;
    }

    private static int enterEmployeeID(List<Employee> employees) {
=======
    private static int enterID(List<Employee> employees) {
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
        int ID = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);


        while (!verify) {
<<<<<<< HEAD
            System.out.print("Type the ID of the employee: ");
            ID = scanner.nextInt();
            verify = Lists.containsEmployeeID(employees, ID);
            if (!verify) System.out.println("The ID does not exists!");
        }

        return ID;
    }

    private static int enterCarID(List<Car> cars) {
        int ID = 0;
        boolean verify = false;
        var scanner = new Scanner(System.in);

        while (!verify) {
            System.out.print("Type the ID of the car: ");
            ID = scanner.nextInt();
            verify = Lists.containsCarID(cars, ID);
=======
            System.out.println("Which employee do you want to edit (ID) ? ");
            ID = scanner.nextInt();
            verify = Lists.containsID(employees, ID);
>>>>>>> f2365d383238852c9edbedd97a614b4be062217f
            if (!verify) System.out.println("The ID does not exists!");
        }

        return ID;
    }
}

package Controller;

import Entities.Employee;
import database.Employee_DB;

import java.util.Scanner;

public class Starter {
    Scanner scanner= new Scanner(System.in);

    public void HomePage(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        Employee_DB employee_db =new Employee_DB();
        int choice;

        do {
            System.out.println("Welcome to the Spa Event Planner");
            System.out.println("1. Sign up for a client account");
            System.out.println("2. Log in");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: ClientController clientController = new ClientController();
                    clientController.ClientSignUp();
                    break;
                case 2: ChoseEntity();
                    break;
                case 0:
                    System.out.println("-------------------------------------");
                    System.out.println("Exiting Spa Event Planner. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

    }

    public void ChoseEntity(){
        int choice;

        do {
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
            System.out.println("=== Spa Event Planner Main Menu ===");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Login as Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AdminController adminController =new AdminController();
                    adminController.LoginPage();
                    break;
                case 2:
                    ClientController clientController = new ClientController();
                    clientController.LoginPage();
                    break;
                case 3:
                    EmployeeController employeeController = new EmployeeController();
                    employeeController.LoginPage();
                    break;
                case 4:
                    System.out.println("Exiting Spa Event Planner. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

}

package Controller;

import Entities.Employee;
import database.Employee_DB;

import java.util.Scanner;

public class EmployeeController {
    private boolean isLoggedIn;
    private final Scanner scanner = new Scanner(System.in);
    private Employee employee = new Employee();


    public EmployeeController() {
        this.isLoggedIn = false;

    }

    public boolean isLoggedIn() {

        return isLoggedIn;
    }
    public void logout() {

        isLoggedIn=false;
    }
    public void login() {

        isLoggedIn = true;
    }



    public void loggIn_Check(String id, String password)
    {
        for( Employee service_provider: Employee_DB.getServiceProviders() )
        {
            if( id.equals(service_provider.getId()) && password.equals(service_provider.getPassword()) ) {
                this.employee = service_provider;
                login();
            }
        }
        if(!(isLoggedIn)){
            System.out.println("-----------------------------------");
            System.out.println("LOGIN FAILD");
            System.out.println("-----------------------------------");
        }
    }

    public void errorInLogin() {}

    public void LoginPage(){
        System.out.println("--------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("=== Admin Login ===");

        System.out.print("Enter your ID: ");
        String clientId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        loggIn_Check(clientId,password);
        if(isLoggedIn){
            AdminHomePage();
        }
    }

    public void AdminHomePage(){
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        int choice;

        do {
            System.out.println("=== Employee Menu ===");
            System.out.println("1. View my schedule with my customers' reservations");
            System.out.println("2. View my Finance for the month");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //viewEmployeeSchedule(employeeId);
                    break;
                case 2:
                    //viewEmployeeFinance(employeeId);
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

    }

    public boolean loggIn_IDCheck(String id) {
        for( Employee employee: Employee_DB.getServiceProviders() )
        {
            if( id.equals(employee.getId())  ) {
                return true;

            }
        }
        return false;
    }

    public boolean loggIn_PassCheck(String pass) {
        for( Employee employee: Employee_DB.getServiceProviders() )
        {
            if( pass.equals(employee.getPassword())  ) {
                return true;

            }
        }
        return false;
    }
}


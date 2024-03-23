package Controller;

import Entities.Appointment;
import Entities.Client;
import Entities.Employee;
import database.Appointment_DB;
import database.Employee_DB;

import java.util.ArrayList;
import java.util.List;
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
    public void LoginPage(){
        System.out.println("--------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("=== Employee Login ===");

        System.out.print("Enter your ID: ");
        String clientId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        loggIn_Check(clientId,password);
        if(isLoggedIn){
            employeeHomePage();
        }
    }

    public void employeeHomePage(){
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
                    showEmployeeAppointments();
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

    public void showEmployeeAppointments(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        List<Appointment> employeeAppointments =new ArrayList<>();
        employeeAppointments = Appointment_DB.getEmployeeAppointments(this.employee);
        for( Appointment appointment: employeeAppointments){
            System.out.println("--------------------");
            System.out.println("Appointment_id: "+ appointment.getAppointmentID());
            System.out.println("Type: "+appointment.getEmployee().getWorkerType());
            System.out.println("Date: "+appointment.getDate());
            System.out.println("Time: "+appointment.getTime());
            System.out.println("Room Number: "+appointment.getRoom().getRoomNumber());
            System.out.println("--------------------");
        }

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


package controller;

import Entities.Appointment;
import Entities.Employee;
import database.Appointment_DB;
import database.EmployeeDB;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class EmployeeController {
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    private static final String COPY="------------------------------";
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



    public void loggInCheck(String id, String password)
    {
        for( Employee service_provider: EmployeeDB.getServiceProviders() )
        {
            if( id.equals(service_provider.getId()) && password.equals(service_provider.getPassword()) ) {
                this.employee = service_provider;
                login();
            }
        }
        if(!(isLoggedIn)){
            LOGGER.info(COPY);
            LOGGER.info("LOGIN FAILD");
            LOGGER.info(COPY);
        }
    }
    public void loginPage(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        LOGGER.info("=== Employee Login ===");
       LOGGER.info("Enter your ID: ");
        String clientId = scanner.nextLine();
        LOGGER.info("Enter your password: ");
        String password = scanner.nextLine();
        loggInCheck(clientId,password);
        if(isLoggedIn){
            employeeHomePage();
        }
    }

    public void employeeHomePage(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        int choice;
        do {
            LOGGER.info("""
               === Employee Menu ===
              1. View my schedule with my customers' reservations
              2. View my Finance for the month
              3. Logout""");
            LOGGER.info("Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEmployeeAppointments();
                    break;
                case 2:
                    LOGGER.info("Enter Start_Date (format: dd/MM/yyyy): ");
                    scanner.nextLine();
                    String date = scanner.nextLine();
                    LOGGER.info("Enter End_Date (format: dd/MM/yyyy): ");
                    String date2 = scanner.nextLine();
                    Appointment_DB.calculateEarningsForEmployeeInRange(employee.getId(),date,date2);
                    break;
                case 3:
                    LOGGER.info("Logging out. Goodbye!");
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

        } while (choice != 3);

    }

    public  void  showEmployeeAppointments(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        List<Appointment> employeeAppointments;
        employeeAppointments = Appointment_DB.getEmployeeAppointments(this.employee);
        for( Appointment appointment: employeeAppointments){
            LOGGER.info("--------------------");
            LOGGER.info("Appointment_id: "+ appointment.getAppointmentID());
            LOGGER.info("Type: "+appointment.getEmployee().getWorkerType());
            LOGGER.info("Date: "+appointment.getDate());
            LOGGER.info("Time: "+appointment.getTime());
            LOGGER.info("Room Number: "+appointment.getRoom().getRoomNumber());
            LOGGER.info("--------------------");
        }

    }
}


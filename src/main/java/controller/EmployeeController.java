package controller;

import basic.LoggerUtility;
import entity.Appointment;
import entity.Employee;
import database.AppointmentDb;
import database.EmployeeDB;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class EmployeeController {
    private static final String COPY="-----------------------------------\n";
    private static final String COPY1="-----------------------------------\n-----------------------------------\n";
    private static final String SHORT_LINE ="--------------------\n";
    private static final Logger LOGGER = LoggerUtility.getLogger();
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
        if(!(isLoggedIn)){LOGGER.info(COPY+"LOGIN FAILD"+"\n"+COPY);}
    }
    public void loginPage(){
        LOGGER.info(COPY1);
        LOGGER.info("=== Employee Login ==="+"\n"+"Enter your ID: ");
        String clientId = scanner.nextLine();
        LOGGER.info("Enter your password: ");
        String password = scanner.nextLine();
        loggInCheck(clientId,password);
        if(isLoggedIn){
            employeeHomePage();
        }
    }

    public void employeeHomePage(){
        LOGGER.info(COPY1);
        int choice;
        do {
            LOGGER.info("""
               === Employee Menu ===
              1. View my schedule with my customers' reservations
              2. View my Finance for the month
              3. Logout
              """);
            LOGGER.info("Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEmployeeAppointments();
                    break;
                case 2:
                    LOGGER.info("\n"+"Enter Start_Date (format: dd/MM/yyyy): ");
                    scanner.nextLine();
                    String date = scanner.nextLine();
                    LOGGER.info("\n"+"Enter End_Date (format: dd/MM/yyyy): ");
                    String date2 = scanner.nextLine();
                    AppointmentDb.calculateEarningsForEmployeeInRange(employee.getId(),date,date2);
                    break;
                case 3:
                    LOGGER.info("Logging out. Goodbye!");
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

        } while (choice != 3);

    }

    public  boolean  showEmployeeAppointments(){
        LOGGER.info(COPY1);
        List<Appointment> employeeAppointments;
        employeeAppointments = AppointmentDb.getEmployeeAppointments(this.employee);
        printShowEmployeeAppointment(employeeAppointments, LOGGER, SHORT_LINE);
    return true;}

    public static void printShowEmployeeAppointment(List<Appointment> employeeAppointments, Logger logger, String shortLine) {
        for( Appointment appointment: employeeAppointments){
            LOGGER.info(shortLine);
            logger.info("\n"+"Appointment_id: "+appointment.getAppointmentId()+"\n"+
            "Type: "+appointment.getEmployee().getWorkerType()+"\n"+
            "Date: "+appointment.getDate()+"\n"+
            "Time: "+appointment.getTime()+"\n"+
            "Room Number: "+appointment.getRoom().getRoomNumber()+"\n");
            LOGGER.info(shortLine);
        }
    }


}


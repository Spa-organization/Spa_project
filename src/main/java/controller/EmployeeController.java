package controller;

import basic.LoggerUtility;
import entity.Appointment;
import entity.Employee;
import database.AppointmentDb;
import database.EmployeeDB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {

    private static final Logger LOGGER = LoggerUtility.getLogger();

    private static final String COPY="-----------------------------------\n";
    private static final String COPY1="-----------------------------------\n-----------------------------------\n";
    private static final String SHORT_LINE ="--------------------\n";
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
            LOGGER.severe(COPY);
            LOGGER.warning("LOGIN FAILD"+"\n");
            LOGGER.severe(COPY);
        }
    }
    public void loginPage(){
        LOGGER.severe(COPY1);
        LOGGER.fine("=== Employee Login ==="+"\n");
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
        LOGGER.severe(COPY1);
        int choice;
        do {
            LOGGER.fine("=== Employee Menu ==="+"\n");
            LOGGER.info("""
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
                    AppointmentDb.calculateEmployeeProfitPercentageForRange(employee.getId());
                    break;
                case 3:
                    LOGGER.info("Logging out. Goodbye!");
                    break;
                default:
                    LOGGER.warning("""

                            Invalid choice. Please try again.
                            """);
            }

        } while (choice != 3);

    }

    public   boolean  showEmployeeAppointments(){
        LOGGER.severe(COPY1);
        List<Appointment> employeeAppointments;
        employeeAppointments = AppointmentDb.getEmployeeAppointments(this.employee);
        printShowEmployeeAppointment(employeeAppointments, LOGGER, SHORT_LINE);
    return true;}

    public  static boolean printShowEmployeeAppointment(List<Appointment> employeeAppointments, Logger logger, String shortLine) {
        for( Appointment appointment: employeeAppointments){
            if(LOGGER.isLoggable(Level.SEVERE))
            {LOGGER.severe("\n"+shortLine);}
            logger.info("\n"+"Appointment_id: "+appointment.getAppointmentId()+"\n"+
            "Type: "+appointment.getEmployee().getWorkerType()+"\n"+
            "Date: "+appointment.getDate()+"\n"+
            "Time: "+appointment.getTime()+"\n"+
            "Room Number: "+appointment.getRoom().getRoomNumber()+"\n");
            LOGGER.severe(shortLine);
        }
        return true;
    }




}
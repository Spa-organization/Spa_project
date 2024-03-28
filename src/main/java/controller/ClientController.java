package controller;

import basic.LoggerUtility;
import entity.*;
import database.AppointmentDb;
import database.ClientDB;
import database.FeedbackDB;
import database.RoomDb;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ClientController {
    private static final String COPY="-----------------------------------\n";
    private static final String COPY1="-----------------------------------\n+-----------------------------------\n";


    private static final String SHORT_LINE ="--------------------\n";
    private static final Logger LOGGER = LoggerUtility.getLogger();
    private  boolean isLoggedIn ;
     Scanner scanner = new Scanner(System.in);
    private  Client client = new Client();

    private    boolean logUp;

    public ClientController() {
        isLoggedIn = false;
        logUp=false;
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
        for( Client clientC: ClientDB.getClients() )
        {
            if( id.equals(clientC.getId()) && password.equals(clientC.getPassword()) ) {
                login();
                this.client=clientC;
                break;
            }
        }
        if(!(isLoggedIn)){LOGGER.info(COPY+"LOGIN FAILD"+"\n"+COPY);}
    }
    public void loginPage(){

        LOGGER.info("""
                === Client Login ===
                Enter your ID:"""+"\n");

        String clientId = scanner.nextLine();

        LOGGER.info("Enter your password: ");
        String password = scanner.nextLine();
        loggInCheck(clientId,password);
        if(isLoggedIn){
            clientHomePage();
        }

    }
    public void clientSignUp(){
        LOGGER.info("=== Sign Up ==="+"\n"+
                "Enter client ID: ");
        String clientId = scanner.nextLine();

        LOGGER.info("Enter client Name: ");
        String clientName = scanner.nextLine();

        LOGGER.info("Enter client Password: ");
        String password = scanner.nextLine();
        if(!ClientDB.addClient(clientId,clientName,password)){
            LOGGER.info(COPY+"This ID is Already Exists\n"+COPY);
        }else {
            LOGGER.info(COPY+"Signup done successfully"+"\n"+"\n");
        }
    }

    public void clientHomePage(){
        LOGGER.info(COPY1);
        int choice;

        do {
            LOGGER.info("""
                ==== Customer Menu ====
                1. Book Appointment
                2. Show My Appointments
                3. Edit My Appointments
                4. Cancel My Appointments
                5. Feedback
                6. Logout
                """);
            LOGGER.info("Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    showClientAppointments();
                    break;
                case 3:
                    updateSession();
                    break;
                case 4: cancelSession();
                    break;
                case 5:
                    LOGGER.info("Enter your Id : ");
                    int nextId = scanner.nextInt();
                    LOGGER.info("Type your feedback here : ");
                    scanner.nextLine();
                    String feedback = scanner.nextLine();
                    FeedbackDB.addFeedback(feedback,nextId);
                    break;
                case 6:
                    LOGGER.info("Logging out. Goodbye!");
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

        } while (choice != 6);

    }

    public void bookAppointment(){
        int appointmentType;
        do {
            LOGGER.info("""
                    
                    Book Appointment
                    1. Massage
                    2. Sauna
                    3. Exit
                    Enter your choice:""");
            appointmentType = scanner.nextInt();
            switch (appointmentType) {
                case 1:
                    bookMassage("Massage");
                    break;
                case 2:
                    bookSauna("Sawna");
                    break;
                case 3:
                    break;
                default:
                   LOGGER.info("Invalid choice. Please try again.");
            }
        } while (appointmentType!=3);
    }
    public void booking(String type){
        LOGGER.info(COPY1);
        LOGGER.info("Enter Date (format: dd/MM/yyyy): ");
        scanner.nextLine();
        String dateInput = scanner.nextLine();
        LOGGER.info("Enter Time (format: HH:mm): ");
        String timeInput = scanner.nextLine();
        if(!AppointmentDb.isValidDate(dateInput))
        {addAppointmentResult(2);return ;}
        else if(!AppointmentDb.isValidTime(timeInput))
        {addAppointmentResult(1);return ;}

        List<Employee> employees=AppointmentDb.checkAvailability(dateInput,timeInput,type);
        if(!employees.isEmpty()){showAvailableRooms(employees,dateInput,timeInput);}

        else {

            LOGGER.info(COPY + "NO Available Rooms In This Time" + "\n" + COPY);
        }

    }
    public void bookMassage(String type){
        booking(type);
    }
    public void printEmployees(List<Employee> employees){
       LOGGER.info("--------Print employees :)--------");
        for(Employee employee:employees){
            LOGGER.info(employee.getName()+" "+employee.getWorkerType());
        }
    }


    public void bookSauna(String type){
        booking(type);

    }
    public void showClientAppointments(){
        LOGGER.info(COPY1);
        List<Appointment> clientAppointments;
        clientAppointments = AppointmentDb.getUserAppointments(this.client);
        EmployeeController.printShowEmployeeAppointment(clientAppointments, LOGGER, SHORT_LINE);

    }
    public void addAppointmentResult(int result){
        switch (result){
            case 1:
         LOGGER.info(COPY+"invalid Time! check your Time form"+"\n"+"invalid Time! check your Time form"+"\n"+COPY);
         break;
            case 2:
                LOGGER.info(COPY+"invalid date! check your date form"+"\n"+COPY);
                break;
            default:
                LOGGER.info(COPY+"Appointment was Booked :)"+"\n"+COPY);
        }
    }
    public void showAvailableRooms(List<Employee> employees, String dateInput,String timeInput){
        LOGGER.info("-----Available Rooms------");
        List<Room> rooms;
        for(Employee employee:employees)
        {
            rooms =employee.getRooms();
            for(Room room:rooms){
                LOGGER.info(SHORT_LINE+"Room Number: "+ room.getRoomNumber()+" employee: "+room.getEmployee().getName()+" type: "+room.getEmployee().getWorkerType()+"\n");
            }
        }
        LOGGER.info("Enter room number to book:");
        int roomNumber= scanner.nextInt();
        if(roomNumber!=0){
            Room room= RoomDb.getRoomById(roomNumber);
            if(room!=null){
                addAppointmentResult( AppointmentDb.addAppointment(this.client,dateInput,timeInput,room.getEmployee()));
            }
        }
        else{LOGGER.info("invalid input!!"+"\n"+SHORT_LINE);}
    }


    public void cancelSession(){
        boolean flag = false;
        showClientAppointments();
        Scanner input = new Scanner(System.in);
        LOGGER.info(SHORT_LINE+"Please enter the id of the your appointment from the above");
        int idC = input.nextInt();
        List<Appointment> clientAppointments;
        clientAppointments = AppointmentDb.getUserAppointments(this.client);
        for (Appointment appointment:clientAppointments) {
            if (appointment.getAppointmentID() == idC) {
                flag = true;
                break;
            }

        }
        if(flag){
            AppointmentDb.deleteAppointment(idC);
            LOGGER.info("Successfully deleted");
        }

        else LOGGER.info("You don't have this room");
    }

    public void updateSession(){
        showClientAppointments();
        Scanner input = new Scanner(System.in);
        LOGGER.info(SHORT_LINE);

        LOGGER.info("Please enter the id of your appointment: ");
        int nextInt = input.nextInt();
        LOGGER.info("\n"+"Please enter the new date (format: dd/MM/yyyy): ");
        input.nextLine();
        String date = input.nextLine();
        LOGGER.info("\n"+"Please enter the new time (format: HH:mm): ");
        String time = input.nextLine();
        if(!AppointmentDb.isValidDate(date)) {addAppointmentResult(2); return;}
        else if(!AppointmentDb.isValidTime(time)) {addAppointmentResult(1); return;}


        List<Appointment> clientAppointments;
        clientAppointments = AppointmentDb.getUserAppointments(this.client);

        for (Appointment appointment:clientAppointments) {
            if (appointment.getAppointmentID() == nextInt) {
               int roomId=appointment.getRoom().getRoomNumber();
               if(check(date,time,roomId))
               {
                   appointment.setDate(date);
                   appointment.setTime(time);
               }
               else return;

            }
        }

    }
    public boolean check(String dateCheck,String timeCheck,int roomId)
    {
        for (int i=0;i<AppointmentDb.appointments.size();i++)
        {
            int idC=AppointmentDb.appointments.get(i).getRoom().getRoomNumber();
         String date= AppointmentDb.appointments.get(i).getDate();
         String time= AppointmentDb.appointments.get(i).getTime();
        if(dateCheck.equals(date)&&timeCheck.equals(time)&&idC==roomId)
        {
          LOGGER.info("not available");
          return false;}
        }
        LOGGER.info("available");
        return true;
    }

    public boolean isLoggedUp() {return this.logUp;}

}

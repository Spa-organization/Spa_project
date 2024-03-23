package Controller;

import Entities.*;
import database.Appointment_DB;
import database.Client_DB;
import database.Feedback_DB;
import database.Room_DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientController {

    private static boolean isLoggedIn = false;
    private Scanner scanner = new Scanner(System.in);
    private  Client client = new Client();
    static int id;
    private boolean log_up;


    public ClientController() {
        isLoggedIn = false;
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
        for( Client client: Client_DB.getClients() )
        {
            if( id.equals(client.getId()) && password.equals(client.getPassword()) ) {
                login();
                this.client=client;
                break;
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
        System.out.println("=== Client Login ===");

        System.out.print("Enter your ID: ");
        String clientId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        loggIn_Check(clientId,password);
        if(isLoggedIn){
            ClientHomePage();
        }

    }
    public void ClientSignUp(){
        System.out.println("=== Sign Up ===");

        System.out.print("Enter client ID: ");
        String clientId = scanner.nextLine();

        System.out.print("Enter client Name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter client Password: ");
        String password = scanner.nextLine();
        if(!Client_DB.addClient(clientId,clientName,password)){
            System.out.println("----------------------------");
            System.out.println("This ID is Already Exists");
            System.out.println("----------------------------");
        }else {
            System.out.println("-------------------------------------");
            System.out.println("Signup done successfully");
            System.out.println("-------------------------------------");
        }
    }

    //-----------Client Home Page---------------
    public void ClientHomePage(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        int choice;

        do {
            System.out.println("==== Customer Menu ====");
            System.out.println("1. Book Appointment");
            System.out.println("2. Show My Appointments");
            System.out.println("3. Edit My Appointments");
            System.out.println("4. Cancel My Appointments");
            System.out.println("5. Feedback");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Enter your Id : ");
                    int id = scanner.nextInt();
                    System.out.println("Type your feedback here : ");
                    scanner.nextLine();
                    String feedback = scanner.nextLine();
                    Feedback_DB.addFeedback(feedback,id);
                    break;
                case 6:
                    System.out.println("Logging out. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

    }

    public void bookAppointment(){
        int appointmentType;
        do {
            System.out.println("Book Appointment");
            System.out.println("1. Massage");
            System.out.println("2. Sauna");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (appointmentType!=3);
    }
    public void bookMassage(String type){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Enter Date (format: dd/MM/yyyy): ");
        scanner.nextLine();
        String dateInput = scanner.nextLine();

        System.out.println("Enter Time (format: HH:mm): ");
        String timeInput = scanner.nextLine();
        if(!Appointment_DB.isValidDate(dateInput)) {addAppointmentResult(2); return;}
        else if(!Appointment_DB.isValidTime(timeInput)) {addAppointmentResult(1); return;}

        List<Employee> employees=Appointment_DB.checkAvailability(dateInput,timeInput,type);
        if(employees.size()!= 0){
            showAvailableRooms(employees,dateInput,timeInput);
        }
        else{
            System.out.println("----------------------------------");
            System.out.println("NO Available Rooms In This Time");
            System.out.println("----------------------------------");
        }
    }
    public void printEmployees(List<Employee> employees){
        System.out.println("--------Print employees :)--------");
        for(Employee employee:employees){
            System.out.println(employee.getName()+" "+employee.getWorkerType());
        }
    }
    public void bookSauna(String type){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.print("Enter Date (format: dd/MM/yyyy): ");
        scanner.nextLine();
        String dateInput = scanner.nextLine();

        System.out.print("Enter Time (format: HH:mm): ");
        String timeInput = scanner.nextLine();
        if(!Appointment_DB.isValidDate(dateInput))
        {
            addAppointmentResult(2);
            return ;
        }
        else if(!Appointment_DB.isValidTime(timeInput))
        {addAppointmentResult(2); return ; }
        List<Employee> employees=Appointment_DB.checkAvailability(dateInput,timeInput,type);
        if(employees.size()!= 0){

            showAvailableRooms(employees,dateInput,timeInput);
        }
        else{
            System.out.println("----------------------------------");
            System.out.println("NO Available Rooms In This Time");
            System.out.println("----------------------------------");
        }
    }
    public void showClientAppointments(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        List<Appointment> clientAppointments =new ArrayList<>();
        clientAppointments = Appointment_DB.getUserAppointments(this.client);
        for( Appointment appointment: clientAppointments){
            System.out.println("--------------------");
            System.out.println("Appointment_id: "+ appointment.getAppointmentID());
            System.out.println("Type: "+appointment.getEmployee().getWorkerType());
            System.out.println("Date: "+appointment.getDate());
            System.out.println("Time: "+appointment.getTime());
            System.out.println("Room Number: "+appointment.getRoom().getRoomNumber());
            System.out.println("--------------------");
        }

    }
    public void addAppointmentResult(int result){
        switch (result){
            case 1:
                System.out.println("----------------------------------");
                System.out.println("invalid Time! check your Time form");
                System.out.println("----------------------------------");
                break;

            case 2:	System.out.println("----------------------------------");
                System.out.println("invalid date! check your date form");
                System.out.println("----------------------------------");
                break;

            case 0:System.out.println("----------------------------------");
                System.out.println("Appointment Booked :)");
                System.out.println("----------------------------------");
        }
    }
    public void showAvailableRooms(List<Employee> employees, String dateInput,String timeInput){
        System.out.println("-----Available Rooms------");
        List<Room> rooms;
        for(Employee employee:employees){
            rooms =employee.getRooms();
            for(Room room:rooms){
                System.out.println("--------------");
                System.out.println("Room Number: "+ room.getRoomNumber()+" employee: "+room.getEmployee().getName()+" type: "+room.getEmployee().getWorkerType());

            }
        }
        System.out.println("Enter room number to book");
        int roomNumber= scanner.nextInt();
        if(roomNumber!=0){
            Room room= Room_DB.getRoomById(roomNumber);
            if(room!=null){
                addAppointmentResult( Appointment_DB.addAppointment(id,this.client,dateInput,timeInput,room.getEmployee()));
            }
        }
        else{
            System.out.println("invalid input!!");
            System.out.println("----------------------");
        }


    }

    public void cancelSession(){
        boolean flag = false;
        showClientAppointments();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Please enter the id of the your appointment from the above");
        int id = input.nextInt();
        List<Appointment> clientAppointments =new ArrayList<>();
        clientAppointments = Appointment_DB.getUserAppointments(this.client);
        for (Appointment appointment:clientAppointments) {
            if (appointment.getAppointmentID() == id) {
                flag = true;
                break;
            }

        }
        Appointment_DB.deleteAppointment(id);
        if(flag)
            System.out.println("Successfully deleted");
        else System.out.println("You don't have this room");
    }

    public void updateSession(){
        showClientAppointments();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Please enter the id of your appointment: ");
        int id = input.nextInt();
        System.out.println("Please enter the new date (format: dd/MM/yyyy): ");
        input.nextLine();
        String date = input.nextLine();
        System.out.println("Please enter the new time (format: HH:mm): ");
        String time = input.nextLine();
        if(!Appointment_DB.isValidDate(date)) {addAppointmentResult(2); return;}
        else if(!Appointment_DB.isValidTime(time)) {addAppointmentResult(1); return;}



        List<Appointment> clientAppointments =new ArrayList<>();
        clientAppointments = Appointment_DB.getUserAppointments(this.client);

        for (Appointment appointment:clientAppointments) {
            if (appointment.getAppointmentID() == id) {
               int room_id=appointment.getRoom().getRoomNumber();
               if(check(date,time,room_id))
               {
                   appointment.setDate(date);
                   appointment.setTime(time);
               }
               else return;

            }
        }

    }
    public boolean check(String date_check,String time_check,int room_id)
    {
        boolean flag=true;
        for (int i=0;i<Appointment_DB.appointments.size();i++)
        {
            int id=Appointment_DB.appointments.get(i).getRoom().getRoomNumber();
         String date= Appointment_DB.appointments.get(i).getDate();
         String time= Appointment_DB.appointments.get(i).getTime();
        if(date_check.equals(date)&&time_check.equals(time)&&id==room_id)
        {
          flag=false;System.out.println("not available");return flag;}
        }

            System.out.println("available");
            return flag;
    }

    public boolean isLogged_up() {return this.log_up;}
    public void Logged_up() {this.log_up=true;}

}

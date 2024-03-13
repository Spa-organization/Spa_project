package Controller;

import Entities.*;
import database.Appointment_DB;
import database.Client_DB;
import database.Room_DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientController {

    private boolean isLoggedIn = false;
    private Scanner scanner = new Scanner(System.in);
    private  Client client = new Client();


    public ClientController() {
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
            System.out.println("4. Feedback");
            System.out.println("5. Logout");
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

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Logging out. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

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
                    bookSauna("Spa");
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
        else if(!Appointment_DB.isValidTime(timeInput)) {addAppointmentResult(2); return;}

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
        System.out.println("--------Ptint employees :)--------");
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

        List<Employee> employees=Appointment_DB.checkAvailability(dateInput,timeInput,type);
        if(employees.size()!= 0){
            if(!Appointment_DB.isValidDate(dateInput))
                addAppointmentResult(2);
            else if(!Appointment_DB.isValidTime(timeInput))
                addAppointmentResult(2);
            else
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
        System.out.println("Enter room number to book");;
        int roomNumber= scanner.nextInt();
        if(roomNumber!=0){
            Room room= Room_DB.getRoomById(roomNumber);
            if(room!=null){
                addAppointmentResult( Appointment_DB.addAppointment(this.client,dateInput,timeInput,room.getEmployee()));
            }
        }
        else{
            System.out.println("invalid input!!");
            System.out.println("----------------------");
        }


    }

   // public boolean loggIn_IDCheck(String id) {
     //   for( Client client: Client_DB.getClients() )
       // {
         //   if( id.equals(client.getId())  ) {
           //     return true;

            //}
        //}
        //return false;
    //}

  //  public boolean loggIn_PassCheck(String pass) {
    //    for( Client client: Client_DB.getClients() )
      //  {
        //    if( pass.equals(client.getPassword())  ) {
          //      return true;

            //}
        //}
        //return false;
   // }


}

package Controller;

import Entities.Admin;
import Entities.Appointment;
import Entities.Employee;
import Entities.Room;
import database.Admin_DB;
import database.Appointment_DB;
import database.Employee_DB;
import database.Room_DB;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private static boolean isLoggedIn;
    Admin admin = new Admin();
    private Scanner scanner = new Scanner(System.in);

    public AdminController() {
        this.isLoggedIn = false;

    }

    public static boolean isLoggedIn() {

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
        for( Admin admin:Admin_DB.getAdmins() )
        {
            if( id.equals(admin.getId()) && password.equals(admin.getPassword()) ) {
                this.admin=admin;
                login();
            }
        }
    }
    public void errorInLogin()
    {

    }

    public void LoginPage(){
        System.out.println("-------------------------------------");
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
            System.out.println("=== Admin "+admin.getName()+" Menu ===");
            System.out.println("1. Add Rooms");
            System.out.println("2. Add Employee");
            System.out.println("3. View Appointments");
            System.out.println("4. View Finance");
            System.out.println("5. Add Admin");
            System.out.println("6. Show All Rooms");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    showAppointments();
                    break;
                case 4:
                    // viewFinance();
                    break;
                case 5:
                    addAdmin();
                    break;
                case 6:
                    ShowALlRooms();
                    break;
                case 7:System.out.println("Logging out. Goodbye!");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

    }

    public void addRoom(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        int roomType;

        do {
            System.out.println("Add Rooms");
            System.out.println("1. sawna Room");
            System.out.println("2. Massage Room");
            System.out.println("3. Show All Employees with ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            roomType = scanner.nextInt();

            switch (roomType) {
                case 1:
                    addSawnaRoom();
                    break;
                case 2:
                    addMassageRoom();
                    break;
                case 3:
                    showAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting Room Management. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (roomType != 4);
    }
    public void addSawnaRoom(){
        System.out.println("------------------------------");
        //ndkjjkbjkbk
        System.out.println("------------------------------");
        System.out.print("Enter Room ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee ID to manage the new: ");
        String employeeId = scanner.next();
        Employee employee= Employee_DB.getEmployeeById(employeeId);
        if(employee!=null){
            if(employee.getWorkerType().equalsIgnoreCase("Sawna")){
                if(Room_DB.addRoom(employee, id)){
                    System.out.println("----------------------------");
                    System.out.println("This ID_room is Already Exists");
                    System.out.println("----------------------------");
                }
            }
            else{
                System.out.println("----------------------");
                System.out.println("not Sawna employee!!");//
                System.out.println("-----------------------");
            }
        }else{
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
    }
    public void addMassageRoom(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.print("Enter Room ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee ID to manage the new: ");
        String employeeId = scanner.next();
        Employee employee= Employee_DB.getEmployeeById(employeeId);
        if(employee!=null){
            if(employee.getWorkerType().equalsIgnoreCase("Massage")){//
                if(Room_DB.addRoom(employee, id)){
                    System.out.println("----------------------------");
                    System.out.println("This ID_room is Already Exists");
                    System.out.println("----------------------------");
                }
            }
            else{
                System.out.println("----------------------");
                System.out.println("not Massage employee!!");
                System.out.println("-----------------------");
            }
        }else{
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
    }
    public void showAllEmployees(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        List<Employee> employees= new ArrayList<Employee>();
        employees=Employee_DB.getServiceProviders();
        for(Employee employee :employees){
            System.out.println("----");
            System.out.println("Name: "+employee.getName()+"  ID: "+employee.getId()+" Type: "+employee.getWorkerType());
        }
    }
    public void addEmployee(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("=== Add Employee ===");
        System.out.print("Enter Employee ID: ");
        String employeeId = scanner.next();

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.next();

        System.out.print("Enter Employee Password: ");
        String employeePassword = scanner.next();

        System.out.print("Enter Employee Type (Spa or Massage): ");
        String employeeType = scanner.next();
        if(!Employee_DB.addServiceProviders(employeeId,employeeName,employeePassword,employeeType)){
            System.out.println("----------------------------");
            System.out.println("This ID is Already Exists");
            System.out.println("----------------------------");
        }else
            System.out.println("Employee added successfully!");

        System.out.println("================");
    }

    public void showAppointments(){
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("=== All Appointments ===");
        List<Appointment> appointments= new ArrayList<Appointment>();
        appointments = Appointment_DB.getAllAppointments();
        for(Appointment appointment:appointments){
            System.out.println("---------");
            System.out.println(" type: "+appointment.getEmployee().getWorkerType());
            System.out.println("Room: "+appointment.getRoom().getRoomNumber());
            System.out.println("Employee: "+appointment.getEmployee().getName());
            System.out.println("Date: "+appointment.getDate()+" Time"+appointment.getTime());
        }
    }
    public void ShowALlRooms(){
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        List<Room> rooms;
        rooms=Room_DB.rooms;
        System.out.println("we have "+rooms.size()+" rooms");
        for(Room room:rooms){
            System.out.println("-----------");
            System.out.println("Room Id: "+room.getRoomNumber());
            System.out.println("Employee: "+room.getEmployee().getName());
        }
    }
    public void addAdmin(){
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("=== Add Admin ===");
        System.out.print("Enter Admin ID: ");
        String adminId = scanner.next();

        System.out.print("Enter Admin Name: ");
        String adminName = scanner.next();

        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.next();
        if(!Admin_DB.addAdmin(adminId,adminName,adminPassword)){
            System.out.println("----------------------------");
            System.out.println("This ID is Already Exists");
            System.out.println("----------------------------");
        }else
            System.out.println("=== Admin added ===");
    }

    public boolean loggIn_IDCheck(String id) {
        for( Admin admin:Admin_DB.getAdmins() )
        {
            if( id.equals(admin.getId())  ) {
                return true;

            }
        }
        return false;
    }

    public boolean loggIn_PassCheck(String pass) {
        for( Admin admin:Admin_DB.getAdmins() )
        {
            if( pass.equals(admin.getPassword())  ) {
                return true;

            }
        }
        return false;
    }
}

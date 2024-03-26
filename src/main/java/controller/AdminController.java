package controller;

import entity.*;
import basic.EmailSender;
import database.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class AdminController {

    private static final String COPY="-----------------------------------";
    private static final Logger LOGGER = Logger.getLogger(AdminController.class.getName());
    EmailSender email;
    private  boolean isLoggedIn;
    Admin admin = new Admin();
    static Scanner scanner = new Scanner(System.in);

    public AdminController() {
        isLoggedIn = false;
    }

    public  boolean isLoggedIn() {

        return isLoggedIn;
    }
    public  void logout() {

        isLoggedIn=false;
    }
    public  void login() {

        isLoggedIn = true;
    }

    public  void loginCheck(String id, String password)
    {
        for( Admin adminC: AdminDB.getAdmins() )
        {
            if( id.equals(adminC.getId()) && password.equals(adminC.getPassword()) ) {
                this.admin=adminC;
                login();
            }
        }
        if(!(isLoggedIn)){
            LOGGER.info(COPY);
            LOGGER.info("LOGIN FAILD");
            LOGGER.info(COPY);
        }
    }

    public void loginPage() throws MessagingException {
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        LOGGER.info("=== Admin Login ===");
        LOGGER.info("Enter your ID: ");
        String clientId = scanner.nextLine();
        LOGGER.info("Enter your password: ");
        String password = scanner.nextLine();
        loginCheck(clientId,password);
        if(isLoggedIn){
            adminHomePage();
        }
    }

    public void adminHomePage() throws MessagingException {
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        int choice;
        do {
            LOGGER.info("=== Admin "+admin.getName()+" Menu ===");
            LOGGER.info("""
                    1. Add Rooms
                    2. Add Employee
                    3. View Appointments
                    4. View Finance
                    5. Add Admin
                    6. Show All Rooms
                    7. View Feedbacks
                    8. view CenterEarningsForRange
                    9. logout
                    """);
            LOGGER.info("Enter your choice: ");
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
                    viewEmployeeEarningsForRange();
                    break;
                case 5:
                    addAdmin();
                    break;
                case 6:
                    showALlRooms();
                    break;
                case 7 :
                    viewFeedbacks();
                    break;
                case 8:viewCenterEarningsForRange();
                    break;
                case 9:LOGGER.info("Logging out. Goodbye!");break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

        } while (choice != 9);

    }


    public void addRoom() throws MessagingException {
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        int roomType;
        do {
            LOGGER.info("""
                    Add Rooms
                    1. sawna Room
                    2. Massage Room
                    3. Show All Employees with ID
                    4. Exit
                    Enter your choice:
                    """);
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
                    LOGGER.info("Exiting Room Management. Goodbye!");
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }
        } while (roomType != 4);
    }
    public void addSawnaRoom() throws MessagingException {
        LOGGER.info("""
                -----------------------------------
                -----------------------------------""");
        LOGGER.info("Enter Room ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        LOGGER.info("Enter Employee ID to manage the new: ");
        String employeeId = scanner.next();
        Employee employee= EmployeeDB.getEmployeeById(employeeId);
        if(employee!=null){
            if(!employee.getRooms().isEmpty())
            {
               print(id,employee);
            }

            else if(employee.getWorkerType().equalsIgnoreCase("Sawna")){
                if(!RoomDb.addRoom(employee, id)){
                    LOGGER.info(COPY);
                    LOGGER.info("This ID_room is Already Exists");
                    LOGGER.info(COPY);
                }
                else {
                    email=new EmailSender();
                    email.spaOrganizer("qsay.3w@gmail.com");
                    LOGGER.info(COPY);
                    LOGGER.info("Sawna Room Added");
                    LOGGER.info(COPY);
                }
            }
            else{
                LOGGER.info(COPY);
                LOGGER.info("not Sawna employee!!");//
                LOGGER.info(COPY);
            }
        }else{
         LOGGER.info(COPY);
         LOGGER.info("employee not found!!");
         LOGGER.info(COPY);
        }
    }
    public void print(int id,Employee employee ){

        if(employee.getRooms().getFirst().getRoomNumber() == id)
        {
            LOGGER.info(COPY);
            LOGGER.info("The employee is already assigned to this room");
            LOGGER.info(COPY);
        }
        else
        {
            LOGGER.info(COPY);
            LOGGER.info("The employee is already assigned to a different room: " + employee.getRooms().getFirst().getRoomNumber());
            LOGGER.info(COPY);
        }

    }
    public void addMassageRoom(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        LOGGER.info("Enter Room ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        LOGGER.info("Enter Employee ID to manage the new: ");
        String employeeId = scanner.next();
        Employee employee= EmployeeDB.getEmployeeById(employeeId);
        if(employee!=null){
            if(!employee.getRooms().isEmpty())
            {
                print(id,employee);
            }
            if(employee.getWorkerType().equalsIgnoreCase("Massage")){//
                if(!RoomDb.addRoom(employee, id)){
                    LOGGER.info(COPY);
                    LOGGER.info("This ID_room is Already Exists");
                    LOGGER.info(COPY);
                }
                else {
                    LOGGER.info(COPY);
                    LOGGER.info("Massage Room Added");
                    LOGGER.info(COPY);
                }
            }
            else{
                            LOGGER.info(COPY);

                LOGGER.info("not Massage employee!!");
                LOGGER.info("-----------------------");
            }
        }else{
                        LOGGER.info(COPY);

            LOGGER.info("employee not found!!");
            LOGGER.info("-----------------------");
        }
    }
    public void showAllEmployees(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        List<Employee> employees;
        employees=EmployeeDB.getServiceProviders();
        for(Employee employee :employees){
            LOGGER.info("----");
            LOGGER.info("Name: "+employee.getName()+"  ID: "+employee.getId()+" Type: "+employee.getWorkerType());
        }
    }
    public void addEmployee(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        LOGGER.info("=== Add Employee ===");
        LOGGER.info("Enter Employee ID: ");
        String employeeId = scanner.next();

        LOGGER.info("Enter Employee Name: ");
        String employeeName = scanner.next();

        LOGGER.info("Enter Employee Password: ");
        String employeePassword = scanner.next();

        LOGGER.info("Enter Employee Type (Sawna or Massage): ");
        String employeeType = scanner.next();
        if(!EmployeeDB.addServiceProviders(employeeId,employeeName,employeePassword,employeeType)){
            LOGGER.info(COPY);
            LOGGER.info("This ID is Already Exists");
            LOGGER.info(COPY);
        }else
            LOGGER.info("Employee added successfully!");

        LOGGER.info("================");
    }

    public static void showAppointments(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        LOGGER.info("=== All Appointments ===");
        List<Appointment> appointments;
        appointments = Appointment_DB.getAllAppointments();
        for(Appointment appointment:appointments){
            LOGGER.info("---------");
            LOGGER.info(" type: "+appointment.getEmployee().getWorkerType());
            LOGGER.info("Room: "+appointment.getRoom().getRoomNumber());
            LOGGER.info("Employee: "+appointment.getEmployee().getName());
            LOGGER.info("Date: "+appointment.getDate()+" Time"+appointment.getTime());
        }
    }
    public void showALlRooms(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        List<Room> rooms;
        rooms= RoomDb.rooms;
        LOGGER.info("we have " +rooms.size()+ " rooms");

        for(Room room:rooms){
            LOGGER.info("-----------");
            LOGGER.info("Room Id: "+room.getRoomNumber());
            LOGGER.info("Employee: "+room.getEmployee().getName());
        }
    }
    public void addAdmin(){
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        LOGGER.info("=== Add Admin ===");
        LOGGER.info("Enter Admin ID: ");
        String adminId = scanner.next();

        LOGGER.info("Enter Admin Name: ");
        String adminName = scanner.next();

        LOGGER.info("Enter Admin Password: ");
        String adminPassword = scanner.next();
        if(!AdminDB.addAdmin(adminId,adminName,adminPassword)){
            LOGGER.info(COPY);
            LOGGER.info("This ID is Already Exists");
            LOGGER.info(COPY);
        }else
            LOGGER.info("=== Admin added ===");
    }




    public void viewFeedbacks(){
        LOGGER.info(COPY);
        List<FeedBack>feedBacks;
        feedBacks= FeedbackDB.getFeedback();

        for (FeedBack feedback: feedBacks) {
            LOGGER.info(COPY);
            LOGGER.info("Client id: "+feedback.getClientId());
            LOGGER.info(feedback.getFeed());

        }

    }

    public void viewEmployeeEarningsForRange() {
        LOGGER.info("Enter Employee ID: ");
        scanner.nextLine();
        String employeeId = scanner.nextLine();
        LOGGER.info("Enter Start_Date (format: dd/MM/yyyy): ");
        String date = scanner.nextLine();
        LOGGER.info("Enter End_Date (format: dd/MM/yyyy): ");
        String date2 = scanner.nextLine();
        Appointment_DB.calculateEarningsForEmployeeInRange(employeeId, date,date2);
    }

    public void viewCenterEarningsForRange() {
        LOGGER.info("Enter Start_Date (format: dd/MM/yyyy): ");
        scanner.nextLine();
        String date = scanner.nextLine();
        LOGGER.info("\n");
        LOGGER.info("Enter End_Date (format: dd/MM/yyyy): ");
        String date2 = scanner.nextLine();
        LOGGER.info("\n");
         Appointment_DB.calculateTotalCenterEarningsInRange(date,date2);
    }





}

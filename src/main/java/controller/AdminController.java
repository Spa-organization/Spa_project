package controller;

import basic.LoggerUtility;
import entity.*;
import database.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdminController {
    Starter starter=new Starter();

    private static final Logger LOGGER = LoggerUtility.getLogger();
    private static final String COPY1="-----------------------------------\n-----------------------------------\n";
    private static final String COPY="-----------------------------------\n";
    private  boolean isLoggedIn;
    public Admin admin = new Admin();
    static Scanner scanner = new Scanner(System.in);
    public AdminController() {
        isLoggedIn = false;
    }
    public  boolean isLoggedIn() {return isLoggedIn;}
    public  void logout() {isLoggedIn=false;}
    public  void login() {isLoggedIn = true;}

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
            LOGGER.warning("LOGIN FAILD"+"\n");
        }
    }

    public void loginPage()  {
        LOGGER.severe(COPY1);
        LOGGER.fine("""
                === Admin Login ===
                """);
        LOGGER.info("Enter your ID:");
        String clientId = scanner.nextLine();
        LOGGER.info("Enter your password: ");
        String password = scanner.nextLine();
        loginCheck(clientId,password);
        if(isLoggedIn){
            adminHomePage();
        }
    }
    public void adminHomePage()  {
        LOGGER.severe(COPY1);
        int choice;
        do {
            LOGGER.fine("=== Admin "+admin.getName()+" Menu ==="+"\n");
            LOGGER.severe("""
                    1. Add Rooms
                    2. Add Employee
                    3. View Appointments
                    4. View Finance
                    5. Add Admin
                    6.delete Employee
                    7. Show All Rooms
                    8. View Feedbacks
                    9. view CenterEarningsForRange
                    10.edit employee
                    11.show all employee
                    12. logout
                    """);
            LOGGER.info("Enter your choice:");
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
                    showAllEmployees();
                    LOGGER.info("\n"+"Inter the id of Employee you want to delete:");
                    String employeeId = scanner.nextLine();
                    scanner.nextLine();
                   // EmployeeDB.deleteEmployee(employeeId); break;
                case 7:
                    showALlRooms();
                    break;
                case 8 :
                    viewFeedbacks();
                    break;
                case 9:viewCenterEarningsForRange();
                    break;
                case 10:
                    LOGGER.severe(COPY1);
                    LOGGER.fine("=== edit Employee ===");
                    LOGGER.info("\nEnter Employee ID: ");
                    String empId = scanner.next();

                    LOGGER.info("Enter Employee Name: ");
                    String employeeName = scanner.next();

                    LOGGER.info("Enter Employee Password: ");
                    String employeePassword = scanner.next();

                    LOGGER.info("Enter Employee Type (1.Sawna or 2.Massage): ");
                    String employeeType = scanner.next();

                    LOGGER.info("Enter NEW ROOM ID: ");
                    int roomId = scanner.nextInt();
                   EmployeeDB.editEmployee(empId,employeeName,employeePassword,employeeType, roomId);
                    break;
                case 11:
                    showAllEmployees();
                    break;
                case 12:LOGGER.info("\n"+"""
                            Logging out. Goodbye!
                            
                            """);
                starter.choseEntity();
                break;
                case 100:
                    return;
                default:
                    LOGGER.info("\n"+"""
                            Invalid choice. Please try again.

                            """);

            }

        } while (choice != 12);

    }


    public void addRoom()  {
        LOGGER.info(COPY);
        LOGGER.info(COPY);
        int roomType;
        do {
            LOGGER.severe("""
                    Add Rooms
                    1. sawna Room
                    2. Massage Room
                    3. Show All Employees with ID
                    4. Exit
                    Enter your choice:""");
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
                    adminHomePage();
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }
        } while (roomType != 4);
    }
    public void addSawnaRoom() {
        LOGGER.info("\n"+"Enter Room ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        LOGGER.info("Enter Employee ID to manage the new Room: ");
        String employeeId = scanner.next();
        Employee employees= EmployeeDB.getEmployeeById(employeeId);
        if(employees!=null){
            if(!employees.getRooms().isEmpty())
            {
               print(id,employees);
            }

            else if(employees.getWorkerType().equalsIgnoreCase("Sawna")){
                if(!RoomDb.addRoom(employees, id)){
                    LOGGER.info(COPY+"This ID_room is Already Exists"+COPY);
                }
                else {

                    LOGGER.info(COPY+
                            "Sawna Room Added"+"\n+" +
                            COPY);
                }
            }
            else{
                LOGGER.info(COPY+
                        "not Sawna employee!!"+"\n"+
                        COPY);
            }
        }else{
            LOGGER.info(COPY+
                    "employee not found!!"+"\n"+
                    COPY);
        }
    }
    public void print(int id,Employee employee ){

        if(employee.getRooms().get(0).getRoomNumber() == id)
        {LOGGER.info(COPY+ "The employee is already assigned to this room"+"\n"+ COPY);}
        else
        {LOGGER.info(COPY+ "The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber()+"\n"+ COPY);}

    }
    public void addMassageRoom(){
        LOGGER.info("\n"+"Enter Room ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        LOGGER.info("Enter Employee ID to manage the new Room: ");
        String employeeId = scanner.next();
        Employee employees= EmployeeDB.getEmployeeById(employeeId);
        if(employees!=null){
            if(!employees.getRooms().isEmpty())
            {
                print(id,employees);
            }
            if(employees.getWorkerType().equalsIgnoreCase("Massage")){
                if(!RoomDb.addRoom(employees, id)){
                    LOGGER.info(COPY+"This ID_room is Already Exists"+COPY);
                }
                else {
                    LOGGER.info(COPY+
                            "massage Room Added"+"\n+" +
                            COPY);
                }
            }
            else{
                LOGGER.info(COPY+
                        "not Massage employee!!"+"\n"+
                        COPY);

            }
        }else{
            LOGGER.info(COPY+
                    "employee not found!!"+"\n"+
                    COPY);
        }
    }
    public static boolean showAllEmployees(){
        LOGGER.info(COPY1);
        List<Employee> employees;
        employees=EmployeeDB.getServiceProviders();
        for(Employee employee :employees){
            LOGGER.info("Name: "+employee.getName()+"  ID: "+employee.getId()+" Type: "+employee.getWorkerType()+"\n");
        }
        LOGGER.info(COPY1);
        return true;
    }
    public void addEmployee(){
        LOGGER.info(COPY1+
                "=== Add Employee ==="+"\n"+
                        "Enter Employee ID: ");
        String employeeId = scanner.next();

        LOGGER.info("\n"+"Enter Employee Name: ");
        String employeeName = scanner.next();

        LOGGER.info("\n"+"Enter Employee Password: ");
        String employeePassword = scanner.next();

        LOGGER.info("\n"+"Enter Employee Type (Sawna or Massage): ");
        String employeeType = scanner.next();
        LOGGER.info("Enter Employee Profit Percentage: ");
        String employeeProfitPercentage = scanner.next();
        if(!EmployeeDB.addServiceProviders(employeeId,employeeName,employeePassword,employeeType,employeeProfitPercentage)){

            LOGGER.info(COPY+
                    "This ID is Already Exists"+"\n"+
                    COPY);
        }else
            LOGGER.info("Employee added successfully!"+"\n"+"================");
    }

    public static boolean showAppointments(){

        LOGGER.info(COPY1+"=== All Appointments ==="+"\n");
        List<Appointment> appointments;
        appointments = AppointmentDb.getAllAppointments();
        for(Appointment appointment:appointments){
            LOGGER.info("---------"+"\n"+
                    " type: "+appointment.getEmployee().getWorkerType()+"\n"+
                            "Room: "+appointment.getRoom().getRoomNumber()+"\n"+
                            "Employee: "+appointment.getEmployee().getName()+"\n"+
                            "Date: "+appointment.getDate()+" Time"+appointment.getTime()
                    );
        }return true;
    }
    public boolean showALlRooms(){
        LOGGER.info(COPY1);
        List<Room> rooms;
        rooms= RoomDb.rooms;
        LOGGER.log(Level.INFO, "we have {} rooms", rooms.size());
        for(Room room:rooms){
            LOGGER.info("-----------" +"\n"+
                    "Room Id: "+room.getRoomNumber()+
                    "Employee: "+room.getEmployee().getName());}
        return true;
    }
    public void addAdmin(){
        LOGGER.info(COPY1+"=== Add Admin ===\n"+"Enter Admin ID:");
        String adminId = scanner.next();

        LOGGER.info("\nEnter Admin Name: ");
        String adminName = scanner.next();

        LOGGER.info("\nEnter Admin Password: ");
        String adminPassword = scanner.next();
        if(!AdminDB.addAdmin(adminId,adminName,adminPassword)){
            LOGGER.info(COPY+"This ID is Already Exists\n"+COPY);
        }else
            LOGGER.info("=== Admin added ===");
    }
    public boolean viewFeedbacks(){
        LOGGER.info(COPY);
        List<FeedBack>feedBacks;
        feedBacks= FeedbackDB.getFeedback();
        for (FeedBack feedback: feedBacks) {
            LOGGER.info(COPY+"Client id: "+feedback.getClientId()+"\n"+feedback.getFeed());
        }
        return true;
    }

    public void viewEmployeeEarningsForRange() {
        LOGGER.info("Enter Employee ID: ");
        scanner.nextLine();
        String employeeId = scanner.nextLine();
        LOGGER.info("\nEnter Start_Date (format: dd/MM/yyyy): ");
        String date = scanner.nextLine();
        LOGGER.info("\nEnter End_Date (format: dd/MM/yyyy): ");
        String date2 = scanner.nextLine();
        AppointmentDb.calculateEarningsForEmployeeInRange(employeeId, date,date2);
    }

    public void viewCenterEarningsForRange() {
        LOGGER.info("Enter Start_Date (format: dd/MM/yyyy): ");
        scanner.nextLine();
        String date = scanner.nextLine();
        LOGGER.info("\n");
        LOGGER.info("Enter End_Date (format: dd/MM/yyyy): ");
        String date2 = scanner.nextLine();
        LOGGER.info("\n");
        AppointmentDb.calculateTotalCenterEarningsInRange(date,date2);
    }




}

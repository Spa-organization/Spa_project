package controller;

import basic.LoggerUtility;
import entity.*;
import database.*;
import java.util.List;
import java.util.Scanner;
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
//
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
                    9. view_CenterAndEmployee_EarningsForRange
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
                    viewCenterEarningsForRange();
                    //should delete
                    break;
                case 5:
                    addAdmin();
                    break;
                case 6:
                    EmployeeDB.deleteEmployee();
                    break;
                case 7:
                    EmployeeDB.showALlRooms();
                    break;
                case 8 :
                    viewFeedbacks();
                    break;
                case 9:
                   AppointmentDb.calculateEarningsForEmployeeAndCenterInRange(1);
                    break;
                case 10:
                   EmployeeDB.editEmployee();
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
                    LOGGER.warning("\n"+"""
                            Invalid choice. Please try again.

                            """);

            }

        } while (choice != 12);

    }


    public void addRoom()  {
        LOGGER.severe(COPY1);
        int roomType;
        do {
            LOGGER.fine("Add Rooms\n");
            LOGGER.severe("""
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
                    LOGGER.warning("Invalid choice. Please try again.");
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
                    LOGGER.severe(COPY);
                    LOGGER.info("Sawna Room Added"+"\n");
                    LOGGER.severe(COPY);
                }
            }
            else{
                LOGGER.severe(COPY);
                LOGGER.warning("not Sawna employee!!"+"\n");
                LOGGER.severe(COPY);
            }
        }else{
            LOGGER.severe(COPY);
            LOGGER.warning("employee not found!!"+"\n");
            LOGGER.severe(COPY);
        }
    }
    public void print(int id,Employee employee ){

        if(employee.getRooms().get(0).getRoomNumber() == id)
        {
            LOGGER.severe(COPY);
            LOGGER.warning( "The employee is already assigned to this room"+"\n");
            LOGGER.severe(COPY);
        }
        else
        {
            LOGGER.severe(COPY);
            LOGGER.warning("The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber()+"\n");}
            LOGGER.severe(COPY);
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
                    LOGGER.severe(COPY);
                    LOGGER.warning("This ID_room is Already Exists"+"\n");
                    LOGGER.severe(COPY);
                }
                else {
                    LOGGER.severe(COPY);
                    LOGGER.info("massage Room Added"+"\n");
                    LOGGER.severe(COPY);
                }
            }
            else{
                LOGGER.severe(COPY);
                LOGGER.warning( "not Massage employee!!"+"\n");
                LOGGER.severe(COPY);
            }
        }else{
            LOGGER.severe(COPY);
            LOGGER.warning("employee not found!!"+"\n");
            LOGGER.severe(COPY);
        }
    }
    public static boolean showAllEmployees(){
        LOGGER.severe(COPY1);
        List<Employee> employees;
        employees=EmployeeDB.getServiceProviders();

        for(Employee employee :employees){

            LOGGER.info("Name: "+employee.getName()+"   "+"  ID: "+employee.getId()+"   "+" Type: "+employee.getWorkerType()+ "   " + "room id: "+employee.getRoom().getRoomNumber()+"\n");
        }
        LOGGER.severe(COPY1);
        return true;
    }

    public void addEmployee(){
        LOGGER.severe(COPY1);
        LOGGER.fine("=== Add Employee ==="+"\n");
        LOGGER.info("Enter Employee ID: ");
        scanner.nextLine();
        String employeeId = scanner.nextLine();

        LOGGER.info("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        LOGGER.info("Enter Employee Password: ");
        String employeePassword = scanner.nextLine();

        LOGGER.info("Enter Employee Type (Sawna or Massage): ");
        String employeeType = scanner.nextLine();
        LOGGER.info("Enter Employee Profit Percentage--->: ");
        double employeeProfitPercentage = scanner.nextDouble();

        if(!EmployeeDB.addServiceProviders(employeeId,employeeName,employeePassword,employeeType,employeeProfitPercentage)){
            LOGGER.severe("\n"+COPY);
            LOGGER.warning("This ID is Already Exists"+"\n");
            LOGGER.severe(COPY);

        }else
            LOGGER.info("Employee added successfully!"+"\n");
    }

    public static boolean showAppointments(){
        LOGGER.fine("=== All Appointments ==="+"\n");
        List<Appointment> appointments;
        appointments = AppointmentDb.getAllAppointments();
        for(Appointment appointment:appointments){
            LOGGER.severe(COPY);
            LOGGER.info(
                    "type: "+appointment.getEmployee().getWorkerType()+"\n"+
                            "Room: "+appointment.getRoom().getRoomNumber()+"\n"+
                            "Employee: "+appointment.getEmployee().getName()+"\n"+
                            "Date: "+appointment.getDate()+"\n"+"Time"+appointment.getTime()+"\n"
                    );
        }LOGGER.severe("\n");return true;
    }
    public void addAdmin(){
        LOGGER.severe(COPY1);
        LOGGER.fine("=== Add Admin ===\n");
        LOGGER.info("Enter Admin ID:");
        String adminId = scanner.next();

        LOGGER.info("Enter Admin Name: ");
        String adminName = scanner.next();

        LOGGER.info("Enter Admin Password: ");
        String adminPassword = scanner.next();
        if(!AdminDB.addAdmin(adminId,adminName,adminPassword)){
            LOGGER.severe(COPY);
            LOGGER.warning("This ID is Already Exists"+"\n");
            LOGGER.severe(COPY);
        }else
            LOGGER.info("Admin added successfully"+"\n");
    }
    public boolean viewFeedbacks(){
        LOGGER.severe("\n");
        List<FeedBack>feedBacks;
        feedBacks= FeedbackDB.getFeedback();
        for (FeedBack feedback: feedBacks) {
            LOGGER.info("Client id: "+feedback.getClientId()+"-------> "+feedback.getFeed()+"\n");
            LOGGER.severe(COPY);

        }
        return true;
    }



    public void viewCenterEarningsForRange() {
        LOGGER.info("Enter Start_Date (format: dd/MM/yyyy): ");
        scanner.nextLine();
        String date = scanner.nextLine();
        LOGGER.info("Enter End_Date (format: dd/MM/yyyy): ");
        String date2 = scanner.nextLine();
        AppointmentDb.calculateTotalCenterEarningsInRange(date,date2);
    }




}

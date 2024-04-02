package database;
import basic.LoggerUtility;
import entity.Appointment;
import entity.Employee;
import entity.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static controller.AdminController.showAllEmployees;

public class EmployeeDB {
    static List<Employee> employees = new ArrayList<>();



    private static final String SHORT_LINE ="--------------------\n";
    private static final String COPY1="-----------------------------------\n-----------------------------------\n";
    private static final Logger LOGGER = LoggerUtility.getLogger();
    private static final String MASSAGE="Massage";
    private static final  String SAWNA="Sawna";

    public static Scanner scan=new Scanner(System.in);
    private EmployeeDB() {

    }
    static{
        employees.add(new Employee("31","SerPro1","123",MASSAGE, new Room(1),0.40));
        employees.add(new Employee("32","SerPro2","123",SAWNA,new Room(2),0.25));
        employees.add(new Employee("33","SerPro3","123",SAWNA,new Room(3),0.28));
        employees.add(new Employee("34","SerPro4","123",MASSAGE,new Room(4),0.37));
        employees.add(new Employee("100","SerPro5","123",SAWNA,0.20));
        employees.add(new Employee("101","SerPro6","123",MASSAGE,0.30));
        employees.get(0).getRoom().setEmployee(employees.get(0));
        employees.get(1).getRoom().setEmployee(employees.get(1));
        employees.get(2).getRoom().setEmployee(employees.get(2));
        employees.get(3).getRoom().setEmployee(employees.get(3));
        RoomDb.rooms.add(employees.get(0).getRoom());
        RoomDb.rooms.add(employees.get(1).getRoom());
        RoomDb.rooms.add(employees.get(2).getRoom());
        RoomDb.rooms.add(employees.get(3).getRoom());
    }
    public static boolean addServiceProviders(String id,String name,String password,String workerType,double profitpercentage) {
        boolean flag = true;
        for (Employee employee: employees){
            if(employee.getId().equals(id)){
                flag=false;
                break;
            }
        }
        if(flag)
            employees.add(new Employee(id, name,password,workerType));

        return flag;
    }
    public static List<Employee> getServiceProviders() {
        return employees;
    }
    public static List<Employee> getEmployeeAtTime(String date, String time,String type){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee1:employees){
            if(employee1.getWorkerType().equals(type)) {
                boolean flag = true;
                for (Appointment appointment : employee1.getAppointments()) {
                    if (appointment.getDate().equals(date) && appointment.getTime().equals(time)){
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    employeeList.add(employee1);
                }
            }
        }
        return employeeList;
    }
    public static Employee getEmployeeById(String id){
        for(Employee employee: employees){
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }


    public static boolean deleteEmployee( ) {
        showAllEmployees();
        LOGGER.info("\n"+"Inter the id of Employee you want to delete:");
        String employeeId = scan.nextLine();
        scan.nextLine();
        boolean found = false;
        for (Employee employee : employees)
        {
            if (employee.getId().equals(employeeId)) {
                employees.removeIf(h -> h.getId().equals(employeeId) );

                employees.remove(employee);
                AppointmentDb.appointments.removeIf(appointment -> appointment.getEmployee().getId().equals(employeeId));
                found = true;
                LOGGER.info("employee deleted successful");
                break;}
        }
        return found;
    }

    public static double getEmployeeProfitPercentage(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                return employee.getProfitPercentage();
            }
        }
        return 0.00;
    }

    public static boolean editEmployee() {
        LOGGER.severe(COPY1);
        LOGGER.fine("=== edit Employee ===");
        LOGGER.info("\nEnter Employee ID: ");
        String empId = scan.next();

        LOGGER.info("Enter new Employee Name: ");
        String employeeName = scan.next();

        LOGGER.info("Enter new Employee Password: ");
        String employeePassword = scan.next();

        LOGGER.info("Enter new Employee Type (1.Sawna or 2.Massage): ");
        String employeeType = scan.next();
        LOGGER.info("Enter new Employee profit percantage: ");
        double per = scan.nextDouble();

        LOGGER.info("Enter NEW ROOM ID: ");
        int roomId = scan.nextInt();
        for (Employee employee : employees) {
            if (employee.getId().equals(empId)&&RoomDb.checkValidateID(roomId))
            {
                employee.setName(employeeName);
                employee.setPassword(employeePassword);
                employee.setWorkerType(Integer.parseInt(employeeType));
                RoomDb.addRoom(employee,roomId);
                    employee.getRoom().setRoomNumber(roomId);
                    employee.setProfitPercentage(per);
                    if(LOGGER.isLoggable(Level.INFO))
                    {    LOGGER.info("Employee "+empId+" has been updated"+"\n");}
                    return true;
            }
        }
        LOGGER.warning("NOT A SUCCESSFUL EDIT"+"\n");
        return false;
    }
    public static boolean showALlRooms(){
        List<Room> rooms;
        rooms= RoomDb.rooms;
        if(LOGGER.isLoggable(Level.INFO))
        {LOGGER.info("\n"+" we have " + rooms.size() + " rooms" + "\n");}
        LOGGER.severe(SHORT_LINE);
        for(Room room:rooms){
            LOGGER.info(
                    "Room Id: "+room.getRoomNumber()+" "+
                            "EmployeeName: "+room.getEmployee().getName()+"\n");}

        LOGGER.severe(SHORT_LINE);
        return true;
    }

}

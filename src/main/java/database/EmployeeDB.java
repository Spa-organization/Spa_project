package database;


import basic.LoggerUtility;
import entity.Appointment;
import entity.Employee;
import entity.Room;
//
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDB {
    static List<Employee> employees = new ArrayList<>();
    private static final Logger LOGGER = LoggerUtility.getLogger();

    private EmployeeDB() {

    }
    static{
        employees.add(new Employee("31","SerPro1","123","Sawna", new Room(1)));
        employees.add(new Employee("32","SerPro2","123","Sawna",new Room(2)));
        employees.add(new Employee("33","SerPro3","123","Massage",new Room(3)));
        employees.add(new Employee("34","SerPro4","123","Massage",new Room(4)));

        employees.add(new Employee("100","SerPro4","123","Massage"));
        employees.add(new Employee("101","SerPro4","123","Massage"));
        employees.get(0).getRoom().setEmployee(employees.get(0));
        employees.get(1).getRoom().setEmployee(employees.get(1));
        employees.get(2).getRoom().setEmployee(employees.get(2));
        employees.get(3).getRoom().setEmployee(employees.get(3));
        RoomDb.rooms.add(employees.get(0).getRoom());
        RoomDb.rooms.add(employees.get(1).getRoom());
        RoomDb.rooms.add(employees.get(2).getRoom());
        RoomDb.rooms.add(employees.get(3).getRoom());
    }
    public static boolean addServiceProviders(String id,String name,String password,String workerType) {
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

    public static boolean deleteEmployee(String employeeId) {
        boolean found = false;
        Employee toRemove = null;
        for (Employee employee : employees)
        {
            if (employee.getId().equals(employeeId)) {
                toRemove = employee;
                found = true;
                break;}
        }

        if (found) {
            AppointmentDb.appointments.removeIf(appointment -> appointment.getEmployee().getId().equals(employeeId));
            employees.remove(toRemove);
            LOGGER.info("employee deleted successful");
            if (toRemove.getRoom() != null) {
                toRemove.getRoom().setEmployee(null);
            }
        }
        return found;
    }
    public static boolean editEmployee(String id, String newName, String newPassword, String newWorkerType,int roomId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)&&RoomDb.checkValidateID(roomId))
            {
                employee.setName(newName);
                employee.setPassword(newPassword);
                employee.setWorkerType(Integer.parseInt(newWorkerType));
                    employee.getRoom().setRoomNumber(roomId);
                LOGGER.log(Level.INFO, "Employee {} has been updated"+"\n",id);
                    return true;
            }
        }
        LOGGER.info("NOT A SUCCESSFUL EDIT"+"\n");
        return false;
    }

}

package database;


import entity.Appointment;
import entity.Employee;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
    static List<Employee> employees = new ArrayList<>();
    private EmployeeDB() {

    }
    static{
        employees.add(new Employee("31","SerPro1","123","Sawna", new Room(1)));
        employees.add(new Employee("32","SerPro2","123","Sawna",new Room(2)));
        employees.add(new Employee("33","SerPro3","123","Massage",new Room(3)));
        employees.add(new Employee("34","SerPro4","123","Massage",new Room(4)));
        employees.get(0).getRoom().setEmployee(employees.get(0));
        employees.get(1).getRoom().setEmployee(employees.get(1));
        employees.get(2).getRoom().setEmployee(employees.get(2));
        employees.get(3).getRoom().setEmployee(employees.get(3));
        RoomDb.rooms.add(employees.get(0).getRoom());
        RoomDb.rooms.add(employees.get(1).getRoom());
        RoomDb.rooms.add(employees.get(2).getRoom());
        RoomDb.rooms.add(employees.get(3).getRoom());
    }
    public static boolean addServiceProviders(String id,String name,String password,String workerType, String profitpercentage) {
        boolean flage = true;
        for (Employee employee: employees){
            if(employee.getId().equals(id)){
                flage=false;
                break;
            }
        }
        if(flage)
            employees.add(new Employee(id, name,password,workerType,profitpercentage));

        return flage;
    }
    public static List<Employee> getServiceProviders() {
        return employees;
    }
    public static List<Employee> getEmployeeAtTime(String date, String time,String type){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee1:employees){
            if(employee1.getWorkerType().equals(type)) {
                boolean flage = true;
                for (Appointment appointment : employee1.getAppointments()) {
                    if (appointment.getDate().equals(date) && appointment.getTime().equals(time)){
                        flage=false;
                        break;
                    }
                }
                if(flage) {
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
    public static String getEmployeeProfitPercentage(String employeeId) {
        for (Employee employee : employees) { // Assuming 'employees' is an iterable collection of Employee objects
            if (employee.getId().equals(employeeId)) {
                return employee.getProfitPercentage(); // Assuming Employee class has a getProfitPercentage method
            }
        }
        return null; // Return a default value indicating not found
    }

    public static EmployeeDB createEmployeeDB() {
        return new EmployeeDB();
    }
}

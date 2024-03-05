package database;

import Entities.Appointment;
import Entities.Client;
import Entities.Employee;
//adadad
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Appointment_DB {
    static List<Appointment> appointments= new ArrayList<>();
    private Appointment_DB() {
        throw new IllegalStateException("Utility class");
    }
    static {
        appointments.add(new Appointment(Client_DB.clients.get(0),Employee_DB.employees.get(0), Employee_DB.employees.get(0).getRoom(),"1/9/2012","9:00",true));
        appointments.add(new Appointment(Client_DB.clients.get(1),Employee_DB.employees.get(1), Employee_DB.employees.get(1).getRoom(),"1/9/2012","9:00",true));
        appointments.add(new Appointment(Client_DB.clients.get(2),Employee_DB.employees.get(2), Employee_DB.employees.get(2).getRoom(),"1/9/2012","9:00",true));
        appointments.add(new Appointment(Client_DB.clients.get(3),Employee_DB.employees.get(3), Employee_DB.employees.get(3).getRoom(),"1/9/2012","9:00",true));
        Employee_DB.employees.get(0).setAppointment(appointments.get(0));
        Employee_DB.employees.get(1).setAppointment(appointments.get(1));
        Employee_DB.employees.get(2).setAppointment(appointments.get(2));
        Employee_DB.employees.get(3).setAppointment(appointments.get(3));
    }
    public static int addAppointment(Client client,String date, String time,Employee employee){
        if(!isValidDate(date)) return 2;
        if(!isValidTime(time)) return 1;
        appointments.add(new Appointment(client,employee,employee.getRoom(),date,time,true));
        employee.setAppointment(appointments.get(appointments.size()-1));
        return 0;
    }
    public static List<Appointment> getAllAppointments(){
        return appointments;
    }
    public static List<Employee> checkAvailability(String Date, String Time,String type){

        return Employee_DB.getEmployeeAtTime(Date,Time,type);
    }
    public static  List<Appointment> getUserAppointments(Client client){
        List<Appointment> clientAppointments= new ArrayList<>();
        for(Appointment appointment:appointments){
            if(appointment.getClient().equals(client)){
                clientAppointments.add(appointment);
            }
        }
        return clientAppointments;
    }
    public static boolean isValidDate(String date) {

        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(date);


        return matcher.matches();
    }
    public static boolean isValidTime(String time) {

        String regex = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(time);


        return matcher.matches();
    }

}

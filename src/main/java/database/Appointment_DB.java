package database;

import Entities.Appointment;
import Entities.Client;
import Entities.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Appointment_DB {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final double SAWNA_SESSION_COST = 200.0; // Example cost
    public static final double MASSAGE_SESSION_COST = 250.0; // Example cost
    public static final double EMPLOYEE_PERCENTAGE = 0.30;
    public static final double CENTER_PERCENTAGE = 0.70;

   public static List<Appointment> appointments= new ArrayList<>();
    private Appointment_DB() {
        throw new IllegalStateException("Utility class");
    }
    static {
        appointments.add(new Appointment(1,Client_DB.clients.get(0),Employee_DB.employees.get(0), Employee_DB.employees.get(0).getRoom(),"01/09/2012","09:00",true));
        appointments.add(new Appointment(2,Client_DB.clients.get(1),Employee_DB.employees.get(1), Employee_DB.employees.get(1).getRoom(),"01/09/2012","09:00",true));
        appointments.add(new Appointment(3,Client_DB.clients.get(2),Employee_DB.employees.get(2), Employee_DB.employees.get(2).getRoom(),"01/09/2012","09:00",true));
        appointments.add(new Appointment(4,Client_DB.clients.get(3),Employee_DB.employees.get(3), Employee_DB.employees.get(3).getRoom(),"01/09/2012","09:00",true));
        Employee_DB.employees.get(0).setAppointment(appointments.get(0));
        Employee_DB.employees.get(1).setAppointment(appointments.get(1));
        Employee_DB.employees.get(2).setAppointment(appointments.get(2));
        Employee_DB.employees.get(3).setAppointment(appointments.get(3));
    }
    public static int addAppointment(int id,Client client, String date, String time, Employee employee){
        id = appointments.getLast().getAppointmentID() + 1;
        if(!isValidDate(date)) return 2;
        if(!isValidTime(time)) return 1;
        appointments.add(new Appointment(id,client,employee,employee.getRoom(),date,time,true));
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

    public static List<Appointment> getEmployeeAppointments(Employee employee){
        List<Appointment> employeeAppointments= new ArrayList<>();
        for(Appointment appointment:appointments){
            if(appointment.getEmployee().equals(employee)){
                employeeAppointments.add(appointment);
            }
        }
        return employeeAppointments;
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

    public static void deleteAppointment(int id){
        appointments.removeIf(h -> h.getAppointmentID() == id);}


        public static boolean calculateEarningsForEmployeeInRange(String employeeId, String startDateStr, String endDateStr) {
        boolean flag=false;
            LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
            LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);
            double totalEarnings = 0;

            for (Appointment appointment : Appointment_DB.getAllAppointments()) {
                LocalDate appointmentDate = LocalDate.parse(appointment.getDate(), DATE_FORMATTER);
                if (!appointmentDate.isBefore(startDate) && !appointmentDate.isAfter(endDate) && appointment.getEmployee().getId().equals(employeeId)) {
                    if ("Sawna".equalsIgnoreCase(appointment.getEmployee().getWorkerType())) {
                        flag=true;
                        totalEarnings +=SAWNA_SESSION_COST;

                    } else if ("Massage".equalsIgnoreCase(appointment.getEmployee().getWorkerType())) {
                        flag=true;
                        totalEarnings += MASSAGE_SESSION_COST;

                    }
                }

            }
            double employeeEarnings = totalEarnings * EMPLOYEE_PERCENTAGE;
            double centerEarnings = totalEarnings * CENTER_PERCENTAGE;
            System.out.println("Total Earnings for Employee " + employeeId + " from " + startDateStr + " to " + endDateStr + ": $" + totalEarnings);
            System.out.println("Employee's Share (30%): $" + employeeEarnings);
            System.out.println("Center's Share (70%): $" + centerEarnings);
            return  flag;
        }
    public static boolean calculateTotalCenterEarningsInRange(String startDateStr, String endDateStr) {
        boolean flag=false;
        LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
        LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);
        double totalEarnings = 0;

        for (Appointment appointment : Appointment_DB.getAllAppointments()) {
            LocalDate appointmentDate = LocalDate.parse(appointment.getDate(), DATE_FORMATTER);
            if (!appointmentDate.isBefore(startDate) && !appointmentDate.isAfter(endDate)) {
                if ("Sawna".equalsIgnoreCase(appointment.getEmployee().getWorkerType())) {
                    flag=true;
                    totalEarnings += SAWNA_SESSION_COST;

                } else if ("Massage".equalsIgnoreCase(appointment.getEmployee().getWorkerType())) {
                    flag=true;
                    totalEarnings += MASSAGE_SESSION_COST;
                }
            }
        }
        double centerEarnings = totalEarnings * CENTER_PERCENTAGE;
        System.out.println("Total Center Earnings from " + startDateStr + " to " + endDateStr + ": $" + centerEarnings);
        return  flag;
    }



}

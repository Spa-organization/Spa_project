package database;

import basic.LoggerUtility;
import entity.Appointment;
import entity.Client;
import entity.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppointmentDb {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Logger LOGGER = LoggerUtility.getLogger();
    public static final double SAWNA_SESSION_COST = 200.0; // Example cost
    public static final double MASSAGE_SESSION_COST = 250.0; // Example cost
    public static final double EMPLOYEE_PERCENTAGE = 0.30;
    public static final double CENTER_PERCENTAGE = 0.70;

   public static List<Appointment> appointments= new ArrayList<>();
    private AppointmentDb() {
        throw new IllegalStateException("Utility class");
    }
    static {
        appointments.add(new Appointment(1,ClientDB.clients.get(0),EmployeeDB.employees.get(0), EmployeeDB.employees.get(0).getRoom(),"01/04/2012","8:00",true));
        appointments.add(new Appointment(2,ClientDB.clients.get(1),EmployeeDB.employees.get(1), EmployeeDB.employees.get(1).getRoom(),"01/09/2012","10:00",true));
        appointments.add(new Appointment(3,ClientDB.clients.get(2),EmployeeDB.employees.get(2), EmployeeDB.employees.get(2).getRoom(),"02/09/2012","09:00",true));
        appointments.add(new Appointment(4,ClientDB.clients.get(3),EmployeeDB.employees.get(3), EmployeeDB.employees.get(3).getRoom(),"01/09/2012","09:00",true));
        EmployeeDB.employees.get(0).setAppointment(appointments.get(0));
        EmployeeDB.employees.get(1).setAppointment(appointments.get(1));
        EmployeeDB.employees.get(2).setAppointment(appointments.get(2));
        EmployeeDB.employees.get(3).setAppointment(appointments.get(3));
    }
    public static int addAppointment(Client client, String date, String time, Employee employee){
        if(!isValidDate(date)) return 2;
        if(!isValidTime(time)) return 1;
        appointments.add(new Appointment(appointments.get(appointments.size()-1).getAppointmentID() + 1,client,employee,employee.getRoom(),date,time,true));
        employee.setAppointment(appointments.get(appointments.size()-1));
        return 0;
    }
    public static List<Appointment> getAllAppointments(){
        return appointments;
    }
    public static List<Employee> checkAvailability(String date, String time,String type){

        return EmployeeDB.getEmployeeAtTime(date,time,type);
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

            for (Appointment appointment : AppointmentDb.getAllAppointments()) {
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
            LOGGER.info("Total Earnings for Employee " + employeeId + " from " + startDateStr + " to " + endDateStr + ": $" + totalEarnings+"\n"+
                            "Employee's Share (30%): $" + employeeEarnings+"\n"+
                            "Center's Share (70%): $" + centerEarnings
                    );
            return  flag;
        }
    public static void calculateTotalCenterEarningsInRange(String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
        LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);
        double totalEarnings = 0;

        for (Appointment appointment : AppointmentDb.getAllAppointments()) {
            LocalDate appointmentDate = LocalDate.parse(appointment.getDate(), DATE_FORMATTER);
            if (!appointmentDate.isBefore(startDate) && !appointmentDate.isAfter(endDate)) {
                if ("Sawna".equalsIgnoreCase(appointment.getEmployee().getWorkerType())) {
                    totalEarnings += SAWNA_SESSION_COST;

                } else if ("Massage".equalsIgnoreCase(appointment.getEmployee().getWorkerType())) {
                    totalEarnings += MASSAGE_SESSION_COST;
                }
            }
        }
        double centerEarnings = totalEarnings * CENTER_PERCENTAGE;
        LOGGER.info("Total Center Earnings from " + startDateStr + " to " + endDateStr + ": $" + centerEarnings);

    }



}

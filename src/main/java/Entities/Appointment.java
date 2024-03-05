package Entities;

public class Appointment {
    static int AppointmentID=0;
    private  Client client = new Client();
    private  Employee employee = new Employee();
    private Room room;
    private String Date;
    private String time;
    private String ServiceType = employee.getWorkerType();
    private boolean Booked= false;

    public Appointment( Client client, Employee employee, Room room, String date, String time, boolean booked) {
        AppointmentID ++;
        this.client = client;
        this.employee = employee;
        this.room = room;
        Date = date;
        this.time = time;
        Booked = booked;
    }

    public int getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        AppointmentID = appointmentID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public boolean isBooked() {
        return Booked;
    }

    public void setBooked(boolean booked) {
        Booked = booked;
    }

}

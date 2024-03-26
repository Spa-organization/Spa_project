package entity;

public class Appointment {
     int appointmentId;
    private  Client client = new Client();
    private  Employee employee = new Employee();
    private Room room;
    private String date;
    private String time;

    private boolean booked = false;

    public Appointment( int id,Client client, Employee employee, Room room, String date, String time, boolean booked) {
        appointmentId =id;
        this.client = client;
        this.employee = employee;
        this.room = room;
        this.date = date;
        this.time = time;
        this.booked = booked;
    }

    public int getAppointmentID() {
        return appointmentId;
    }

    public void setAppointmentID(int appointmentID) {
        appointmentId = appointmentID;
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
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

}

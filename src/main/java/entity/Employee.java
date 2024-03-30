package entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String id ;
    private String name;
    private String password;
    private String workerType;
    private String profitpercentage;
    private final List<Room> rooms = new ArrayList<>();

    private final List<Appointment> appointments =new ArrayList<>();

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
    public String getProfitPercentage() {
        return this.profitpercentage;
    }
    public Employee(){ }
    public Employee(String id, String name, String password,String workerType,Room room) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.workerType = workerType;
        this.rooms.add(room);
    }
    public Employee(String id, String name, String password,String workerType,String profitpercentage) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.workerType = workerType;
        this.profitpercentage = profitpercentage;

    }
    public Room getRoom(){
        return rooms.get(0);
    }
    public void addRoomToEmployee(Room room){
        this.rooms.add(room);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkerType() {
        return workerType;
    }
    public void setProfitPercentage(String profitPercentage) {
        this.profitpercentage = profitPercentage;
    }
    public void setWorkerType(int workerTypeId) {
        if(workerTypeId == 1){
            workerType ="Sawna";
        }
        else if( workerTypeId ==2){
            workerType ="Massage";
        }
    }

}

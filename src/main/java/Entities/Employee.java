package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private String id ;
    private String Name;
    private String password;
    private String WorkerType ;
    private List<Room> rooms = new ArrayList<>();
    private List<Appointment> appointments =new ArrayList<>();

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public Employee(){ }
    public Employee(String id, String name, String password,String WorkerType,Room room) {
        this.id = id;
        Name = name;
        this.password = password;
        this.WorkerType = WorkerType;
        this.rooms.add(room);
    }
    public Employee(String id, String name, String password,String WorkerType) {
        this.id = id;
        Name = name;
        this.password = password;
        this.WorkerType = WorkerType;
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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkerType() {
        return WorkerType;
    }

    public void setWorkerType(int workerType_id) {
        if(workerType_id == 1){
            WorkerType ="Spa";
        }
        else if( workerType_id ==2){
            WorkerType ="Massage";
        }
    }

}

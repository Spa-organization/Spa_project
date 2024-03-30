package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class Employee {
    private String id ;
    private String name;
    private String password;
    private String workerType;
    private final List<Room> rooms = new ArrayList<>();

    private final List<Appointment> appointments =new ArrayList<>();

    public void setAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
    public Employee(String id, String name, String password,String workerType,Room room) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.workerType = workerType;
        this.rooms.add(room);
    }
    public Employee(String id, String name, String password,String workerType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.workerType = workerType;
    }
    public Room getRoom(){
        return rooms.get(0);
    }
    public void addRoomToEmployee(Room room){
        this.rooms.add(room);
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

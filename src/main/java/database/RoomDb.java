package database;

import entity.Employee;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDb {
private RoomDb(){}
     public static List<Room> rooms= new ArrayList<>();
    public   static boolean addRoom(Employee employee, int id){
        boolean notDuplicate = true;
        for (Room room: rooms){
            if(id==room.getRoomNumber()){
                notDuplicate=false;
                break;
            }
        }
        if(notDuplicate)
            rooms.add(new Room(employee,id));
        return notDuplicate;
    }
    public  static Room getRoomById( int id){
        for (Room room: rooms){
            if(id==room.getRoomNumber()){
                return room;
            }
        }
        return null;
    }

}

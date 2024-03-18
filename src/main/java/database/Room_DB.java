package database;

import Entities.Employee;
import Entities.Room;

import java.util.ArrayList;
import java.util.List;

public class Room_DB {
    public static List<Room> rooms= new ArrayList<>();
    public   static boolean addRoom(Employee employee, int id){
        boolean not_duplicate = true;
        for (Room room: rooms){
            if(id==room.getRoomNumber()){
                not_duplicate=false;
                break;
            }
        }
        if(not_duplicate)
            rooms.add(new Room(employee,id));
        return not_duplicate;
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

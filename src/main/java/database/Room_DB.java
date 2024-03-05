package database;

import Entities.Employee;
import Entities.Room;

import java.util.ArrayList;
import java.util.List;

public class Room_DB {
    public static List<Room> rooms= new ArrayList<>();
    public   static boolean addRoom(Employee employee, int id){
        boolean flage = true;
        for (Room room: rooms){
            if(id==room.getRoomNumber()){
                flage=false;
                break;
            }
        }
        if(flage==true)
            rooms.add(new Room(employee,id));
        return flage;
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

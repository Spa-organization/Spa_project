package database;

import basic.LoggerUtility;
import entity.Employee;
import entity.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RoomDb {
private RoomDb(){}
    private static final Logger LOGGER = LoggerUtility.getLogger();

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
    public   static boolean checkValidateID(int id) {
        boolean flag = true;
        for (Room room : rooms) {
            if (id == room.getRoomNumber()) {
                flag = false;
                LOGGER.info("ROOM ID is already EXIST"+"\n");
                break;
            }
        }
        return flag;
    }
}

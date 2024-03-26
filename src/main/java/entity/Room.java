package entity;

public class Room {
    private  int roomNumber=0;
    private Employee employee = new Employee();

    public Room(int id ){ roomNumber =id;}
    public Room(Employee employee, int roomNumber) {
        this.employee = employee;
        this.roomNumber=roomNumber;
        employee.addRoomToEmployee(this);
    }

    public  int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

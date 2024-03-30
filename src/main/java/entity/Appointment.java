package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
     int appointmentId;
    private  Client client = new Client();
    private  Employee employee = new Employee();
    private Room room;
    private String date;
    private String time;
    private boolean booked = false;
}

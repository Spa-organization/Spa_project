package entity;

import io.cucumber.java.eo.Se;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Getter
     int appointmentId;
    @Getter
    private  Client client = new Client();
    @Getter
    private  Employee employee = new Employee();
    @Getter
    private Room room;
    @Getter
    @Setter
    private String date;
    @Getter
    @Setter
    private String time;
    @Getter
    @Setter
    private boolean booked = false;
}

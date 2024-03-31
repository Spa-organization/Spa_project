package entity;

import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    int appointmentId;
    private  Client client = new Client();
    private  Employee employee = new Employee();
    private Room room;
    @Setter
    private String date;
    @Setter
    private String time;
    @Setter
    private boolean booked = false;
}

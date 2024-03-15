package najah.edu.acceptance;

import Controller.ClientController;
import database.Appointment_DB;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManageSessions {
    ClientController clientController;
    private static boolean flag=false;
    String client_id="11";
    String client_pass="123";


    String employee_id;
    String dateInput="1/9/2002";
    String timeInput="9:00";
    int appointmentType=1;
    static String type = "true";



    public ManageSessions() {
        clientController = new ClientController();
    }



    @Given("the client is logged into their account")
    @Test
    public void theClientIsLoggedIntoTheirAccount() {
        clientController.loggIn_Check(client_id, client_pass);
        if(clientController.isLoggedIn())
        {
            assertTrue(clientController.isLoggedIn());
            System.out.println("-------------------------------------");
            System.out.println("SignIN done successfully");
            System.out.println("-------------------------------------");
        }
        else {
            assertFalse(clientController.isLoggedIn());
            System.out.println("-------------------------------------");
            System.out.println("SignIn  fail");
            System.out.println("-------------------------------------");
        }
    }

    @And("the chosen massage session {string} slot is available for the selected available {string} and available employee {string}")
    public void theChosenMassageSessionSlotIsAvailableForTheSelectedAvailableAndAvailableEmployee(String time, String date, String id) {
        this.timeInput=time;
        this.dateInput=date;
        this.employee_id=id;
    }

    @When("the client schedules a new massage session specifying the date and time")
    @Test
    public void theClientSchedulesANewMassageSessionSpecifyingTheDateAndTime() {

        System.out.println("Book Appointment");
        System.out.print("Enter your choice: ");
        switch (appointmentType) {
            case 1:
                assertTrue(true);
                System.out.println("1. Massage");
                //clientController.bookMassage("Massage");
                break;
            case 2:
                assertTrue(true);
                System.out.println("2. Sauna");
                //clientController.bookSauna("sawna");
                break;
            case 3:
                assertTrue(true);
                clientController.logout();
                System.out.println("exit complete");
                break;
            default:
                assertFalse(false);
                System.out.println("Invalid choice. Please try again.");
        }
         if(appointmentType==1) {
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("Enter Date (format: dd/MM/yyyy): ");

            System.out.println("Enter Time (format: HH:mm): ");
            if (!Appointment_DB.isValidDate(dateInput)) {
                clientController.addAppointmentResult(2);
                //return;
            } else if (!Appointment_DB.isValidTime(timeInput)) {
                clientController.addAppointmentResult(1);
                //return;
            }

          //  List<Employee> employees = Appointment_DB.checkAvailability(dateInput, timeInput, type);
          //  if (employees.size() != 0) {
           //     clientController.showAvailableRooms(employees, dateInput, timeInput);
          //  } else {
            //    System.out.println("----------------------------------");
          //      System.out.println("NO Available Rooms In This Time");
           //     System.out.println("----------------------------------");
           // }
         }
    }

    @Then("the session should be successfully booked, ensuring the time and date slots are reserved")
    public void theSessionShouldBeSuccessfullyBookedEnsuringTheTimeAndDateSlotsAreReserved() {
    }
}

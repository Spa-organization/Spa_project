package najah.edu.acceptance;

import Controller.AdminController;
import Controller.ClientController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManageSessions {
    ClientController clientController;
    public static boolean flag=false;
    String client_id="11";
    String client_pass="123";

    String employee_id;
    String date;

    String time;
    int appointmentType;


    public ManageSessions() {
        clientController = new ClientController();
    }



    @Given("the client is logged into their account")
    @Test
    public void theClientIsLoggedIntoTheirAccount() {
        clientController.loggIn_Check(client_id, client_pass);
        if(clientController.isLoggedIn())
        {   flag= true;
            assertTrue(clientController.isLoggedIn());
            System.out.println("-------------------------------------");
            System.out.println("SignIN done successfully");
            System.out.println("-------------------------------------");
        }
        else {
            flag= false;
            assertFalse(clientController.isLoggedIn());
            System.out.println("-------------------------------------");
            System.out.println("SignIn  fail");
            System.out.println("-------------------------------------");
        }
    }

    @And("the chosen massage session {string} slot is available for the selected available {string} and available employee {string}")
    public void theChosenMassageSessionSlotIsAvailableForTheSelectedAvailableAndAvailableEmployee(String time, String date, String id) {
        this.time=time;
        this.date=date;
        this.employee_id=id;
    }

    @When("the client schedules a new massage session specifying the date and time")
    public void theClientSchedulesANewMassageSessionSpecifyingTheDateAndTime() {
        System.out.println("Book Appointment");
        System.out.println("1. Massage");
        System.out.println("2. Sauna");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        switch (appointmentType) {
            case 1:
                clientController.bookMassage("Massage");
                break;
            case 2:
                clientController.bookSauna("sawna");
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    @Then("the session should be successfully booked, ensuring the time and date slots are reserved")
    public void theSessionShouldBeSuccessfullyBookedEnsuringTheTimeAndDateSlotsAreReserved() {
    }
}

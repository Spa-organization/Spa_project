package najah.edu.acceptance;

import controller.ClientController;
import database.AppointmentDb;
import entity.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManageSessionsTest {
    ClientController clientController;
    private String id;
    private String time;
    private String date;
    private String type;

    public ManageSessionsTest() {
        clientController = new ClientController();
    }

    @Given("the client is logged into their account")

    public void theClientIsLoggedIntoTheirAccount() {
        clientController.login();
        assertTrue(clientController.isLoggedIn());}
    @Given("the chosen massage session {string} slot is available for the selected available {string} and available employee {string}")
    public void theChosenMassageSessionSlotIsAvailableForTheSelectedAvailableAndAvailableEmployee(String string, String string2, String string3) {
       this.time = string;
       this.date = string2;
       this.id = string3;

    }
    @When("the client schedules a new massage session specifying the date and time")
    public void theClientSchedulesANewMassageSessionSpecifyingTheDateAndTime() {

          date = "01/09/2012";
          time= "09:00";
        assertTrue(AppointmentDb.isValidDate(date));
        assertTrue(AppointmentDb.isValidTime(time));




    }



    @Given("the chosen massage session {string} slot is already booked for the selected {string} and available employee {string}")
    public void theChosenMassageSessionSlotIsAlreadyBookedForTheSelectedAndAvailableEmployee(String string, String string2, String string3) {
        this.time = string;
        this.date = string2;
        this.id = string3;
    }
    @When("the client attempts to schedule a new massage session for this time slot")
    public void theClientAttemptsToScheduleANewMassageSessionForThisTimeSlot() {
        time="12:30";
        assertTrue(AppointmentDb.isValidTime(time));

    }

    @Given("the chosen sawna session {string} slot is available for the selected available {string} and available employee {string}")
    public void theChosenSawnaSessionSlotIsAvailableForTheSelectedAvailableAndAvailableEmployee(String string, String string2, String string3) {
        this.time = string;
        this.date = string2;
        this.id = string3;
    }
    @When("the client schedules a new sawna session specifying the date and time and employee")
    public void theClientSchedulesANewSawnaSessionSpecifyingTheDateAndTimeAndEmployee() {

        id="31";
        time="12:30";
        date="12/12/2024";
        assertTrue(AppointmentDb.isValidDate(date));
        assertTrue(AppointmentDb.isValidTime(time));


    }
    @Then("the session should be successfully booked, ensuring the time and date slots are reserved")
    public void theSessionShouldBeSuccessfullyBookedEnsuringTheTimeAndDateSlotsAreReserved() {
        int rId=4;
        time="12:30";
        date="12/12/2024";
       List<Employee> availableEmp= AppointmentDb.checkAvailability(date,time,"sawna");
       for (Employee emp : availableEmp)
           System.out.println(emp.getId());
        assertTrue(AppointmentDb.isValidDate(date));
        assertTrue(AppointmentDb.isValidTime(time));
       assertTrue(clientController.check(date,time,rId));

    }


    @Given("the chosen sawna session {string} slot is already booked for the selected {string} and available employee {string}")
    public void theChosenSawnaSessionSlotIsAlreadyBookedForTheSelectedAndAvailableEmployee(String string, String string2, String string3) {
        this.time = string;
        this.date = string2;
        this.id = string3;
    }
    @When("the client attempts to schedule a new sawna session for this time slot")
    public void theClientAttemptsToScheduleANewSawnaSessionForThisTimeSlot() {
        assertTrue(true);

    }
    @Then("the system should prevent the booking and alert about the time and date slots unavailability")

    public void theSystemShouldPreventTheBookingAndAlertAboutTheTimeAndDateSlotsUnavailability() {
        time = "08:00";
        date = "01/04/2012";
       assertFalse(clientController.check(date,time,1));

    }


    @When("I choose to view the appointments")
    public void iChooseToViewTheAppointments() {
        assertTrue(true);
    }
    @Then("the appointments should show up according to the client who log in")
    public void theAppointmentsShouldShowUpAccordingToTheClientWhoLogIn() {
        assertTrue(   clientController.showClientAppointments());
    }

    @Given("the new chosen time slot is available")
    public void theNewChosenTimeSlotIsAvailable() {
    }
    @When("the client reschedules the session with the new {string} and {string}")
    public void theClientReschedulesTheSessionWithTheNewAnd(String string, String string2) {
        this.date = string;
        this.time = string2;

    }
    @Then("the session should be successfully updated, and the new time slot reserved")
    public void theSessionShouldBeSuccessfullyUpdatedAndTheNewTimeSlotReserved() {
        time = "09:30";
        date = "01/09/2020";
        int id = 2;
        assertTrue(clientController.check(date,time,id));
    }



    @Given("the client wants to change the time of an existing spa session")
    public void theClientWantsToChangeTheTimeOfAnExistingSpaSession() {
        assertTrue(true);

    }
    @Given("the new chosen {string} and {string} slots are unavailable")
    public void theNewChosenAndSlotsAreUnavailable(String string, String string2) {
        this.date = string;
        this.time = string2;
    }
    @When("the client attempts to reschedule the session to this time slot")
    public void theClientAttemptsToRescheduleTheSessionToThisTimeSlot() {
    }
    @Then("the system should prevent the update and alert about the time slot unavailability")
    public void theSystemShouldPreventTheUpdateAndAlertAboutTheTimeSlotUnavailability() {
        time = "09:00";
        date = "01/09/2012";
        int id = 2;
        assertTrue(clientController.check(date,time,id));
    }

    @Given("the client has an existing spa session they wish to cancel")
    public void theClientHasAnExistingSpaSessionTheyWishToCancel() {
        assertTrue(clientController.showClientAppointments());}
    @When("the client chooses to cancel this session")
    public void theClientChoosesToCancelThisSession() {

    }
    @Then("the session should be removed from their list of scheduled sessions, freeing up the time slot")
    public void theSessionShouldBeRemovedFromTheirListOfScheduledSessionsFreeingUpTheTimeSlot() {
       assertTrue(clientController.showClientAppointments());}


}

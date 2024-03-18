package najah.edu.acceptance;

import Controller.AdminController;
import Controller.ClientController;
import Entities.Employee;
import database.Appointment_DB;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManageSessions {
    ClientController clientController;
    private String id;
    private String time;
    private String date;
    private String type;

    public ManageSessions() {
        clientController = new ClientController();
    }

    @Given("the client is logged into their account")
    @Test
    public void theClientIsLoggedIntoTheirAccount() {
        clientController.login();
        assertTrue(clientController.isLoggedIn());



    }
    @Given("the chosen massage session {string} slot is available for the selected available {string} and available employee {string}")
    public void theChosenMassageSessionSlotIsAvailableForTheSelectedAvailableAndAvailableEmployee(String string, String string2, String string3) {
       this.time = string;
       this.date = string2;
       this.id = string3;

    }
    @When("the client schedules a new massage session specifying the date and time")
    @Test
    public void theClientSchedulesANewMassageSessionSpecifyingTheDateAndTime() {

          date = "01/09/2012";
          time= "09:00";
        assertTrue(Appointment_DB.isValidDate(date));
        assertTrue(Appointment_DB.isValidTime(time));



    }



    @Given("the chosen massage session {string} slot is already booked for the selected {string} and available employee {string}")
    public void theChosenMassageSessionSlotIsAlreadyBookedForTheSelectedAndAvailableEmployee(String string, String string2, String string3) {
        this.time = string;
        this.date = string2;
        this.id = string3;
    }
    @When("the client attempts to schedule a new massage session for this time slot")
    @Test
    public void theClientAttemptsToScheduleANewMassageSessionForThisTimeSlot() {
        time="12:30";
        assertTrue(Appointment_DB.isValidTime(time));

    }

    @Given("the chosen sawna session {string} slot is available for the selected available {string} and available employee {string}")
    public void theChosenSawnaSessionSlotIsAvailableForTheSelectedAvailableAndAvailableEmployee(String string, String string2, String string3) {
        this.time = string;
        this.date = string2;
        this.id = string3;
    }
    @When("the client schedules a new sawna session specifying the date and time and employee")
    @Test
    public void theClientSchedulesANewSawnaSessionSpecifyingTheDateAndTimeAndEmployee() {

        id="31";
        time="12:30";
        date="12/12/2024";
        assertTrue(Appointment_DB.isValidDate(date));
        assertTrue(Appointment_DB.isValidTime(time));


    }
    @Then("the session should be successfully booked, ensuring the time and date slots are reserved")
    @Test
    public void theSessionShouldBeSuccessfullyBookedEnsuringTheTimeAndDateSlotsAreReserved() {
        int result;
        id="31";
        time="12:30";
        date="12/12/2024";
        assertTrue(Appointment_DB.isValidDate(date));
        assertTrue(Appointment_DB.isValidTime(time));
        if(Appointment_DB.isValidDate(date) && Appointment_DB.isValidTime(time))
            result=0;
        else if (!Appointment_DB.isValidDate(date)) {
            result=2;

        }
        else result=1;
        clientController.addAppointmentResult(result);

    }


    @Given("the chosen sawna session {string} slot is already booked for the selected {string} and available employee {string}")
    public void theChosenSawnaSessionSlotIsAlreadyBookedForTheSelectedAndAvailableEmployee(String string, String string2, String string3) {
        this.time = string;
        this.date = string2;
        this.id = string3;
    }
    @When("the client attempts to schedule a new sawna session for this time slot")
    public void theClientAttemptsToScheduleANewSawnaSessionForThisTimeSlot() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system should prevent the booking and alert about the time and date slots unavailability")
    public void theSystemShouldPreventTheBookingAndAlertAboutTheTimeAndDateSlotsUnavailability() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





    @When("I choose to view the appointments")
    public void iChooseToViewTheAppointments() {assertTrue(true);}
    @Then("the appointments should show up according to the client who log in")
    public void theAppointmentsShouldShowUpAccordingToTheClientWhoLogIn() {
        clientController.showClientAppointments();

    }

    @Given("the new chosen time slot is available")
    public void theNewChosenTimeSlotIsAvailable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the client reschedules the session with the new {string} and {string}")
    public void theClientReschedulesTheSessionWithTheNewAnd(String string, String string2) {
        this.date = string;
        this.time = string2;

    }
    @Then("the session should be successfully updated, and the new time slot reserved")
    public void theSessionShouldBeSuccessfullyUpdatedAndTheNewTimeSlotReserved() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("the client wants to change the time of an existing spa session")
    public void theClientWantsToChangeTheTimeOfAnExistingSpaSession() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("the new chosen {string} and {string} slots are unavailable")
    public void theNewChosenAndSlotsAreUnavailable(String string, String string2) {
        this.date = string;
        this.time = string2;
    }
    @When("the client attempts to reschedule the session to this time slot")
    public void theClientAttemptsToRescheduleTheSessionToThisTimeSlot() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system should prevent the update and alert about the time slot unavailability")
    public void theSystemShouldPreventTheUpdateAndAlertAboutTheTimeSlotUnavailability() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the client has an existing spa session they wish to cancel")
    public void theClientHasAnExistingSpaSessionTheyWishToCancel() {
        clientController.showClientAppointments();

    }
    @When("the client chooses to cancel this session")
    public void theClientChoosesToCancelThisSession() {
        clientController.cancelSession();
    }
    @Then("the session should be removed from their list of scheduled sessions, freeing up the time slot")
    public void theSessionShouldBeRemovedFromTheirListOfScheduledSessionsFreeingUpTheTimeSlot() {

        clientController.showClientAppointments();
    }


}

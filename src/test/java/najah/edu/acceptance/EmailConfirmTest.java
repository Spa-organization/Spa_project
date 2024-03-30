package najah.edu.acceptance;

import basic.EmailSender;
import database.AppointmentDb;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailConfirmTest {
    EmailSender email;
    private String text,subject;
     public EmailConfirmTest(){email=new EmailSender("qsay.3w@gmail.com");}

    @Given("The customer has completed the booking process")
    public void theCustomerHasCompletedTheBookingProcess() {assertTrue(AppointmentDb.appointments.get(0).isBooked());}
    @When("the booking is confirmed  subject {string} text  {string}")
    public void theBookingIsConfirmedSubjectText(String subject, String text) {
        this.text=text;this.subject=subject;}
    @Then("a confirmation email is sent to the customer's email address")
    public void aConfirmationEmailIsSentToTheCustomerSEmailAddress() {
         subject="testing";
         text="pending test";
        assertTrue(email.sendEmail(subject,text));
    }


    @When("the email sending is empty")
    public void theEmailSendingIsEmpty() {
         subject="";
         text="";
        assertFalse(email.sendEmail(subject,text));
    }

    @Then("the email will not send")
    public void theEmailWillNotSend() {
         assertFalse(email.sendEmail("",""));}
}


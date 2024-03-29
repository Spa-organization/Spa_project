package najah.edu.acceptance;

import basic.EmailSender;
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
    @Test
    public void theCustomerHasCompletedTheBookingProcess() {assertTrue(true);}
    @When("the booking is confirmed  subject {string} text  {string}")
    public void theBookingIsConfirmedSubjectText(String subject, String text) {
        this.text=text;this.subject=subject;}
    @Then("a confirmation email is sent to the customer's email address")
    @Test
    public void aConfirmationEmailIsSentToTheCustomerSEmailAddress() {
         subject="confirm email";
         text="hello";
        assertTrue(email.sendEmail(subject,text));
    }


    @When("the email sending is empty")
    @Test
    public void theEmailSendingIsEmpty() {
         assertTrue(true);
    }

    @Then("the email will not send")
    @Test
    public void theEmailWillNotSend() {
         assertFalse(email.sendEmail("",""));}
}


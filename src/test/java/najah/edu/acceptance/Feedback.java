package najah.edu.acceptance;

import database.Feedback_DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.LoginAsClient;

import static org.junit.Assert.assertTrue;

public class Feedback {
    LoginAsClient app;
    public Feedback()
    {
     app=new LoginAsClient();
     app.login();
    }
    @Given("I am logged in as a client")
    public void iAmLoggedInAsAClient() {
        assertTrue(app.isLoggedIn());

    }
    @When("I choose to submit feedback {string}")
    public void iChooseToSubmitFeedback(String string) {
        Feedback_DB.addFeedback(string);
    }

    @Then("my feedback should be submitted to the system")
    public void myFeedbackShouldBeSubmittedToTheSystem() {
        System.out.println("Thanks, Your feedback has been submitted successfully");

    }
}
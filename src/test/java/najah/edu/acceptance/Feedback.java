package najah.edu.acceptance;

import basic.LoggerUtility;
import controller.ClientController;
import database.FeedbackDB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class Feedback {
    private static final Logger LOGGER = LoggerUtility.getLogger();
    ClientController app;
    public Feedback()
    {
     app=new ClientController();
     app.login();
    }
    @Given("I am logged in as a client")
    public void iAmLoggedInAsAClient() {
        assertTrue(app.isLoggedIn());

    }
    @When("I choose to submit feedback {string}")
    public void iChooseToSubmitFeedback(String string) {
        FeedbackDB.addFeedback(string,11);
    }

    @Then("my feedback should be submitted to the system")
    public void myFeedbackShouldBeSubmittedToTheSystem() {
        LOGGER.info("Thanks, Your feedback has been submitted successfully");

    }
}
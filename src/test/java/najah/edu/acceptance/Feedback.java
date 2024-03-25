package najah.edu.acceptance;

import controller.ClientController;
import database.FeedbackDB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertTrue;

public class Feedback {
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
        int id = 11;
        FeedbackDB.addFeedback(string,11);
    }

    @Then("my feedback should be submitted to the system")
    public void myFeedbackShouldBeSubmittedToTheSystem() {
        System.out.println("Thanks, Your feedback has been submitted successfully");

    }
}
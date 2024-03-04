package najah.edu.acceptance;

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
    }
    @Given("I am logged in as a client")
    public void iAmLoggedInAsAClient() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I choose to submit feedback {string}")
    public void iChooseToSubmitFeedback(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("my feedback should be submitted to the system")
    public void myFeedbackShouldBeSubmittedToTheSystem() {

    }
}
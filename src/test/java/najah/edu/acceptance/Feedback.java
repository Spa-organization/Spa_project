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
    @Given("I am logged in as a customer")
    public void iAmLoggedInAsACustomer() {
        assertTrue(app.isLoggedIn());
    }

    @When("I choose to submit feedback")
    public void iChooseToSubmitFeedback() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter my feedback into the feedback form")
    public void iEnterMyFeedbackIntoTheFeedbackForm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("my feedback should be submitted to the system")
    public void myFeedbackShouldBeSubmittedToTheSystem() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
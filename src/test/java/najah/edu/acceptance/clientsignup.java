package najah.edu.acceptance;

import LogUp.LogUpAsClient;
import database.Client_DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class clientsignup {
    LogUpAsClient app;
    public clientsignup()
    {
        app=new LogUpAsClient();
    }
    String id="2222";
    String password="1234";

    @Given("the client does not have an account")
    @Test
    public void theClientDoesNotHaveAnAccount() {
     assertFalse(app.isLoggedUp());
    }
    @When("the client provides a valid ID {string}")
    public void theClientProvidesAValidID(String id) {
       this.id=id;
    }
    @When("a valid password {string}")
    public void aValidPassword(String pass) {
        this.password=pass;
    }
    @When("confirms the password {string}")
    public void confirmsThePassword(String pass2) {
        assertSame(this.password, pass2);
    }
    @Then("their account should be created and they should be logged in automatically")
    public void theirAccountShouldBeCreatedAndTheyShouldBeLoggedInAutomatically() {
       if((Client_DB.check_digit_validate(id))&&(Client_DB.check_validate_ID(id)))
       {
           Client_DB.addClient(id, password);
           app.logUp();
       }
        assertTrue(app.isLoggedUp());
    }
    @Given("the client provides an ID that is already associated with another account {string}")
    public void theClientProvidesAnIDThatIsAlreadyAssociatedWithAnotherAccount(String id) {
        this.id =id;
    }
    @When("the client attempts to sign up")
    @Test
    public void theClientAttemptsToSignUp() {
        if((Client_DB.check_digit_validate(id))&&(Client_DB.check_validate_ID(id)))
        {
            Client_DB.addClient(id, password);
            app.logUp();
        }
        assertFalse(app.isLoggedUp());
    }
    @Then("they should be shown an error message indicating the ID is already in use")
    @Test
    public void theyShouldBeShownAnErrorMessageIndicatingTheIDIsAlreadyInUse() {
        System.out.println("__________________________________________");
                      System.out.println("error exist id");
        System.out.print("__________________________________________");
    }

    @Given("the client provides an ID in an incorrect format {string}")
    public void theClientProvidesAnIDInAnIncorrectFormat(String id) {
        this.id=id;
    }
    @Then("they should be shown an error message indicating the ID format is invalid")
    public void theyShouldBeShownAnErrorMessageIndicatingTheIDFormatIsInvalid() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

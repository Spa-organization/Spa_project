package najah.edu.acceptance;

import Controller.ClientController;
import database.Client_DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class clientsignup {
    ClientController app;

    public clientsignup() {
        app = new ClientController();
    }

    String clientId ;
    String clientName ;
    String password ;

    @Given("the client does not have an account")
    @Test
    public void theClientDoesNotHaveAnAccount() {
        assertFalse(app.isLogged_up());
    }

    @When("the client provides a valid ID {string}")
    public void theClientProvidesAValidID(String id) {
        this.clientId = id;
    }

    @When("the client provides a valid name {string}")
    public void theClientProvidesAValidName(String name) {
        this.clientName = name;
    }

    @When("a valid password {string}")
    public void aValidPassword(String pass) {
        this.password = pass;
    }

    @Then("their account should be created and they should be logged in automatically")
    public void theirAccountShouldBeCreatedAndTheyShouldBeLoggedInAutomatically() {
            assertTrue(Client_DB.addClient(clientId, clientName, password));
    }

    @Given("the client provides an ID that is already associated with another account {string}")
    public void theClientProvidesAnIDThatIsAlreadyAssociatedWithAnotherAccount(String id) {
        this.clientId = id;
    }

    @When("the client attempts to sign up")
    public void theClientAttemptsToSignUp() {
        assertFalse(app.isLogged_up());
    }

    @Then("they should be shown an error message indicating the ID is already in use")
    public void theyShouldBeShownAnErrorMessageIndicatingTheIDIsAlreadyInUse() {
        assertFalse(Client_DB.addClient(clientId, clientName, password));}
}



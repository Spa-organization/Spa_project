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

    String clientId = "112";
    String clientName = "clint1";
    String password = "123";

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
    @Test
    public void theirAccountShouldBeCreatedAndTheyShouldBeLoggedInAutomatically() {
        if (Client_DB.addClient(clientId, clientName, password)) {
            app.logUp();
            assertTrue(app.isLogged_up());
            System.out.println("-------------------------------------");
            System.out.println("Signup done successfully");
            System.out.println("-------------------------------------");
        }
    }

    @Given("the client provides an ID that is already associated with another account {string}")
    public void theClientProvidesAnIDThatIsAlreadyAssociatedWithAnotherAccount(String id) {
        this.clientId = id;
    }

    @When("the client attempts to sign up")
    @Test
    public void theClientAttemptsToSignUp() {
        assertFalse(app.isLogged_up());
    }

    @Then("they should be shown an error message indicating the ID is already in use")
    @Test
    public void theyShouldBeShownAnErrorMessageIndicatingTheIDIsAlreadyInUse() {
        if (Client_DB.addClient(clientId, clientName, password)) {
            assertFalse(app.isLogged_up());
            System.out.println("----------------------------");
            System.out.println("This ID is Already Exists");
            System.out.println("----------------------------");
        }

    }
}



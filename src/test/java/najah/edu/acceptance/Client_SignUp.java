package najah.edu.acceptance;

import LogUp.LogUpAsClient;
import database.Client_DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class Client_SignUp {
    LogUpAsClient app;
    public Client_SignUp()
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
    @Test
    public void theirAccountShouldBeCreatedAndTheyShouldBeLoggedInAutomatically() {
        if ((Client_DB.check_digit_validate("id")) && (Client_DB.check_validate_ID(id))) {
            Client_DB.addClient("2222", "omg");
            app.logUp();
        }
        assertTrue(app.isLoggedUp());
    }
    @Given("the client provides an ID that is already associated with another account {string}")
    public void the_client_provides_an_id_that_is_already_associated_with_another_account(String id) {
        this.id=id;
    }
    @When("the client attempts to sign up")

    public void the_client_attempts_to_sign_up() {
        assertFalse((Client_DB.check_validate_ID(this.id))&&(Client_DB.check_digit_validate(this.id)));
    }
    @Then("they should be shown an error message indicating the ID is already in use")

    public void they_should_be_shown_an_error_message_indicating_the_id_is_already_in_use() {
        System.out.println("ssssssss");
    }

}

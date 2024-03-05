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
    String password="omg";

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
       if((Client_DB.check_digit_validate(id))&&(Client_DB.check_validate_ID(id))&&Client_DB.check_idFormat_validate(id))
       {
           Client_DB.addClient(id, password);
           app.logUp();
           assertTrue(app.isLoggedUp());
           System.out.println("_______________________________________");
           System.out.print("\t\t\t");
           System.out.println("SignUp success");
           System.out.print("________________________________________");

       }
        assertFalse(app.isLoggedUp());
        System.out.println("_______________________________________");
        System.out.print("\t\t\t");
        System.out.println("SignUp fail");
        System.out.print("________________________________________");
    }
    @Given("the client provides an ID that is already associated with another account {string}")
    public void theClientProvidesAnIDThatIsAlreadyAssociatedWithAnotherAccount(String id) {
        this.id =id;
    }
    @When("the client attempts to sign up")
    @Test
    public void theClientAttemptsToSignUp() {
        if((Client_DB.check_digit_validate(id))&&(Client_DB.check_validate_ID(id))&&Client_DB.check_idFormat_validate(id))
        {
            Client_DB.addClient(id, password);
            app.logUp();
            assertTrue(app.isLoggedUp());
            System.out.println("_______________________________________");
            System.out.print("\t\t\t");
            System.out.println("SignUp Success");
            System.out.print("________________________________________");
        }
        assertFalse(app.isLoggedUp());
        System.out.println("_______________________________________");
        System.out.print("\t\t\t");
        System.out.println("SignUp IDIsAlreadyAssociatedWithAnotherAccount");
        System.out.print("________________________________________");
    }
    @Then("they should be shown an error message indicating the ID is already in use")
    @Test
    public void theyShouldBeShownAnErrorMessageIndicatingTheIDIsAlreadyInUse() {
        System.out.println("_______________________________________");
        System.out.print("\t\t \t");
                      System.out.println("error exist id");
        System.out.println("________________________________________");
    }

    @Given("the client provides an ID in an incorrect format {string}")
    public void theClientProvidesAnIDInAnIncorrectFormat(String id) {
        this.id=id;
    }
    @Then("they should be shown an error message indicating the ID format is invalid")
    @Test
    public void theyShouldBeShownAnErrorMessageIndicatingTheIDFormatIsInvalid() {
        if((Client_DB.check_idFormat_validate(id)))
        {
            Client_DB.addClient(id, password);
            app.logUp();
            assertTrue(app.isLoggedUp());
            System.out.println("_______________________________________");
            System.out.print("\t\t\t");
            System.out.println("id format is acceptable");
            System.out.print("________________________________________");
        }
        else {
            assertFalse(app.isLoggedUp());
            System.out.println("_______________________________________");
            System.out.print("\t\t\t");
            System.out.println("error foramt  id not acceptable");
            System.out.print("________________________________________");
        }
    }
    @Given("the client provides a weak password {string}")
    public void theClientProvidesAWeakPassword(String pass) {
       this.password=pass;
    }
    @Then("they should be shown an error message indicating that the password is weak")
    @Test
    public void theyShouldBeShownAnErrorMessageIndicatingThatThePasswordIsWeak() {
       if(Client_DB.checkPassword_Strong(password))
       {
           Client_DB.addClient(id, password);
           app.logUp();
           assertTrue(app.isLoggedUp());
           System.out.println("_______________________________________");
           System.out.print("\t\t\t");
           System.out.println("Strong password");
           System.out.print("________________________________________");
       }
       else {
           assertFalse(app.isLoggedUp());
           System.out.println("_______________________________________");
           System.out.print("\t\t\t");
           System.out.println("ThePasswordIsWeak");
           System.out.print("________________________________________");
       }
    }

}

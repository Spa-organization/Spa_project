package najah.edu.acceptance;

import Controller.ClientController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientLogoutFeatureSteps {


    ClientController app;
    public ClientLogoutFeatureSteps()
    {
        app=new ClientController();
        app.login();
    }
    @Given("the client chose to sign out")
    @Test
    public void theClientChoseToSignOut() {
        assertTrue(app.isLoggedIn());
    }
    @Then("the system signs the client out")
    @Test
    public void theSystemSignsTheClientOut() {
        app.logout();
        assertFalse(app.isLoggedIn());
        System.out.println("___________________________________");
        System.out.print("\t\t");
        System.out.println("logout");
        System.out.println("___________________________________");

    }



}

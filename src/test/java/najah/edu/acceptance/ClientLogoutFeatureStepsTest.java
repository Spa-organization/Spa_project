package najah.edu.acceptance;

import controller.ClientController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientLogoutFeatureStepsTest {


    ClientController app;
    public ClientLogoutFeatureStepsTest()
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
    public void theSystemSignsTheClientOut() {
        app.logout();
        assertFalse(app.isLoggedIn());}



}

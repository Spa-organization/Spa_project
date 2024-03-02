package najah.edu.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsClient;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientLogoutFeatureSteps {

    String pass;
    String id;
    LoginAsClient app;
    public ClientLogoutFeatureSteps()
    {
        app=new LoginAsClient();
        app.login();
    }
    @Given("the client chose to sign out")
    public void theClientChoseToSignOut() {
        assertTrue(app.isLoggedIn());
    }
    @Then("the system signs the client out")
    public void theSystemSignsTheClientOut() {
        app.logout();
        assertFalse(app.isLoggedIn());
    }



}

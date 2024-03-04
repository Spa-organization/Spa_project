package najah.edu.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsClient;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceProviderLogoutFeatureSteps {
    String pass;
    String id;
    LoginAsClient app;
    public ServiceProviderLogoutFeatureSteps()
    {
        app=new LoginAsClient();
        app.login();
    }

    @Given("the service provider chose to sign out")
    public void theServiceProviderChoseToSignOut() {
        assertTrue(app.isLoggedIn());
    }
    @Then("the system signs the service provider out")
    public void theSystemSignsTheServiceProviderOut() {
       app.logout();
        assertFalse(app.isLoggedIn());
        System.out.println("___________________________________");
        System.out.print("\t\t");
        System.out.println("logout");
        System.out.println("___________________________________");
    }




}

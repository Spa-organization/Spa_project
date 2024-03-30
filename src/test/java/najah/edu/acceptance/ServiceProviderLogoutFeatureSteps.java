package najah.edu.acceptance;

import controller.EmployeeController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceProviderLogoutFeatureSteps {
    EmployeeController app;
    public ServiceProviderLogoutFeatureSteps()
    {
        app=new EmployeeController();
        app.login();
    }
//
    @Given("the service provider chose to sign out")
    public void theServiceProviderChoseToSignOut() {
        assertTrue(app.isLoggedIn());
    }
    @Then("the system signs the service provider out")
    public void theSystemSignsTheServiceProviderOut() {
       app.logout();
        assertFalse(app.isLoggedIn());
    }




}

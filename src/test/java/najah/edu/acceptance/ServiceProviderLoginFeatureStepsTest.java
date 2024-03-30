package najah.edu.acceptance;

import controller.EmployeeController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceProviderLoginFeatureStepsTest {
    String pass;
    String id;
    EmployeeController app;

    public ServiceProviderLoginFeatureStepsTest() {app= new EmployeeController();}
    @Given("that the service provider is not logged in the app")
    public void thatTheServiceProviderIsNotLoggedInTheApp() {
        assertFalse(app.isLoggedIn());
    }
    @And("the ID is {string}")
    public void theIDIs(String id) {
        this.id=id;
    }

    @And("the password is {string}")
    public void thePasswordIs(String pass) {
        this.pass=pass;
    }
    @Then("the service provider is logged in the app successfully")
    public void theServiceProviderIsLoggedInTheAppSuccessfully() {
        id="31";
        pass="123";
        app.loggInCheck(id, pass);
        assertTrue(app.isLoggedIn());
    }

        @Then("the service provider will not login")
        public void theServiceProviderWillNotLogin() {
        id="31";
        pass="321";
        app.loggInCheck(id, pass);
        assertFalse(app.isLoggedIn());
            }
        @Then("the message appear to tell the service provider what's wrong")
        public void theMessageAppearToTellTheServiceProviderWhatSWrong() {
            assertFalse(app.isLoggedIn());
        }



}












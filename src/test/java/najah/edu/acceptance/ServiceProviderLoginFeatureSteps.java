package najah.edu.acceptance;

import Controller.EmployeeController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceProviderLoginFeatureSteps {
    String pass;
    String id;
    EmployeeController app;

    public ServiceProviderLoginFeatureSteps()
    {
        app= new EmployeeController();

    }
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
        app.loggIn_Check(id,pass);
        assertTrue(app.isLoggedIn());
        System.out.println("___________________________________");
        System.out.print("\t\t\t");
        System.out.println("ServiceProvider login successfully");
        System.out.print("_____________________________________");
    }

        @Then("the service provider will not login")
        public void theServiceProviderWillNotLogin() {
            if(!(app.loggIn_IDCheck(id)||app.loggIn_PassCheck(pass)))
            {
                assertFalse(app.isLoggedIn());
            }
            if(id.isEmpty() || pass.isEmpty()) {
                assertFalse(app.isLoggedIn());
            }
        }
        @Then("the message appear to tell the service provider what's wrong")
        public void theMessageAppearToTellTheServiceProviderWhatSWrong() {
            if(!(app.loggIn_IDCheck(id)||app.loggIn_PassCheck(pass)))
            {
                assertFalse(app.isLoggedIn());
                System.out.println("___________________________________");
                System.out.print("\t\t");
                System.out.println("wrong password or id try again");
                System.out.println("___________________________________");
            }
        }



}












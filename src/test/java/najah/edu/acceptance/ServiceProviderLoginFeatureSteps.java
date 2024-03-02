package najah.edu.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsServiceProvider;

public class ServiceProviderLoginFeatureSteps {
    String pass;
    String id;
    LoginAsServiceProvider app;

    public ServiceProviderLoginFeatureSteps()
    {
        app= new LoginAsServiceProvider();

    }
    @Given("that the service provider is not logged in the app")
    public void thatTheServiceProviderIsNotLoggedInTheApp() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the service provider is logged in the app successfully")
    public void theServiceProviderIsLoggedInTheAppSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();}

        @Then("the service provider will not login")
        public void theServiceProviderWillNotLogin() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @Then("the message appear to tell the service provider what's wrong")
        public void theMessageAppearToTellTheServiceProviderWhatSWrong() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }



    }












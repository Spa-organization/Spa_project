package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Controller.ClientController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


public class ClientLoginFeatureSteps {
 String pass="1423";
 String id="11";
	ClientController app;
	public ClientLoginFeatureSteps()
	{
	app=new ClientController();
	}

	@Given("that the client is not logged in the app")
	@Test
	public void thatTheClientIsNotLoggedInTheApp() 
	{
        assertFalse(app.isLoggedIn());
	}
	@Given("the client ID is {string}")
	public void theIDIs(String id) {this.id=id;}
	@Given("the client password is {string}")
	public void thePasswordIs(String password) {
	this.pass=password;
	}
	
	@Then("the client is logged in the app successfully")
	public void theClientIsLoggedInTheAppSuccessfully() {
		app.loggIn_Check(id,pass);
		assertTrue(app.isLoggedIn());
	}

	@Then("the client will not login")

	public void theClientWillNotLogin() {
		app.loggIn_Check(id,pass);
		app.logout();
		assertFalse(app.isLoggedIn());
	}

	@And("the message appear to tell the client what's wrong")
	public void theMessageAppearToTellTheClientWhatSWrong() {assertFalse(app.isLoggedIn());}
}

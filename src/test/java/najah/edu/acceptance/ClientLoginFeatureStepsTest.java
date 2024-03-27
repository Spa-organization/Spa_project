package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import controller.ClientController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


public class ClientLoginFeatureStepsTest {
 String pass;
 String id;
	ClientController app;

	public ClientLoginFeatureStepsTest()
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
	@Test
	public void theClientIsLoggedInTheAppSuccessfully() {
	id="11";
	pass="123";
	app.loggInCheck(id,pass);
	assertTrue(app.isLoggedIn());
	}

	@Then("the client will not login")
@Test
	public void theClientWillNotLogin() {
		id="11";
		pass="1223";
		app.loggInCheck(id,pass);
		assertFalse(app.isLoggedIn());
	}

	@And("the message appear to tell the client what's wrong")
	@Test
	public void theMessageAppearToTellTheClientWhatSWrong() {assertFalse(app.isLoggedIn());}
}

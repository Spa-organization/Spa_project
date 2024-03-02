package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsClient;

public class ClientLoginFeatureSteps {
 String pass="123";
 String idd="1";
	LoginAsClient app;
	public ClientLoginFeatureSteps()
	{
	app=new LoginAsClient();
	}

	@Given("that the client is not logged in the app")
	public void thatTheClientIsNotLoggedInTheApp() 
	{
        assertFalse(app.isLoggedIn());
	}
	@Given("the ID is {string}")
	
	public void theIDIs(String id) {
	this.idd=id;

	}
	@Given("the password is {string}")
	
	public void thePasswordIs(String password) {
	this.pass=password;
	}
	
	@Then("the client is logged in the app successfully")
	public void theClientIsLoggedInTheAppSuccessfully() {
	app.loggIn_Check(idd, pass);
    assertTrue(app.isLoggedIn());
	  
	}
	@Then("the client will not login")
	public void theClientWillNotLogin() {
	app.loggIn_Check(idd, pass);
    assertFalse(app.isLoggedIn());
	}
	@Then("the message appear to tell the client what's wrong")
	public void theMessageAppearToTellTheClientWhatSWrong() {
	   
	}





	
	
	
	
	
	
	
}

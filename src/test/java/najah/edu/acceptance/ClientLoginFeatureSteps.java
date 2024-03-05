package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Controller.ClientController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ClientLoginFeatureSteps {
 String pass;
 String id;
	ClientController app;
	public ClientLoginFeatureSteps()
	{
	app=new ClientController();
	}

	@Given("that the client is not logged in the app")
	public void thatTheClientIsNotLoggedInTheApp() 
	{
        assertFalse(app.isLoggedIn());
	}
	@Given("the client ID is {string}")
	
	public void theIDIs(String id) {
	this.id=id;

	}
	@Given("the client password is {string}")
	
	public void thePasswordIs(String password) {
	this.pass=password;
	}
	
	@Then("the client is logged in the app successfully")
	public void theClientIsLoggedInTheAppSuccessfully() {
		app.loggIn_Check(id,pass);
		assertTrue(app.isLoggedIn());
		System.out.println("___________________________________");
		System.out.print("\t\t\t");
		System.out.println("Client login successfully");
		System.out.print("_____________________________________");

	  
	}
	@Then("the client will not login")
	public void theClientWillNotLogin() {
		if(!(app.loggIn_IDCheck(id)||app.loggIn_PassCheck(pass)))
		{
			assertFalse(app.isLoggedIn());
		}
		if(id.isEmpty() || pass.isEmpty()) {
			assertFalse(app.isLoggedIn());
		}
	}
	@Then("the message appear to tell the client what's wrong")
	public void theMessageAppearToTellTheClientWhatSWrong() {
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

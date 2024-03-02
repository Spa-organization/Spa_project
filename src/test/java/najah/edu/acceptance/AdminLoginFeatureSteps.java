package najah.edu.acceptance;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsAdmin;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminLoginFeatureSteps {

	String pass="123";
	String id="561";
	LoginAsAdmin app;
	public AdminLoginFeatureSteps()
	{
		app=new LoginAsAdmin();
	}

	@Given("that the admin is not logged in the app")
	public void thatTheAdminIsNotLoggedInTheApp() {
	assertFalse(app.isLoggedIn());
	}
	@Given("the admin ID is  {string}")

	public void theIDIs(String id) {
		this.id=id;
	}
	@Given("the admin password is  {string}")
	public void thePasswordIs(String password) {
		this.pass=password;
	}
	@Then("the admin is logged in the app successfully")

	public void theAdminIsLoggedInTheAppSuccessfully() {
		app.loggIn_Check(id,pass);
		assertTrue(app.isLoggedIn());
	}
	@Then("the admin will not login")
	public void theAdminWillNotLogin() {
		app.loggIn_Check(id,pass);
		assertFalse(app.isLoggedIn());
	}
	@Then("the message appear to tell the admin what's wrong")
	public void theMessageAppearToTellTheAdminWhatSWrong() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}

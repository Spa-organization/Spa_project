package najah.edu.acceptance;


import Controller.AdminController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminLoginFeatureSteps {

	String pass="abdullah";
	String id="12345";
	AdminController app;
	public AdminLoginFeatureSteps()
	{
		app=new AdminController();
	}

	@Given("that the admin is not logged in the app")
	@Test
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
	@Test
	public void theAdminIsLoggedInTheAppSuccessfully() {
		if(app.loggIn_PassCheck(pass)&&app.loggIn_IDCheck(id)) {
			app.loggIn_Check(id, pass);
			assertTrue(app.isLoggedIn());
			System.out.println("___________________________________");
			System.out.print("\t\t\t");
			System.out.println("Admin login successfully");
			System.out.print("_____________________________________");
		}
		else {assertFalse(app.isLoggedIn());}
	}
	@Then("the admin will not login")
	@Test
	public void theAdminWillNotLogin() {
		if(!(app.loggIn_IDCheck(id)||app.loggIn_PassCheck(pass))||(id.isEmpty() || pass.isEmpty()))
            assertFalse(app.isLoggedIn());
	}
	@Then("the message appear to tell the admin what's wrong")
	@Test
	public void theMessageAppearToTellTheAdminWhatSWrong() {
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

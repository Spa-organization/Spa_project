package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Controller.AdminController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


public class AdminLogoutFeatureSteps {

	AdminController app;
	public AdminLogoutFeatureSteps()
	{
		app=new AdminController ();
		app.login();
	}
@Given("the admin chose to sign out")
@Test
public void theAdminChoseToSignOut() {
   assertTrue(app.isLoggedIn());
}
@Then("the system signs the admin out")
@Test
public void theSystemSignsTheAdminOut() {
app.logout();
assertFalse(app.isLoggedIn());
}
}



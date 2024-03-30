package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import controller.AdminController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;


public class AdminLogoutFeatureStepsTest {

	AdminController app;
	public AdminLogoutFeatureStepsTest()
	{
		app= new AdminController();
		app.login();
	}
@Given("the admin chose to sign out")
public void theAdminChoseToSignOut() {
   assertTrue(app.isLoggedIn());
}
@Then("the system signs the admin out")
public void theSystemSignsTheAdminOut() {
app.logout();
assertFalse(app.isLoggedIn());
}
}



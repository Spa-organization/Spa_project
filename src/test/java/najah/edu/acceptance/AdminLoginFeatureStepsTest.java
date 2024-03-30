package najah.edu.acceptance;

import controller.AdminController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminLoginFeatureStepsTest {
	String pass;
	String id;
	AdminController app;
	public AdminLoginFeatureStepsTest()
	{app= new AdminController ();
	}

	@Given("that the admin is not logged in the app")

	public void thatTheAdminIsNotLoggedInTheApp() {
	assertFalse(app.isLoggedIn());
	}
	@Given("the admin ID is  {string}")
	public void theIDIs(String id) {this.id=id;}
	@Given("the admin password is  {string}")
	public void thePasswordIs(String password) {this.pass=password;}
	@Then("the admin is logged in the app successfully")
	public void theAdminIsLoggedInTheAppSuccessfully() {
		id="21";
		pass="123";
			app.loginCheck(id, pass);
			assertTrue(app.isLoggedIn());}
	@Then("the admin will not login")
	public void theAdminWillNotLogin() {
		id="21";
		pass="1235";
		 app.loginCheck(id, pass);
            assertFalse(app.isLoggedIn());
	}
	@Then("the message appear to tell the admin what's wrong")
	public void theMessageAppearToTellTheAdminWhatSWrong() {assertFalse(app.isLoggedIn());}

}

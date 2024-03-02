package najah.edu.acceptance;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsAdmin;
 

public class AdminLoginFeatureSteps {
 String pass;
 String id;
LoginAsAdmin app;

public AdminLoginFeatureSteps()
{
app=new LoginAsAdmin();
	
}
	@Given("that the admin is not logged in the app")
	public void thatTheAdminIsNotLoggedInTheApp() {
        assertFalse(app.isLoggedIn());
	}
	@Given("the ID is {string}")
	public void theIDIs(String id) {
	this.id=id;

	}
	@Given("the password is {string}")
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
        app.errorInLogin();
  
	}













}

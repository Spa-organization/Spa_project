package najah.edu.acceptance;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import database.Admin_DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsAdmin;
 

public class AdminLoginFeatureSteps {
static String pass="123";
static int id=1;
LoginAsAdmin app;
Admin_DB adminDB;
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

	}
	@Given("the password is {string}")
	public void thePasswordIs(String password) {
		AdminLoginFeatureSteps.pass=password;
	}
	@Then("the admin is logged in the app successfully")
	public void theAdminIsLoggedInTheAppSuccessfully() {
		
	app.loggIn_Check(id, pass);
    assertTrue(app.isLoggedIn());
	}
	
	@Then("the admin will not login")
	public void theAdminWillNotLogin() {
		
		app.loggIn_Check(id, pass);
	    assertFalse(app.isLoggedIn());	
	}
	@Then("the message appear to tell the admin what's wrong")
	
	public void theMessageAppearToTellTheAdminWhatSWrong() {
        app.errorInLogin();
  
	}













}

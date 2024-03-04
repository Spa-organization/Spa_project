package najah.edu.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import login.LoginAsAdmin;

public class AdminLogoutFeatureSteps {
	
	LoginAsAdmin app;
	public AdminLogoutFeatureSteps()
	{
		app=new LoginAsAdmin ();
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
	System.out.println("___________________________________");
	System.out.print("\t\t");
	System.out.println("logout");
	System.out.println("___________________________________");
    
}

}



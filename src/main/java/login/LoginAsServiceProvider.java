package login;

import Entities.Client;
import Entities.ServiceProvider;
import database.Client_DB;
import database.ServiceProvider_DB;

public class LoginAsServiceProvider {
	 private boolean isLoggedIn;


	    public LoginAsServiceProvider() {
	        this.isLoggedIn = false;

	    }

	    public boolean isLoggedIn() {

	        return isLoggedIn;
	    }
	    public void logout() {

	        isLoggedIn=false;
	    }
	    public void login() {

	        isLoggedIn = true;
	    }



	public void loggIn_Check(String id, String password)
	{
		for( ServiceProvider service_provider: ServiceProvider_DB.getServiceProviders() )
		{
			if( id.equals(service_provider.getId()) && password.equals(service_provider.getPassword()) )
				login();
		}
	}
	    
	    public void errorInLogin() {}
}

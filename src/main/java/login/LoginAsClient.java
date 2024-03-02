package login;

import Entities.Client;
import database.Client_DB;

public class LoginAsClient {

	 private boolean isLoggedIn;


	    public LoginAsClient() {
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
		for( Client client: Client_DB.getClients() )
		{
			if( id.equals(client.getId()) && password.equals(client.getPassword()) )
				login();
		}





	}
	    
	    public void errorInLogin() {}
	
	
	
	
}

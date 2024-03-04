package login;

import Entities.Admin;
import Entities.Client;
import database.Admin_DB;
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



	public void loggIn_Check(String id, String password) {
		for (Client client : Client_DB.getClients()) {
			if (id.equals(client.getId()) && password.equals(client.getPassword()))
				login();
		}
	}

		public boolean loggIn_IDCheck(String id)
		{

			for( Client client:Client_DB.getClients() )
			{
				if( id.equals(client.getId())  ) {
					return true ;
				}
			}
			return false;
		}
		public boolean loggIn_PassCheck(String pass)
		{
			for( Client client:Client_DB.getClients() )
			{
				if( pass.equals(client.getPassword())  ) {
					return true ;
				}
			}
			return false;
		}




	    
	  //  public void errorInLogin() {}
	
	
	
	
}

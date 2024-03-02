package login;

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
	    
	    
	    
	    public void loggIn_Check(int id, String password) 
	    {

	    	//if((serviceProviderDB.get_Employee_id()==id)&&(password.equals(serviceProviderDB.get_Pass())))
	    	{
	    	login();	
	    	}	
	    	
	        
	    }
	    
	    public void errorInLogin() {}

	
	
}

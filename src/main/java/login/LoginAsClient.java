package login;

import database.Employee;

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
	    
	    
	    
	    public void loggIn_Check(String idd, String password) 
	    {
	    	Employee employee=new Employee();
	    	if(idd=="1"&&password=="123")
	    	{
	    	login();	
	    	}	
	    	
	        
	    }
	    
	    public void errorInLogin() {}
	
	
	
	
}

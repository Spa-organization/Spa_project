package login;

import database.Employee;

public class LoginAsEmployee {
	 private boolean isLoggedIn;


	    public LoginAsEmployee() {
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
	    	Employee employee=new Employee();
	    	if((employee.get_Employee_id()==id)&&(password.equals(employee.get_Pass())))
	    	{
	    	login();	
	    	}	
	    	
	        
	    }
	    
	    public void errorInLogin() {}

	
	
}

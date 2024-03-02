package login;

public class LoginAsAdmin {
    private boolean isLoggedIn;


    public LoginAsAdmin() {
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
    	if((1==id)&&(password.equals("123")))
    	{
    	login();	
    	}	
    	
        
    }
    
    public void errorInLogin() {}

}

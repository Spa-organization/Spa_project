package login;

import Entities.Admin;
import database.Admin_DB;

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

    public void loggIn_Check(String id, String password)
    {
        for( Admin admin:Admin_DB.getAdmins() )
        {
         if( id.equals(admin.getId()) && password.equals(admin.getPassword()) ) {
             login();
         }
        }





    }
    
    public void errorInLogin()
    {

    }

}

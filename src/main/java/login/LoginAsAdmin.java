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
    public boolean loggIn_IDCheck(String id)
    {
        for( Admin admin:Admin_DB.getAdmins() )
        {
            if( id.equals(admin.getId())  ) {
               return true ;
            }
        }
        return false;
    }
    public boolean loggIn_PassCheck(String pass)
    {
        for( Admin admin:Admin_DB.getAdmins() )
        {
            if( pass.equals(admin.getPassword())  ) {
                return true ;
            }
        }
        return false;
    }


   // public void errorInLogin()
  //  {

  //  }

}

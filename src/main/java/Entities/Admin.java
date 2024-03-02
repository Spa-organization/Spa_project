package Entities;

public class Admin {
    private String id ;
    private String password;




    public Admin (String id , String password ) {
        this.password = password;
        this.id = id;


    }

    public String getId() {

        return id;

    }


    public String getPassword() {
        return password;

    }

}

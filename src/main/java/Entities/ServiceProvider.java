package Entities;

public class ServiceProvider {
    private String id ;
    private String password;


    public ServiceProvider (String id , String password ) {
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
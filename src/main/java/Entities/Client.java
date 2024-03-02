package Entities;

public class Client {
    private String id ;
    private String password;



    public Client (String id , String password ) {
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

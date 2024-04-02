package entity;


public class Client {
    private String email;
    private String id ;
    private String name;
    private String password;

    public Client(){}
    public Client(String id, String name, String password,String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email=email;
    }

    public String getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }




}

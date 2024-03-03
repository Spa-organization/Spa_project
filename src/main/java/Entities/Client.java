package Entities;

import database.Client_DB;

public class Client {
    private String id;
    private String password;


    public Client(String id, String password) {
        this.password = password;
        this.id = id;

    }

    public void setID(String idd) {
        this.id = idd;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getId() {

        return id;

    }

    public String getPassword() {
        return password;
    }

}
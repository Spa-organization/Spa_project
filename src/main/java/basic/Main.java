package basic;

import controller.Starter;

import javax.mail.MessagingException;
//
public class Main {
    public static void main(String[] args) throws MessagingException {
        Starter starter= new Starter();
        starter.homePage();
    }
}

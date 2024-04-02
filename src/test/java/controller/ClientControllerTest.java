package controller;

import controller.ClientController;
import database.EmployeeDB;
import entity.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ClientControllerTest {

    ClientController clientController;
    Scanner mockScanner;
    @Before
    public void setup()
    {
        clientController = new ClientController();
        mockScanner = Mockito.spy(clientController.scanner);
        clientController.scanner = mockScanner;
        clientController.client = new Client("11","clint1","123","qsay.3w@gmail.com");
    }

    @Test
    public void homepage_shoowapp() {
        Mockito.doReturn(2,6,4 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        clientController.starter.scanner = mockScanner;
        clientController.clientHomePage();
        assertTrue(clientController.showClientAppointments());
    }
    @Test
    public void homepage_cancel() {
        Mockito.doReturn(4,1,6,4 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        clientController.starter.scanner = mockScanner;
        clientController.clientHomePage();
        assertTrue(clientController.cancelSession());
    }
    @Test
    public void homepage_cancel_session() {
        Mockito.doReturn(4,2,6,4 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        clientController.starter.scanner = mockScanner;
        clientController.clientHomePage();
        assertTrue(clientController.cancelSession());
    }

    @Test
    public void homepage_show() {
        Mockito.doReturn(1 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();

        assertTrue(clientController.showAvailableRooms(EmployeeDB.getServiceProviders(),"12/12/2024","12:40"));
    }

    @Test
    public void homepage_feedback() {
        Mockito.doReturn(5,11,6,4 ).when(mockScanner).nextInt();
        Mockito.doReturn("","adadad" ).when(mockScanner).nextLine();
        clientController.starter.scanner = mockScanner;
        clientController.clientHomePage();
    }



    @Test
    public void testBooking() {

        Mockito.doReturn("", "10/10/2022", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();

        assertTrue(clientController.book("Sawna"));

    }



    @Test
    public void test() {
        assertTrue(true);
        Mockito.doReturn( "", "10/10/2026", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();
        assertTrue(clientController.book("Massage"));

        Mockito.doReturn("", "10/10/2022", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();
         assertTrue(clientController.updateSession());
    }
    @Test
    public void testing(){
        Mockito.doReturn( 1).when(mockScanner).nextInt();
        Mockito.doReturn( "10/10/2022", "10:10").when(mockScanner).nextLine();
        assertFalse(clientController.updateSession());
    }

    @Test
    public void loginPage() {
        Mockito.doReturn("11", "123" ).when(mockScanner).nextLine();
        Mockito.doReturn(6,4,100).when(mockScanner).nextInt();
        clientController.starter.scanner = mockScanner;
        clientController.loginPage();
    }
    @Test
    public void cliientsingup() {
        Mockito.doReturn("100", "Abdullah","1123","abdullah@gmail.com" ).when(mockScanner).nextLine();
        //Mockito.doReturn(6,4,100).when(mockScanner).nextInt();
        clientController.starter.scanner = mockScanner;
        clientController.clientSignUp();
    }


}
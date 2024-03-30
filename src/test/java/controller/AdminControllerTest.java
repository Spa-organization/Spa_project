package controller;

import entity.Admin;
import entity.Client;
import entity.Employee;
import entity.Room;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AdminControllerTest {
    AdminController adminController;
    Scanner mockScanner;

    @Before
    public void setup() {
        adminController = new AdminController();
        mockScanner = Mockito.spy( new Scanner(System.in));
        adminController.scanner = mockScanner;
        adminController.admin = new Admin("21", "admin1", "123");
    }


    @Test
    public void adminHomePageaddsawna() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePage1addsawnawrong() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("31" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePageaddmassage() {
        Mockito.doReturn(2 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("101","Abdullah","Massage" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePageaddadmin() {
        Mockito.doReturn(5 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePageshowappointments() {
        Mockito.doReturn(3 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePage_viewEmployeeEarningsForRange() {
        Mockito.doReturn(4 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("31","10/10/2022","12/10/2022" ).when(mockScanner).nextLine();
        //Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePage_showrooms() {
        Mockito.doReturn(7 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomeCenterEarningsForRange() {
        Mockito.doReturn(9 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("10/10/2022","12/10/2022" ).when(mockScanner).nextLine();
        //Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
    }


}
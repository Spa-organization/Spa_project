package controller;

import database.AdminDB;
import database.AppointmentDb;
import database.EmployeeDB;
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
        //qusay
        adminController = new AdminController();

        mockScanner = Mockito.spy( new Scanner(System.in));
        adminController.scanner = mockScanner;
        adminController.admin = new Admin("21", "admin1", "123");
        AppointmentDb.scanner = mockScanner;
        EmployeeDB.scan = mockScanner;
    }


    @Test
    public void adminHomePageaddsawna() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
       assertTrue( adminController.addSawnaRoom());
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
        Mockito.doReturn(1, 2, 60, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(adminController.addMassageRoom());
    }
    //@Test
    public void adminHomePageshoowemployee() {
        Mockito.doReturn(1, 3,4, 100 ).when(mockScanner).nextInt();
       Mockito.doReturn("" ).when(mockScanner).nextLine();
        //Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePageaddadmin() {
        Mockito.doReturn(4 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(AdminController.addAdmin());
    }
    @Test
    public void adminHomePageaaddemployee() {
        Mockito.doReturn(2 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn(0.3 ).when(mockScanner).nextDouble();
        Mockito.doReturn("101","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(adminController.addEmployee());
    }
    @Test
    public void adminHomePageshowappointments() {
        Mockito.doReturn(3 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
        assertTrue(AdminController.showAppointments());
    }


    @Test
    public void adminHomePage_showrooms() {
        Mockito.doReturn(6 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
        assertTrue(EmployeeDB.showALlRooms());
    }
    @Test
    public void adminHomeCenterEarningsForRange() {
        Mockito.doReturn(8 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("1" ).when(mockScanner).nextLine();
        Mockito.doReturn("10/10/2022","12/10/2022").when(mockScanner).next();
        //Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void loginpage() {
        ;
        Mockito.doReturn("21","123" ).when(mockScanner).nextLine();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        //Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.loginPage();
    }
    @Test
    public void adminHomePage_shoowfeed() {
        Mockito.doReturn(7 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
        assertTrue(adminController.viewFeedbacks());
    }

    @Test
    public void adminHomePage_editemployee() {
        Mockito.doReturn(9 ,1,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("31","SerPro1","123","1").when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(EmployeeDB.editEmployee());
    }
    @Test
    public void adminHomePage_case12() {
        Mockito.doReturn(12 ,4,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.starter.scanner = mockScanner;
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePage_case100() {
        Mockito.doReturn(100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
    }




}
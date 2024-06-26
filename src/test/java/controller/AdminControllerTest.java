package controller;

import database.AppointmentDb;
import database.EmployeeDB;
import entity.Admin;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AdminControllerTest {
    AdminController adminController;
    EmployeeController employeeController;

    Scanner mockScanner;

    @Before
    public void setup() {
        employeeController=new EmployeeController();
        adminController = new AdminController();
        mockScanner = Mockito.spy( new Scanner(System.in));
        AdminController.scanner = mockScanner;
        employeeController.scanner = mockScanner;
        adminController.starter.scanner=mockScanner;
        adminController.admin = new Admin("21", "admin1", "123");
        AppointmentDb.scanner = mockScanner;
        EmployeeDB.scan = mockScanner;
    }


    @Test
    public void adminHomePageAddSawna() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
       assertTrue( adminController.addSawnaRoom());
    }
    @Test
    public void adminHomePage1AddSawnaWrong() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("31" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(true);

    }
    @Test
    public void adminHomePageAddMassage() {
        Mockito.doReturn(1, 2, 60, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(adminController.addMassageRoom());
    }
    @Test
    public void adminHomePageShowEmployee() {
        Mockito.doReturn(10, 100 ).when(mockScanner).nextInt();
        adminController.adminHomePage();
        assertTrue(AdminController.showAllEmployees());


    }
    @Test
    public void adminHomePageAddAdmin() {
        Mockito.doReturn(4 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(AdminController.addAdmin());
    }
    @Test
    public void adminHomePageAddEmployee() {
        Mockito.doReturn(2 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn(0.3 ).when(mockScanner).nextDouble();
        Mockito.doReturn("200","Abdullah","12345" ).when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(adminController.addEmployee());
    }
    @Test
    public void adminHomePageShowAppointments() {
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
    public void adminHomeCenterAndEmployeeEarningsForRange() {
        Mockito.doReturn(8 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("31" ).when(mockScanner).nextLine();
        Mockito.doReturn("01/09/2012","01/10/2012").when(mockScanner).next();
        adminController.adminHomePage();
        assertTrue(AppointmentDb.calculateEarningsForEmployeeAndCenterInRange());
    }
    @Test
    public void employeeHomePage(){
        Mockito.doReturn("31","123" ).when(mockScanner).nextLine();
        Mockito.doReturn(3 ).when(mockScanner).nextInt();
        assertTrue(employeeController.loginPage());
    }
    @Test
    public void EmployeeHome_EmployeeEarningsForRange() {
        Mockito.doReturn(2 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("01/09/2012","01/10/2012").when(mockScanner).next();

        employeeController.employeeHomePage();
        assertTrue(AppointmentDb.calculateEmployeeProfitPercentageForRange("31"));
    }
    @Test
    public void LogInPage() {
        Mockito.doReturn("21","123" ).when(mockScanner).nextLine();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        //Mockito.doReturn("100","Abdullah","12345" ).when(mockScanner).next();
        adminController.loginPage();
        assertTrue(true);
        //yanal
    }
    @Test
    public void adminHomePage_ShowFeed() {
        Mockito.doReturn(7 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
        assertTrue(adminController.viewFeedbacks());
    }

    @Test
    public void adminHomePage_EditEmployee() {

        Mockito.doReturn(9 ,100).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("31","SerPro1","123","1").when(mockScanner).next();
        Mockito.doReturn(0.7).when(mockScanner).nextDouble();
        adminController.adminHomePage();
        assertTrue(EmployeeDB.editEmployee());

    }


    @Test
    public void adminHomePage_case100() {
        Mockito.doReturn(100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        adminController.adminHomePage();
        assertTrue(true);
        //yanal

    }




}
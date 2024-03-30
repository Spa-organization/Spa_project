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
    public void adminHomePage() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("100" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
    @Test
    public void adminHomePage1() {
        Mockito.doReturn(1, 1, 33, 4, 100 ).when(mockScanner).nextInt();
        Mockito.doReturn("" ).when(mockScanner).nextLine();
        Mockito.doReturn("31" ).when(mockScanner).next();
        adminController.adminHomePage();
    }
}
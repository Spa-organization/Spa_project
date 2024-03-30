package najah.edu.acceptance;

import controller.ClientController;
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
    public void testBooking() {

        Mockito.doReturn("", "10/10/2022", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();
        clientController.bookMassage("Sawna");
    }

    @Test
    public void test() {
        Mockito.doReturn( "", "10/10/2026", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();
        clientController.bookMassage("Sawna");

        Mockito.doReturn("", "10/10/2022", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();
        clientController.updateSession();
    }
}
package najah.edu.acceptance;

import controller.ClientController;
import entity.Client;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ClientControllerTest {

    @Test
    public void booking() {
        ClientController clientController = new ClientController();
        Scanner mockScanner = Mockito.spy(clientController.scanner);
        clientController.scanner = mockScanner;
        Mockito.doReturn("", "10/10/2022", "10:10").when(mockScanner).nextLine();
        Mockito.doReturn(2).when(mockScanner).nextInt();

        clientController.client = new Client("11","clint1","123","qsay.3w@gmail.com");

        clientController.booking("Sawna");

    }
}
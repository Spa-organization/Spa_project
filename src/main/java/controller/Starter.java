package controller;



import basic.LoggerUtility;
import java.util.Scanner;
import java.util.logging.Logger;

public class Starter {
    private static final String COPY="-----------------------------------";

    private static final Logger LOGGER = LoggerUtility.getLogger();
    Scanner scanner= new Scanner(System.in);

    public void homePage()   {
        int choice;
        do {
            LOGGER.info("""
                    -----------------------------------
                    Welcome to the Spa Event Planner
                    -----------------------------------
                    1. Sign up for a client account
                    2. Log in
                    3. Exit
                    """);
            LOGGER.info("Enter your choice:");

            choice = scanner.nextInt();
            switch (choice) {
                case 1: ClientController clientController = new ClientController();
                    clientController.clientSignUp();
                    break;
                case 2: choseEntity();
                    break;
                case 3:
                    LOGGER.info("""
                            Exiting Spa Event Planner. Goodbye!
                            
                            """);
                    break;
                default:
                    LOGGER.info("""
                            Invalid choice. Please try again.

                            """);
            }

        } while (choice != 0);

    }

    public void choseEntity()  {
        int choice;

        do {
            LOGGER.info("""
                    -------------------------------------
                    -------------------------------------
                    === Spa Event Planner Main Menu ===
                    1. Login as Admin
                    2. Login as Customer
                    3. Login as Employee
                    4. Exit"""+"\n"+"Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    AdminController adminController =new AdminController() ;
                    adminController.loginPage();
                    break;
                case 2:
                    ClientController clientController = new ClientController();
                    clientController.loginPage();
                    break;
                case 3:
                    EmployeeController employeeController = new EmployeeController();
                    employeeController.loginPage();
                    break;
                case 4:
                    LOGGER.info("Exiting Spa Event Planner. Goodbye!");
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

}

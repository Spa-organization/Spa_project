package najah.edu.acceptance;

import Controller.AdminController;
import Entities.Employee;
import Entities.Room;
import database.Employee_DB;
import database.Room_DB;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminManagement {
AdminController Admin_controller;
static int roomType=1;
    int id_room=55;
    int id_emp=33;
    public static boolean add_room=true;

    public static boolean flag=false;
String admin_id="21";
Room room;
String admin_pass="123";
    public AdminManagement()
    {
        Admin_controller=new AdminController();

    }

    @Given("I am logged in as an admin")
    @Test
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loggIn_Check(admin_id, admin_pass);
        if(AdminController.isLoggedIn())
        {   flag= true;
            assertTrue(AdminController.isLoggedIn());
            System.out.println("-------------------------------------");
            System.out.println("SignIN done successfully");
            System.out.println("-------------------------------------");
        }
        else {
            flag= false;
            assertFalse(AdminController.isLoggedIn());
            System.out.println("-------------------------------------");
            System.out.println("SignIn  fail");
            System.out.println("-------------------------------------");
        }
    }


    @When("I choose to add a massage room")
    public void iChooseToAddAMassageRoom() {
        if(flag) {
            switch (roomType) {
                case 1:
                    assertTrue(flag);
                    System.out.println("1. Massage Room");
                    break;
                case 2:
                    assertTrue(flag);
                    System.out.println("2. sawna Room");
                    break;
                default:
                    assertNotEquals(false,flag);
                    System.out.println("Invalid choice. Please try again.");
            }
            assertTrue(flag);
        }

        else {
            assertFalse(flag);
            System.out.println("you are not login as admin");
        }
    }

    @And("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(int id_room, int id_emp) {
        this.id_room=id_room;
        this.id_emp=id_emp;
    }

    @Then("the massage room should be added to the system")
    @Test
    public void theMassageRoomShouldBeAddedToTheSystem() {
            int id_room = this.id_room;
            String employeeId = Integer.toString(id_emp);
            Employee employee = Employee_DB.getEmployeeById(employeeId);
            if (employee != null)//if not null the employee id is existed
            {
                if (employee.getWorkerType().equals("Massage")) {
                    if (Room_DB.addRoom(employee, id_room)) {
                        assertFalse(false);//
                        System.out.println("----------------------------");
                        System.out.println("This ID is Already Exists");
                        System.out.println("----------------------------");
                    }
                } else {
                    assertFalse(false);//
                    System.out.println("----------------------");
                    System.out.println("not Massage employee!!");
                    System.out.println("-----------------------");
                }
            }

            else {
                assertFalse(false);
                System.out.println("----------------------");
                System.out.println("employee not found!!");
                System.out.println("-----------------------");
            }
        }

    @When("I choose to add a  sawna room")
    public void iChooseToAddASawnaRoom() {
        if(flag) {
            switch (roomType) {
                case 1:
                    assertTrue(flag);
                    System.out.println("1. Massage Room");
                    break;
                case 2:
                    assertTrue(flag);
                    System.out.println("2. sawna Room");
                    break;
                default:
                    assertNotEquals(false,flag);
                    System.out.println("Invalid choice. Please try again.");
            }
            assertTrue(flag);
        }

        else {
            assertFalse(flag);
            System.out.println("you are not login as admin");
        }
        
    }

    @Then("the sawna room should be added to the system")
    public void theSawnaRoomShouldBeAddedToTheSystem() {
        int id_room = this.id_room;
        String employeeId = Integer.toString(id_emp);
        Employee employee = Employee_DB.getEmployeeById(employeeId);
        if (employee != null)//if not null the employee id is existed
        {
            if (employee.getWorkerType().equals("Massage")) {
                if (Room_DB.addRoom(employee, id_room)) {
                    add_room=false;
                    assertFalse(false);//
                    System.out.println("----------------------------");
                    System.out.println("This ID is Already Exists");
                    System.out.println("----------------------------");
                }
            } else {
                assertFalse(false);//
                System.out.println("----------------------");
                System.out.println("not Massage employee!!");
                System.out.println("-----------------------");
            }
        }

        else {
            assertFalse(false);
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
        if(add_room)
        {       //=new Room();
             //  Room_DB.getRoomById(id_room);
        }


    }
}

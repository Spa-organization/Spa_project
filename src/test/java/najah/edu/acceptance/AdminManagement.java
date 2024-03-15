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
    int id_room=5;
    int id_emp=36;

    boolean add_emp=Employee_DB.addServiceProviders("35","ali","321","massage");
    boolean add_emp1=Employee_DB.addServiceProviders("36","ali","321","sawna");


    public static boolean add_room=true;

    public static boolean flag=false;
    //dfgfd
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
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Enter Room ID: ");
        System.out.println("Enter Employee ID to manage the new: ");
        Employee employee= Employee_DB.getEmployeeById(Integer.toString(id_emp));
        if(employee!=null){
            if(!employee.getRooms().isEmpty())
            {
                if(employee.getRooms().get(0).getRoomNumber() == id_room)
                {   assertFalse(!(employee.getRooms().get(0).getRoomNumber() == id_room));
                    System.out.println("----------------------------");
                    System.out.println("The employee is already assigned to this room");
                    System.out.println("----------------------------");
                }
                else
                {  assertFalse((employee.getRooms().get(0).getRoomNumber() == id_room));
                    System.out.println("----------------------------");
                    System.out.println("The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber());
                    System.out.println("----------------------------");
                }
            }

            else if(employee.getWorkerType().equalsIgnoreCase("massage")){
                if(!Room_DB.addRoom(employee, id_room)){
                    assertFalse((Room_DB.addRoom(employee, id_room)));
                    System.out.println("----------------------------");
                    System.out.println("This ID_room is Already Exists");
                    System.out.println("----------------------------");
                }
                else {
                    assertFalse(Room_DB.addRoom(employee, id_room));
                    System.out.println("----------------------------");
                    System.out.println("massage Room Added");
                    System.out.println("----------------------------");
                }
            }
            else{
                assertFalse((employee.getWorkerType().equalsIgnoreCase("massage")));
                System.out.println("----------------------");
                System.out.println("not massage employee!!");
                System.out.println("-----------------------");
            }
        }
        else{
            assertFalse(employee!=null);
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
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.print("Enter Room ID: ");
        System.out.print("Enter Employee ID to manage the new: ");
        Employee employee= Employee_DB.getEmployeeById(Integer.toString(id_emp));
        if(employee!=null){
            if(!employee.getRooms().isEmpty())
            {
                if(employee.getRooms().get(0).getRoomNumber() == id_room)
                {
                    System.out.println("----------------------------");
                    System.out.println("The employee is already assigned to this room");
                    System.out.println("----------------------------");
                }
                else
                {
                    System.out.println("----------------------------");
                    System.out.println("The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber());
                    System.out.println("----------------------------");
                }
            }
            if(employee.getWorkerType().equalsIgnoreCase("Massage")){//
                if(!Room_DB.addRoom(employee, id_room)){
                    System.out.println("----------------------------");
                    System.out.println("This ID_room is Already Exists");
                    System.out.println("----------------------------");
                }
                else {
                    System.out.println("----------------------------");
                    System.out.println("Massage Room Added");
                    System.out.println("----------------------------");
                }
            }
            else{
                System.out.println("----------------------");
                System.out.println("not Massage employee!!");
                System.out.println("-----------------------");
            }
        }else{
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
    }
}

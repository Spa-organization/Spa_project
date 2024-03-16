package najah.edu.acceptance;
import Controller.AdminController;
import Entities.Appointment;
import Entities.Employee;
import database.Admin_DB;
import database.Appointment_DB;
import database.Employee_DB;
import database.Room_DB;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
public class AdminManagement {
AdminController Admin_controller;
 int roomType=2;
 int choice=2;
    public static boolean flag;
    String id_room="7";
    String new_employeeId="35" ;
    String employeeType="sawna" ;
    String new_employeePassword="321";
    String new_employeeName="ali";
String admin_id="21";
String adminName="ahmad";
String admin_pass="123";
    public AdminManagement()
    {Admin_controller=new AdminController();}

    @When("I choose to add an admin")
    public void iChooseToAddAnAdmin() {assertEquals(5, choice);}

    @And("I enter the admin {string} and it should be unique , name, and password")
    public void iEnterTheAdminAndItShouldBeUniqueNameAndPassword(String id_Admin) {this.admin_id=id_Admin;}
    @Then("the admin should be added to the system")
    public void theAdminShouldBeAddedToTheSystem() {
            assertTrue(Admin_DB.addAdmin(admin_id,adminName,admin_pass));}

    @When("I choose to add an employee")
    public void iChooseToAddAnEmployee() {assertEquals(2, choice);}

    @And("I enter the employee {string} and it should be unique , name, and password")
    public void iEnterTheEmployeeAndItShouldBeUniqueNameAndPassword(String emp_id) {this.new_employeeId=emp_id;}

    @Then("the employee should be added to the system")
    public void theEmployeeShouldBeAddedToTheSystem() {
        assertTrue(Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType));}

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loggIn_Check(admin_id,admin_pass);
            assertTrue(Admin_controller.isLoggedIn());}

    @When("I choose to add a massage room")
    public void iChooseToAddAMassageRoom() {
        assertEquals(2, roomType);}
    @And("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(String id_room, String id_emp) {
        this.id_room=id_room;this.new_employeeId=id_emp;}

    @Then("the massage room should be added to the system")
    public void theMassageRoomShouldBeAddedToTheSystem() {
        Employee employee= Employee_DB.getEmployeeById(new_employeeId);
        if(employee!=null){
            if(!employee.getRooms().isEmpty())
            {
                if(employee.getRooms().get(0).getRoomNumber() ==  Integer.parseInt(id_room))
                {   assertTrue((employee.getRooms().get(0).getRoomNumber() ==  Integer.parseInt(id_room)));
                    System.out.println("The employee is already assigned to this room");
                }
                else
                {  assertFalse((employee.getRooms().get(0).getRoomNumber() ==  Integer.parseInt(id_room)));
                    System.out.println("The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber());
                }
            }

            else if(employee.getWorkerType().equalsIgnoreCase("massage")){
                if(!Room_DB.addRoom(employee,  Integer.parseInt(id_room))){
                    assertFalse((Room_DB.addRoom(employee,  Integer.parseInt(id_room))));
                    System.out.println("This ID_room is Already Exists");
                }
                else {
                    assertFalse(Room_DB.addRoom(employee,  Integer.parseInt(id_room)));
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
            assertNull(employee);
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
    }

    @When("I choose to add a  sawna room")
    public void iChooseToAddASawnaRoom() {
            assertEquals(1, roomType);}
    @Then("the sawna room should be added to the system")
    public void theSawnaRoomShouldBeAddedToTheSystem() {
        System.out.println("Enter Room ID: ");
        System.out.println("Enter Employee ID to manage the new: ");
        Employee employee = Employee_DB.getEmployeeById(new_employeeId);
        if (employee != null) {
            if (!employee.getRooms().isEmpty()) {
                if (employee.getRooms().get(0).getRoomNumber() == Integer.parseInt(id_room)) {
                    assertFalse(!(employee.getRooms().get(0).getRoomNumber() == Integer.parseInt(id_room)));

                    System.out.println("The employee is already assigned to this room");
                    System.out.println("----------------------------");
                } else {
                    assertFalse((employee.getRooms().get(0).getRoomNumber() == Integer.parseInt(id_room)));
                    System.out.println("----------------------------");
                    System.out.println("The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber());
                    System.out.println("----------------------------");
                }
            } else if (employee.getWorkerType().equalsIgnoreCase("sawna")) {
                if (!Room_DB.addRoom(employee, Integer.parseInt(id_room))) {
                    assertFalse((Room_DB.addRoom(employee, Integer.parseInt(id_room))));
                    System.out.println("----------------------------");
                    System.out.println("This ID_room is Already Exists");
                    System.out.println("----------------------------");
                } else {
                    assertFalse(Room_DB.addRoom(employee, Integer.parseInt(id_room)));
                    System.out.println("----------------------------");
                    System.out.println("sawna Room Added");
                    System.out.println("----------------------------");
                }
            } else {
                assertFalse((employee.getWorkerType().equalsIgnoreCase("sawna")));
                System.out.println("----------------------");
                System.out.println("not sawna employee!!");
                System.out.println("-----------------------");
            }
        } else {
            assertNull(employee);
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
    }

    @Then("the all appointments should show up")
    public void theAllAppointmentsShouldShowUp() {
        AdminController.showAppointments();
    }

    @When("I choose to view the overall profit")
    public void iChooseToViewTheOverallProfit() {


    }

    @Then("the system should display the total profit generated from all appointments")
    public void theSystemShouldDisplayTheTotalProfitGeneratedFromAllAppointments() {
    }

    @When("I choose to view the profit for a specific employee")
    public void iChooseToViewTheProfitForASpecificEmployee() {
    }

    @And("give the {string} of this employee")
    public void giveTheOfThisEmployee(String arg0) {
    }

    @Then("the system should display the total profit generated from all appointments of that employee")
    public void theSystemShouldDisplayTheTotalProfitGeneratedFromAllAppointmentsOfThatEmployee() {
    }
}

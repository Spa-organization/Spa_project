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
    String id_room="6";
    String new_employeeId="35" ;
    String employeeType="massage" ;
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
    @Test
    public void iChooseToAddAnEmployee() {assertEquals(2, choice);}

    @And("I enter the employee {string} and it should be unique , name, and password")
    public void iEnterTheEmployeeAndItShouldBeUniqueNameAndPassword(String emp_id) {this.new_employeeId=emp_id;}

    @Then("the employee should be added to the system")
    @Test
    public void theEmployeeShouldBeAddedToTheSystem() {
        assertTrue(Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType));}

    @Given("I am logged in as an admin")
    @Test
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loggIn_Check(admin_id,admin_pass);
            assertTrue(Admin_controller.isLoggedIn());}

    @When("I choose to add a massage room")
    @Test
    public void iChooseToAddAMassageRoom() {
        assertEquals(2, roomType);}
    @And("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(String id_room, String id_emp) {
        this.id_room=id_room;this.new_employeeId=id_emp;}

    @Then("the massage room should be added to the system")
    @Test
    public void theMassageRoomShouldBeAddedToTheSystem() {
    assertTrue(Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType));
    Employee employee= Employee_DB.getEmployeeById(new_employeeId);
    assertTrue(Room_DB.addRoom(employee,Integer.parseInt(id_room)));}

    @When("I choose to add a  sawna room")
    public void iChooseToAddASawnaRoom() {assertEquals(1, roomType);}
    @Then("the sawna room should be added to the system")
    public void theSawnaRoomShouldBeAddedToTheSystem() {
    assertTrue(Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType));
    Employee employee = Employee_DB.getEmployeeById(new_employeeId);
    assertTrue(Room_DB.addRoom(employee, Integer.parseInt(id_room)));}

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

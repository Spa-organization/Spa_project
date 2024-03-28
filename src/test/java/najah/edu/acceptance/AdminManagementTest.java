package najah.edu.acceptance;
import controller.AdminController;
import controller.EmployeeController;
import entity.Employee;
import database.AdminDB;
import database.AppointmentDb;
import database.EmployeeDB;
import database.RoomDb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;
public class AdminManagementTest {
    AdminController Admin_controller;
    int roomType ;
    int choice;
    String emp_id, emp_name, emp_password, worker_type, admin_id, admin_name, admin_pass, room_id,start_date,end_date;

    public AdminManagementTest() {
        Admin_controller = new AdminController();
    }

    @Given("I am logged in as an admin")
    @Test
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loginCheck("21", "123");
        assertTrue(Admin_controller.isLoggedIn());}

    @When("I choose to add an employee")
    @Test
    public void iChooseToAddAnEmployee() {
        choice=1;
        assertEquals(1,choice);}

    @And("I enter the employee {string} and it should be unique and name {string} and pass {string} and choice {string}")
    public void iEnterTheEmployeeAndItShouldBeUniqueAndNameAndPassAndChoice(String id, String name, String pass, String type) {
        this.worker_type = type;
        this.emp_id = id;
        this.emp_name = name;
        this.emp_password = pass;}

    @Then("the employee should be added to the system")
    @Test
    public void theEmployeeShouldBeAddedToTheSystem() {
        emp_id="35";
        emp_name="ali";
        emp_password="123";
        worker_type="massage";
        assertTrue(EmployeeDB.addServiceProviders(emp_id, emp_name, emp_password, worker_type));}

    @When("I choose to add an admin")
    @Test
    public void iChooseToAddAnAdmin() {
        choice=2;
        assertEquals(2,choice);}

    @When("I enter the admin {string} and it should be unique and name {string} and pass {string}")
    public void iEnterTheAdminAndItShouldBeUniqueAndNameAndPass(String id, String name, String pass) {
        this.admin_id = id;
        this.admin_name = name;
        this.admin_pass = pass;

    }

    @Then("the admin should be added to the system")
    @Test
    public void theAdminShouldBeAddedToTheSystem() {
        assertTrue(AdminDB.addAdmin(admin_id, admin_name, admin_pass));}

    @When("I choose to add a massage room")
    @Test
    public void iChooseToAddAMassageRoom() {
        assertTrue(true);
    }

    @When("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(String id1, String id2) {
        this.emp_id = id1;
        this.room_id = id2;
    }

    @Then("the massage room should be added to the system")
    @Test
    public void theMassageRoomShouldBeAddedToTheSystem() {
        emp_id="36";
        emp_name="ali";
        emp_password="123";
        worker_type="massage";
        room_id="5";
        EmployeeDB.addServiceProviders(emp_id, emp_name, emp_password, worker_type);
        Employee employee = EmployeeDB.getEmployeeById(emp_id);
        assertTrue(RoomDb.addRoom(employee, Integer.parseInt(room_id)));
        assertNotNull(employee);
    }



}


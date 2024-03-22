package najah.edu.acceptance;
import Controller.AdminController;
import Entities.Employee;
import database.Admin_DB;
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
    int roomType ;
    int choice;
    String emp_id, emp_name, emp_password, worker_type, admin_id, admin_name, admin_pass, room_id,start_date,end_date;

    public AdminManagement() {
        Admin_controller = new AdminController();
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loggIn_Check("21", "123");
        assertTrue(Admin_controller.isLoggedIn());
    }

    @When("I choose to add an employee")
    public void iChooseToAddAnEmployee() {
        choice=1;
        assertEquals(1,choice);
    }

    @And("I enter the employee {string} and it should be unique and name {string} and pass {string} and choice {string}")
    public void iEnterTheEmployeeAndItShouldBeUniqueAndNameAndPassAndChoice(String id, String name, String pass, String type) {
        this.worker_type = type;
        this.emp_id = id;
        this.emp_name = name;
        this.emp_password = pass;
    }

    @Then("the employee should be added to the system")
    public void theEmployeeShouldBeAddedToTheSystem() {
        // emp_id="35";
        //  emp_password="123";
        // worker_type="massage";
        //  emp_name="ali";
        assertTrue(Employee_DB.addServiceProviders(emp_id, emp_name, emp_password, worker_type));
    }

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
        // admin_id="25";
        //  admin_pass="123";
        //   admin_name="qusay";
        assertTrue(Admin_DB.addAdmin(admin_id, admin_name, admin_pass));
    }

    @When("I choose to add a massage room")
    @Test
    public void iChooseToAddAMassageRoom() {
        roomType=2;
        assertEquals(2,roomType);
    }

    @When("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(String id1, String id2) {
        this.emp_id = id1;
        this.room_id = id2;
    }

    @Then("the massage room should be added to the system")
    @Test
    public void theMassageRoomShouldBeAddedToTheSystem() {
      //   emp_id="35";
      //  emp_password="123";
      //  worker_type="massage";
       //  emp_name="ali";
       //  room_id="7";
        assertTrue(Employee_DB.addServiceProviders(emp_id, emp_name, emp_password, worker_type));
        Employee employee = Employee_DB.getEmployeeById(emp_id);
        assertNotNull(employee);
        assertTrue(Room_DB.addRoom(employee, Integer.parseInt(room_id)));
    }

    @When("I choose to add a  sawna room")
    public void iChooseToAddASawnaRoom() {
        roomType=1;
        assertEquals(1,roomType);
    }

    @Then("the sawna room should be added to the system")
    @Test
    public void theSawnaRoomShouldBeAddedToTheSystem() {
     //   emp_id="36";
     // emp_password="123";
     //   worker_type="sawna";
     //  emp_name="ali";
     //  room_id="5";
        assertTrue(Employee_DB.addServiceProviders(emp_id, emp_name, emp_password, worker_type));
        Employee employee = Employee_DB.getEmployeeById(emp_id);
        assertNotNull(employee);
        assertTrue(Room_DB.addRoom(employee, Integer.parseInt(room_id)));
    }

    @Then("the all appointments should show up")
    @Test
    public void theAllAppointmentsShouldShowUp() {AdminController.showAppointments();}


  //  @When("I choose to view the profit for a center and  specific employee in specific period of time")
  //  public void iChooseToViewTheProfitForACenterAndSpecificEmployeeInSpecificPeriodOfTime() {
   //     choice=5;
  //      assertEquals(5,choice);
  //  }

   // @And("give the {string} of this employee and {string} and {string}")
 //   public void giveTheOfThisEmployeeAndAnd(String id, String start_date, String end_date) {
//        this.emp_id=id;
 //       this.end_date=end_date;
 //       this.start_date=start_date;
 //   }

 //   @Then("the system should display the total profit generated from all appointments of  a center that employee in specific period of time")
   // public void theSystemShouldDisplayTheTotalProfitGeneratedFromAllAppointmentsOfACenterThatEmployeeInSpecificPeriodOfTime() {
  //      Appointment_DB.calculateTotalCenterEarningsInRange(start_date,end_date);
 //       Appointment_DB.calculateEarningsForEmployeeInRange(emp_id,start_date,end_date);
 //   }
}



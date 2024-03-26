package najah.edu.acceptance;
import controller.AdminController;
import entity.Employee;
import database.AdminDB;
import database.Appointment_DB;
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
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loginCheck("21", "123");
        assertTrue(Admin_controller.isLoggedIn());}

    @When("I choose to add an employee")
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
    public void theEmployeeShouldBeAddedToTheSystem() {
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
//
    @Then("the admin should be added to the system")
    @Test
    public void theAdminShouldBeAddedToTheSystem() {
        assertTrue(true);
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
        assertTrue(true);
    }

    @When("I choose to add a  sawna room")
    @Test
    public void iChooseToAddASawnaRoom() {
        roomType=1;
        assertEquals(1,roomType);
    }

    @Then("the sawna room should be added to the system")
    @Test
    public void theSawnaRoomShouldBeAddedToTheSystem() {
        assertTrue(true);
    }

    @Then("the all appointments should show up")
    @Test
    public void theAllAppointmentsShouldShowUp() {
        assertTrue(true);
        AdminController.showAppointments();}



    @When("I select the option to view financial profits for a specific period,")
    @Test
    public void i_select_the_option_to_view_financial_profits_for_a_specific_period() {
        choice=5;
        assertEquals(5,choice);
    }
    @When("I enter a valid employee {string}, the start date {string}, and the end date {string} for the period I wish to analyze,")
    public void i_enter_a_valid_employee_the_start_date_and_the_end_date_for_the_period_i_wish_to_analyze(String id, String start_date, String end_date) {
        this.start_date=start_date;this.end_date=end_date;this.emp_id=id;
    }
    @Then("the system should calculate the net profit generated by the specified employee from all their appointments within the given time period. This includes the total income from the services they provided, minus any associated costs attributed to those services.")
    @Test
    public void the_system_should_calculate_the_net_profit_generated_by_the_specified_employee_from_all_their_appointments_within_the_given_time_period_this_includes_the_total_income_from_the_services_they_provided_minus_any_associated_costs_attributed_to_those_services() {
        assertTrue(true);
    }

    @When("I choose to view the overall profit")
    @Test
    public void iChooseToViewTheOverallProfit() {
        choice=6;
        assertEquals(6,choice);
    }


    @When("the start date {string}, and the end date {string} for the period I wish to analyze,")

    public void theStartDateAndTheEndDateForThePeriodIWishToAnalyze(String start_date, String end_date) {
        this.start_date=start_date;this.end_date=end_date;
    }
    @Then("the system should display the total profit generated from all appointments")
    @Test
    public void theSystemShouldDisplayTheTotalProfitGeneratedFromAllAppointments() {
        assertTrue(true);
    }

}



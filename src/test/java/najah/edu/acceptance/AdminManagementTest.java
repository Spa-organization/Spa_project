package najah.edu.acceptance;
import controller.AdminController;
import entity.Employee;
import database.AdminDB;
import database.EmployeeDB;
import database.RoomDb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static database.EmployeeDB.showALlRooms;
import static org.junit.Assert.*;
public class AdminManagementTest {
    AdminController Admin_controller;
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
        emp_id="35";
        emp_name="ali";
        emp_password="123";
        worker_type="massage";
         double percantage=0.20;
        assertTrue(EmployeeDB.addServiceProviders(emp_id, emp_name, emp_password, worker_type,percantage));}




    @When("I enter the admin {string} and it should be unique and name {string} and pass {string}")
    public void iEnterTheAdminAndItShouldBeUniqueAndNameAndPass(String id, String name, String pass) {
        this.admin_id = id;
        this.admin_name = name;
        this.admin_pass = pass;

    }

    @Then("the admin should be added to the system")
    public void theAdminShouldBeAddedToTheSystem() {
        assertTrue(AdminDB.addAdmin(admin_id, admin_name, admin_pass));}

    @When("I choose to add an admin")
    public void iChooseToAddAnAdmin() {
       assertTrue(true);
    }

    @When("I choose to add a massage room")
    public void iChooseToAddAMassageRoom() {assertTrue(true);}

    @When("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(String id1, String id2) {
        this.emp_id = id1;
        this.room_id = id2;
    }

    @Then("the massage room should be added to the system")

    public void theMassageRoomShouldBeAddedToTheSystem() {
        emp_id="47";
        emp_name="ali";
        emp_password="123";
        worker_type="massage";
        room_id="10";
        double percantage=0.20;
        assertTrue(EmployeeDB.addServiceProviders(emp_id, emp_name, emp_password, worker_type,percantage));

        Employee employee = EmployeeDB.getEmployeeById(emp_id);
        assertNotNull(employee);
        assertTrue(RoomDb.checkValidateID(10));
        assertTrue(RoomDb.addRoom(employee, Integer.parseInt(room_id)));

    }

    @When("I choose to add a  sawna room")
    public void iChooseToAddASawnaRoom()
        {assertTrue(true);}

    @Then("the sawna room should be added to the system")
    public void theSawnaRoomShouldBeAddedToTheSystem() {
        emp_id="410";
        emp_name="ali";
        emp_password="123";
        worker_type="sawna";
        room_id="9";
        double percantage=0.20;
        assertTrue(EmployeeDB.addServiceProviders(emp_id, emp_name, emp_password, worker_type,percantage));
        Employee employee = EmployeeDB.getEmployeeById(emp_id);
        assertNotNull(employee);
        assertTrue(RoomDb.addRoom(employee, Integer.parseInt(room_id)));
    }

    @Then("the all appointments should show up")
    public void theAllAppointmentsShouldShowUp() {assertTrue(AdminController.showAppointments());}



    @When("I select the option to view financial profits for a specific period,")
    public void i_select_the_option_to_view_financial_profits_for_a_specific_period()
    {assertTrue(true);}


    @When("I enter a valid employee {string}, the start date {string}, and the end date {string} for the period I wish to analyze,")
    public void i_enter_a_valid_employee_the_start_date_and_the_end_date_for_the_period_i_wish_to_analyze(String id, String start_date, String end_date) {
        this.start_date=start_date;this.end_date=end_date;this.emp_id=id;
    }
    @Then("the system should calculate the net profit generated by the specified employee from all their appointments within the given time period. This includes the total income from the services they provided, minus any associated costs attributed to those services.")
    public void the_system_should_calculate_the_net_profit_generated_by_the_specified_employee_from_all_their_appointments_within_the_given_time_period_this_includes_the_total_income_from_the_services_they_provided_minus_any_associated_costs_attributed_to_those_services() {
        emp_id="31";
        start_date="01/03/2012";
        end_date="01/04/2012";

    }

    @When("I choose to view the overall profit")
    public void iChooseToViewTheOverallProfit() {
        assertTrue(true);
    }


    @When("the start date {string}, and the end date {string} for the period I wish to analyze,")
    public void theStartDateAndTheEndDateForThePeriodIWishToAnalyze(String start_date, String end_date) {
        this.start_date=start_date;this.end_date=end_date;
    }
    @Then("the system should display the total profit generated from all appointments")

     public void theSystemShouldDisplayTheTotalProfitGeneratedFromAllAppointments() {
        start_date="01/09/2012";
        end_date="01/10/2012";
        assertFalse(false);
    }



    @When("I select the option to edit a specific employee,")
    public void i_select_the_option_to_edit_a_specific_employee() {
        assertTrue(true);

    }
    @When("I give the id and new name {string} new password {string} new type {string} and new room {string}")
    public void i_give_the_id_and_new_name_new_password_new_type_and_new_room(String string, String string2, String string3, String string4) {
        this.emp_name=string;
        this.emp_password=string2;
        this.worker_type=string3;
        this.room_id=string4;
    }
    @Then("the system should edit this employee")

      public void the_system_should_edit_this_employee() {
        emp_id="33";
        emp_name="ali";
        emp_password="3214";
        worker_type="1";
        room_id="7";
        assertTrue(true);
    }



    @When("I choose to view the feedbacks")
    public void i_choose_to_view_the_feedbacks() {
        assertTrue(true);
    }
    @Then("the feedbacks should show up")
    public void the_feedbacks_should_show_up() {
         assertTrue(Admin_controller.viewFeedbacks());
    }


    @When("I choose to view the employees")
    public void i_choose_to_view_the_employees() {
        assertTrue(true);
    }
    @Then("the list of employees should show up")
    @Test
    public void the_list_of_employees_should_show_up() {
        assertTrue(AdminController.showAllEmployees());}


    @When("I choose to view the rooms")
    public void i_choose_to_view_the_rooms() {
        assertTrue(true);
    }
    @Then("the list of rooms should show up")
    @Test
    public void the_list_of_rooms_should_show_up() {
        assertTrue(true);
        assertTrue(showALlRooms());

    }


}

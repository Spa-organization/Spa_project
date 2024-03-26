package najah.edu.acceptance;

import controller.EmployeeController;
import database.AppointmentDb;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ScheduleTest {
    EmployeeController employeeController;
    int choice;
    String start_date,end_date,id;

    public ScheduleTest () {employeeController=new EmployeeController();}

    @Given("I am logged in as an Employee")
    @Test
    public void iAmLoggedInAsAnEmployee() {
        employeeController.loggInCheck("31","123");
        assertTrue(employeeController.isLoggedIn());
    }
    @When("I choose to view my profit in specific month")
    @Test
    public void iChooseToViewMyProfitInSpecificMonth() {
        choice=2;
        assertEquals(2,choice);
    }
    @When("give the {string} of this employee and {string} and {string}")
    public void giveTheOfThisEmployeeAndAnd(String id, String date1, String date2) {
        this.end_date=date2;
        this.start_date=date1;
        this.id=id;
    }
    @Then("the profit of employee will calculated")
    @Test
    public void theProfitOfEmployeeWillCalculated() {
        id="31";
        start_date="01/03/2012";
        end_date="01/04/2012";
        assertTrue(AppointmentDb.calculateEarningsForEmployeeInRange(id,start_date,end_date));

    }

    @When("give the {string} of this employee")
    public void giveTheOfThisEmployee(String id) {
        this.id=id;
    }

    @Then("the appointment of this employee will shown")
    @Test
    public void theAppointmentOfThisEmployeeWillShown() {
        employeeController.showEmployeeAppointments();
    }
}

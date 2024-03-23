package najah.edu.acceptance;

import Controller.EmployeeController;
import database.Appointment_DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class schedule {
    EmployeeController employeeController;
    int choice;
    String start_date,end_date,id;

    public schedule () {employeeController=new EmployeeController();}

    @Given("I am logged in as an Employee")
    @Test
    public void iAmLoggedInAsAnEmployee() {
        employeeController.loggIn_Check("31","123");
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
        assertTrue(Appointment_DB.calculateEarningsForEmployeeInRange(id,start_date,end_date));

    }
}

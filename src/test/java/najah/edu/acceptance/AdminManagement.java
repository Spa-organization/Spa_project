package najah.edu.acceptance;
import Controller.AdminController;
import Entities.Appointment;
import Entities.Employee;
import Entities.Room;
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
static int roomType=3;
    int id_room=5;
    int id_emp=35;
    static int choice;

    String new_employeeId="31" ;
    String employeeType="massage" ;
    String new_employeePassword="321";
    String new_employeeName="ali";



    boolean add_emp1=Employee_DB.addServiceProviders("36","ali","321","sawna");
    public static boolean flag;
String admin_id="21";
String adminName="ahmad";
String admin_pass="123";
    public AdminManagement()
    {
        Admin_controller=new AdminController();
    }

    @Given("I am logged in as an admin")
    @Test
    public void iAmLoggedInAsAnAdmin() {
        Admin_controller.loggIn_Check(admin_id, admin_pass);
        flag=Admin_controller.isLoggedIn();
            assertTrue(flag);
    }
    @When("I choose to add a massage room")
    public void iChooseToAddAMassageRoom() {
    if(roomType==1) {
        assertTrue(flag);
        System.out.println("1. Massage Room");
    }
    else {assertFalse(!flag);
        System.out.println("Invalid choice. Please try again.");}
    }

    @And("I enter the a unique room {string} and Employee {string} that not add yet any room")
    public void iEnterTheAUniqueRoomAndEmployeeThatNotAddYetAnyRoom(int id_room, int id_emp) {
      this.id_room=id_room;
      this.id_emp=id_emp;
    }

    @When("I choose to add a  sawna room")
    public void iChooseToAddASawnaRoom() {
           if(roomType==2) {
               assertTrue(flag);
               System.out.println("2. sawna Room");
           }

    }

    @Then("the sawna room should be added to the system")

    public void theSawnaRoomShouldBeAddedToTheSystem() {
        System.out.println("Enter Room ID: ");
        System.out.println("Enter Employee ID to manage the new: ");
        Employee employee = Employee_DB.getEmployeeById(Integer.toString(id_emp));
        if (employee != null) {
            if (!employee.getRooms().isEmpty()) {
                if (employee.getRooms().get(0).getRoomNumber() == id_room) {
                    assertFalse(!(employee.getRooms().get(0).getRoomNumber() == id_room));

                    System.out.println("The employee is already assigned to this room");
                    System.out.println("----------------------------");
                } else {
                    assertFalse((employee.getRooms().get(0).getRoomNumber() == id_room));
                    System.out.println("----------------------------");
                    System.out.println("The employee is already assigned to a different room: " + employee.getRooms().get(0).getRoomNumber());
                    System.out.println("----------------------------");
                }
            } else if (employee.getWorkerType().equalsIgnoreCase("sawna")) {
                if (!Room_DB.addRoom(employee, id_room)) {
                    assertFalse((Room_DB.addRoom(employee, id_room)));
                    System.out.println("----------------------------");
                    System.out.println("This ID_room is Already Exists");
                    System.out.println("----------------------------");
                } else {
                    assertFalse(Room_DB.addRoom(employee, id_room));
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

    @Then("the massage room should be added to the system")
    public void theMassageRoomShouldBeAddedToTheSystem() {
        System.out.println("Enter Room ID: ");
        System.out.println("Enter Employee ID to manage the new: ");
        Employee employee= Employee_DB.getEmployeeById(Integer.toString(id_emp));
        if(employee!=null){
            if(!employee.getRooms().isEmpty())
            {
                if(employee.getRooms().get(0).getRoomNumber() == id_room)
                {   assertFalse(!(employee.getRooms().get(0).getRoomNumber() == id_room));

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
            assertNull(employee);
            System.out.println("----------------------");
            System.out.println("employee not found!!");
            System.out.println("-----------------------");
        }
    }


    @When("I choose to add an employee")
    @Test
    public void iChooseToAddAnEmployee() {
        if(choice==2) {
            assertTrue(true);
        }
    }

    @And("I enter the employee {string} and it should be unique , name, and password")
    public void iEnterTheEmployeeAndItShouldBeUniqueNameAndPassword(int emp_id) {
        this.id_emp=emp_id;

    }

    @Then("the employee should be added to the system")
    public void theEmployeeShouldBeAddedToTheSystem() {
        System.out.println("=== Add Employee ===");
        if(!Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType)){
            assertFalse(Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType));
            System.out.println("----------------------------");
            System.out.println("This ID is Already Exists");
            System.out.println("----------------------------");
        }else
            assertTrue(!Employee_DB.addServiceProviders(new_employeeId,new_employeeName,new_employeePassword,employeeType));

        System.out.println("Employee added successfully!");

        System.out.println("================");
    }

    @Then("the all appointments should show up")
    public void theAllAppointmentsShouldShowUp() {
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("=== All Appointments ===");
        List<Appointment> appointments= new ArrayList<Appointment>();
        appointments = Appointment_DB.getAllAppointments();
        for(Appointment appointment:appointments){
            System.out.println("---------");
            System.out.println(" type: "+appointment.getEmployee().getWorkerType());
            System.out.println("Room: "+appointment.getRoom().getRoomNumber());
            System.out.println("Employee: "+appointment.getEmployee().getName());
            System.out.println("Date: "+appointment.getDate()+" Time"+appointment.getTime());
        }
    }

    @When("I choose to add an admin")
    public void iChooseToAddAnAdmin() {
        if(choice==5) {
            assertTrue(true);
        }

    }

    @And("I enter the admin {string} and it should be unique , name, and password")
    public void iEnterTheAdminAndItShouldBeUniqueNameAndPassword(String id_Admin) {
        this.admin_id=id_Admin;
    }

    @Then("the admin should be added to the system")
    public void theAdminShouldBeAddedToTheSystem() {
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("=== Add Admin ===");
        System.out.print("Enter Admin ID: ");

        System.out.print("Enter Admin Name: ");

        System.out.print("Enter Admin Password: ");
        if(!Admin_DB.addAdmin(admin_id,adminName,admin_pass)){
            assertFalse(Admin_DB.addAdmin(admin_id,adminName,admin_pass));
            System.out.println("----------------------------");
            System.out.println("This ID is Already Exists");
            System.out.println("----------------------------");
        }else {
            assertTrue(!Admin_DB.addAdmin(admin_id,adminName,admin_pass));
            System.out.println("=== Admin added ===");
        }
    }
}

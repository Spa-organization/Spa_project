Feature: Admin Management

Scenario: Add  Room                      // ready
Given I am logged in as an admin
When I choose to add a massage room or sawna room
And I enter the a unique room "ID" and Employee "id" that not add yet any room
Then the massage room should be added to the system


Scenario: Add Employee                //ready
Given I am logged in as an admin
When I choose to add an employee
And I enter the employee "ID" and it should be unique , name, and password
Then the employee should be added to the system

Scenario: Add Admin                //ready
Given I am logged in as an admin
When I choose to add an admin
And I enter the admin "ID" and it should be unique , name, and password
Then the admin should be added to the system


Scenario: view appointments               //ready
Given I am logged in as an admin
When I choose to view the appointments
Then the all appointments should show up



Scenario: View Overall Profit 
Given I am logged in as an admin
When I choose to view the overall profit
Then the system should display the total profit generated from all appointments



Scenario: View Profit of employees 
Given I am logged in as an admin
When I choose to view the profit for a specific employee 
And give the "ID" of this employee
Then the system should display the total profit generated from all appointments of that employee
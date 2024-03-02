Feature: Admin Management

Scenario: Add Massage Room
Given I am logged in as an admin
When I choose to add a massage room
And I enter the a unique room "ID"
Then the massage room should be added to the system


Scenario: Add Employee
Given I am logged in as an admin
When I choose to add an employee
And I enter the employee "ID" and it should be unique , name, and password
Then the employee should be added to the system

Scenario: Add Admin
Given I am logged in as an admin
When I choose to add an admin
And I enter the admin "ID" and it should be unique , name, and password
Then the admin should be added to the system


Scenario: view appointments
Given I am logged in as an admin
When I choose to view the appointments
And I enter a specific "date"
Then the appointments should show up according to the given date 



Scenario: View Overall Profit 
Given I am logged in as an admin
When I choose to view the overall profit
Then the system should display the total profit generated from all appointments



Scenario: View Profit of employees 
Given I am logged in as an admin
When I choose to view the profit for a specific employee 
And give the "ID" of this employee
Then the system should display the total profit generated from all appointments of that employee
Feature: Admin Management

  Scenario: Add Employee
    Given I am logged in as an admin
    When I choose to add an employee
    And I enter the employee "35" and it should be unique , name, and password
    Then the employee should be added to the system

  Scenario: Add Admin
    Given I am logged in as an admin
    When I choose to add an admin
    And I enter the admin "25" and it should be unique , name, and password
    Then the admin should be added to the system

Scenario: Add  Massage_Room
  Given I am logged in as an admin
When I choose to add a massage room
And I enter the a unique room "5" and Employee "35" that not add yet any room
Then the massage room should be added to the system


  Scenario: Add  Sawna_Room
    Given I am logged in as an admin
    When I choose to add a  sawna room
    And I enter the a unique room "3" and Employee "33" that not add yet any room
    Then the sawna room should be added to the system

Scenario: view appointments
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
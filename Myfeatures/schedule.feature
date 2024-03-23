Feature: schedule

  Scenario: view profit
Given I am logged in as an Employee
When I choose to view my profit in specific month
And give the "31" of this employee and "01/09/2012" and "01/10/2012"
Then the profit of employee will calculated

  Scenario: view Appointment
    Given I am logged in as an Employee
    When I choose to view my profit in specific month
    And give the "31" of this employee and "01/09/2012" and "01/10/2012"
    Then the profit of employee will calculated

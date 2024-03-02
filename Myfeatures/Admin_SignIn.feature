Feature: admin sign in

  Scenario: Successful sign in
    Given that the admin is not logged in the app
    And the ID is "1234"
    And the password is "abdullah"
    Then  the admin is logged in the app successfully

  Scenario: Sign in with incorrect ID
    Given that the admin is not logged in the app
    And the ID is "incorrect"
    And the password is "abdullah"
    Then the admin will not login
    And the message appear to tell the admin what's wrong

  Scenario: Sign in with incorrect password
    Given that the admin is not logged in the app
    And the ID is "1"
    And the password is "abdullah"
    Then the admin will not login
    And the message appear to tell the admin what's wrong

  Scenario: Admin entered empty password or ID
    Given that the admin is not logged in the app
    And the ID is " "
    And the password is " "
    Then the admin will not login
    And the message appear to tell the admin what's wrong
      

 

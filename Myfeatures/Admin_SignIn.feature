Feature: admin sign in

  Scenario: Successful sign IN
    Given that the admin is not logged in the app
    And the ID is "21"
    And the password is "123"
    Then  the admin is logged in the app successfully

  Scenario: Sign in with incorrect ID
    Given that the admin is not logged in the app
    And the ID is "123"
    And the password is "123"
    Then the admin will not login
    And the message appear to tell the admin what's wrong

  Scenario: Sign in with incorrect password
    Given that the admin is not logged in the app
    And the ID is "21"
    And the password is "1234"
    Then the admin will not login
    And the message appear to tell the admin what's wrong


      

 

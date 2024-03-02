Feature: client sign in

  Scenario: Successful sign in
    Given that the client is not logged in the app
    And the ID is "1"
    And the password is "123"
    Then  the client is logged in the app successfully

  Scenario: Sign in with incorrect ID
    Given that the client is not logged in the app
    And the ID is "incorrect"
    And the password is "correct"
    Then the client will not login
    And the message appear to tell the client what's wrong

  Scenario: Sign in with incorrect password
    Given that the client is not logged in the app
    And the ID is "correct"
    And the password is "incorrect"
    Then the client will not login
    And the message appear to tell the client what's wrong

  Scenario: client entered empty password or ID
    Given that the client is not logged in the app
    And the ID is " "
    And the password is " "
    Then the client will not login
    And the message appear to tell the client what's wrong
      

 

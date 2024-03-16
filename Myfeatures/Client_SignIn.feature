Feature: client sign in

  Scenario: Successful sign in
    Given that the client is not logged in the app
    And the ID is "11"
    And the password is "123"
    Then  the client is logged in the app successfully

  Scenario: Sign in with incorrect ID
    Given that the client is not logged in the app
    And the ID is "111"
    And the password is "123"
    Then the client will not login
    And the message appear to tell the client what's wrong

  Scenario: Sign in with incorrect password
    Given that the client is not logged in the app
    And the ID is "11"
    And the password is "1245"
    Then the client will not login
    And the message appear to tell the client what's wrong

      

 

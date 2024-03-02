Feature: service provider sign in

  Scenario: Successful sign in
    Given that the service provider is not logged in the app
    And the ID is "correct"
    And the password is "correct"
    Then  the service provider is logged in the app successfully

  Scenario: Sign in with incorrect ID
    Given that the service provider is not logged in the app
    And the ID is "incorrect"
    And the password is "correct"
    Then the service provider will not login
    And the message appear to tell the service provider what's wrong

  Scenario: Sign in with incorrect password
    Given that the service provider is not logged in the app
    And the ID is "correct"
    And the password is "incorrect"
    Then the service provider will not login
    And the message appear to tell the service provider what's wrong

  Scenario: service provider entered empty password or ID
    Given that the service provider is not logged in the app
    And the ID is " "
    And the password is " "
    Then the service provider will not login
    And the message appear to tell the service provider what's wrong
      

 

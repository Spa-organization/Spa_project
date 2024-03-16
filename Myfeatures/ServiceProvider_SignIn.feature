Feature: service provider sign in

  Scenario: Successful sign in
    Given that the service provider is not logged in the app
    And the ID is "31"
    And the password is "123"
    Then  the service provider is logged in the app successfully

  Scenario: Sign in with incorrect ID
    Given that the service provider is not logged in the app
    And the ID is "131"
    And the password is "123"
    Then the service provider will not login
    And the message appear to tell the service provider what's wrong

  Scenario: Sign in with incorrect password
    Given that the service provider is not logged in the app
    And the ID is "31"
    And the password is "1234"
    Then the service provider will not login
    And the message appear to tell the service provider what's wrong


 

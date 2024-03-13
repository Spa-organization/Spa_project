Feature: Sign Up

  Scenario: Successful sign up
    Given the client does not have an account
    When the client provides a valid ID "correct"
    When the client provides a valid name "correct"
    And a valid password "correct"
    Then their account should be created and they should be logged in automatically

  Scenario: Sign up with an already registered ID
    Given the client provides an ID that is already associated with another account "incorrect"
    When the client attempts to sign up
    Then they should be shown an error message indicating the ID is already in use

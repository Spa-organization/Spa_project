Feature: Sign Up

  Scenario: Successful sign up
    Given the client does not have an account
    When the client provides a valid ID "15"
    When the client provides a valid name "ali"
    And a valid password "1234"
    And a valid email "qsay.3w@gmail.com"
    Then their account should be created and they should be logged in automatically

  Scenario: Sign up with an already registered ID
    Given the client provides an ID that is already associated with another account "13"
    When the client attempts to sign up
    Then they should be shown an error message indicating the ID is already in use

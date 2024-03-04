Feature: Submit Feedback
  Scenario: Client Submits Feedback
    Given I am logged in as a client
    When I choose to submit feedback "msg"
    Then my feedback should be submitted to the system
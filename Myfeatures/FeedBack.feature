Feature: Submit Feedback

Scenario: Customer Submits Feedback
Given I am logged in as a customer
When I choose to submit feedback
And I enter my feedback into the feedback form
Then my feedback should be submitted to the system
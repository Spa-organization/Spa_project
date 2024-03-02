
Feature: Sending An Email To Confirm Booking
  
  
  Scenario: Booking is confirmed and confirmation email is sent
    Given The customer has completed the booking process 
    When the booking is confirmed   
    Then a confirmation email is sent to the customer's email address

  
  Scenario: Email sending fails after booking is confirmed
    When the booking is confirmed    
    But the email sending fails 
    Then a notification of the failure is logged  
    And the customer is informed about the issue through an alternative method
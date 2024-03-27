Feature: Sending An Email To Confirm Booking
  Scenario: Booking is confirmed and confirmation email is sent
    Given The customer has completed the booking process
    When the booking is confirmed  subject "subject" text  "hello"
    Then a confirmation email is sent to the customer's email address

  Scenario: Email sending fails after booking is confirmed
    When the email sending is empty
    Then the email will not send

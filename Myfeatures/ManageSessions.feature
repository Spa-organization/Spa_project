Feature: Manage Spa Sessions with Availability and Time Check


Scenario: Schedule a New massage Session with Available Time and date Slots            //ready
  Given the client is logged into their account
And the chosen massage session "time" slot is available for the selected available "date" and available employee "id"
When the client schedules a new massage session specifying the date and time
Then the session should be successfully booked, ensuring the time and date slots are reserved


  Scenario: Attempt to Schedule a massage Spa Session with Unavailable Time or date     //ready
Given the client is logged into their account
But the chosen massage session "time" slot is already booked for the selected "date" and available employee "id"
When the client attempts to schedule a new massage session for this time slot
Then the system should prevent the booking and alert about the time and date slots unavailability

 Scenario: Schedule a New sawna Session with Available Time and date Slots            //ready
   Given the client is logged into their account
  And the chosen sawna session "time" slot is available for the selected available "date" and available employee "id"
  When the client schedules a new sawna session specifying the date and time and employee
    Then the session should be successfully booked, ensuring the time and date slots are reserved

Scenario: Attempt to Schedule a New sawna Session with Unavailable Time or date        //ready
Given the client is logged into their account
 But the chosen sawna session "time" slot is already booked for the selected "date" and available employee "id"
 When the client attempts to schedule a new sawna session for this time slot
 Then the system should prevent the booking and alert about the time and date slots unavailability

Scenario: view appointments                                                      //ready
 Given the client is logged into their account
 When I choose to view the appointments
  Then the appointments should show up according to the client who log in



Scenario: Reschedule an Existing Spa Session to a New Time Slot
Given the client wants to change the time of an existing spa session
And the new chosen time slot is available
When the client reschedules the session with the new "date" and "time"
Then the session should be successfully updated, and the new time slot reserved


Scenario: Attempt to Reschedule an Existing Spa Session to an Unavailable Time Slot
Given the client wants to change the time of an existing spa session
But the new chosen "time" and "date" slots are unavailable
When the client attempts to reschedule the session to this time slot
Then the system should prevent the update and alert about the time slot unavailability

Scenario: Cancel a Spa Session
Given the client has an existing spa session they wish to cancel
When the client chooses to cancel this session
Then the session should be removed from their list of scheduled sessions, freeing up the time slot
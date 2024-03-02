Feature: Service Provider Management

  Scenario: Selecting a Service Provider
    Given a user is logged in and planning a session
    When they browse the available service providers and select one of them for the session
    Then the service provider should be booked for the session's date and time

  Scenario: Managing Service Provider Contracts
    Given a service provider is selected for a session
    When the user reviews and agrees to the contract terms
    Then the contract with the service provider should be finalized
    
  
    
    
    
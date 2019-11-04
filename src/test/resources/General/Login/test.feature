Feature: An Employee Create a new request

  Scenario: Let an employee create a new request
    Given the user have logged into the system using "User1" credentials
    When a user create a request
    Then Check request is created
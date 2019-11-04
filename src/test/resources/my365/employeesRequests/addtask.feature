Feature: An Employee Create a new task

  Scenario: Let an employee create a new task
    Given the user have logged into the system using "User3" credentials
    When User create a new task
    Then Check task created
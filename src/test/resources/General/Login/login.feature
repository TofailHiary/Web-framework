Feature: Check when user login to the system

Scenario: login to the system 
    Given I want to open home page
    And I want to login username and password
    Then Check if the user on Home page

Scenario: Invalid login to the system 
    Given I want to open home page
    Then I want to login invalid
    
Scenario: check forget password 
 Given I want to open home page
 Then Check if the password reset successfully   
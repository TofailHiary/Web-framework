Feature: KWT Social Security

  @JO @socialSecurity
  Scenario: Let an employee create a new request
    Given the user have logged into the system using "User1" credentials
    When the user navigate to the systems page
    And navigate to Benefits Types And Plans page
    #And open the settings for "Jordan Social Security - UDW" Benefits
    Then check the settings for "Jordan Social Security - UDW" Benefit

  @Test
  Scenario: smallCheck
    Given false step
    And True step

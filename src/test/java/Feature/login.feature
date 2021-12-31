Feature: User should able to login successfully

  As a user i want to login successfully in the OrangeHRM website and create a new add employee user
  So that new user can login successfully
  @test
    Scenario: User should be able to login successfully.
    Given User is on login page
    When User enter the admin details
    And Click on login button
    And User is on dashboard page
    When User hovers in PIM menu in order to add new employee
    And Enters the mandatory details
    And Click on Save Button
    And Click on Logout button
    And User enters the new user details on login page
    And Click on login
    Then User should be able to login successfully
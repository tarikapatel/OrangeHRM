Feature: Delete the Employee Name
  As a user i want to delete the registered employee name
  @test
  Scenario: User should be able to delete the registered user successfully
    Given User is on login page
    When User enter the admin details
    And Click on login button
    And user click on the PIM menu
    And enters the employee name
    And click on search button
    And click on checkbox
    And click on delete button
    Then the alert box will appear
    And clicks on OK
    Then registered user employee record should be deleted successfully
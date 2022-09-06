Feature: Human Resources Positions Functionality

  Background:
    Given User successfully logged in as Admin
    And User navigate to HRPositions Page

    Scenario: Create a new position
      When User Create a new position
      Then Success message should be displayed

      Scenario: Edit old position
        When User Edit the old position
        Then Success message should be displayed

        Scenario: Delete the position
          When User delete the position
          Then Success message should be displayed








Feature: Human Resources Positions Functionality

  Background:
    Given User successfully logged in as Admin
    And User navigate to HRPositions Page

    Scenario: User Create a new position so entry the position on HR Page
      When User Create a new position
      Then Success message should be displayed

      Scenario: User Edit old position so adjust the position on HR Page
        When User Edit the old position
        Then Success message should be displayed

        Scenario: User Delete the position so clean the position on HR Page
          When User delete the position
          Then Success message should be displayed








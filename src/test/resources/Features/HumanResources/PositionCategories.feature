Feature: Position Categories

  Background:
    Given User successfully logged in as Admin
    And navigated to Position Category page

  Scenario: User should be able to create Position Category. So the user can add new Position Categories.
    When a new position category is created
    Then the position category should appear in the list

  Scenario: User should be able to edit Position Categories so user can make changes.
    When an existing position category edited
    Then the position category should have changed

  Scenario: User should be able to delete Position Categories.
  So the user can delete the Position Categories he wants to delete.
    When an existing position category deleted
    Then the position category should be removed from the list

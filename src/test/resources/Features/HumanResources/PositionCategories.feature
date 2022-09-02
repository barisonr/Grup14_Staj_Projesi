Feature: Position Categories

  Background:
    Given User successfully logged in as Admin
    And navigated to Position Category page

  Scenario: Adding new Position Category
    When a new position category is created
    Then the position category should appear in the list

  Scenario: Editing an existing Position Category
    When an existing position category edited
    Then the position category should have changed

  Scenario: Deleting an existing Position Category
    When an existing position category deleted
    Then the position category should be removed from the list

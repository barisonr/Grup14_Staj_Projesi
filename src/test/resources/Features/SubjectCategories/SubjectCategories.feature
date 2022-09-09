Feature: Subject Categories

  Background:
    Given User successfully logged in as Admin
    And navigated to Subject Categories page

  Scenario: Adding new Subject Category
    When a new subject category is created
    Then the subject category should appear in the list

  Scenario: Editing an existing Subject Category
    When an existing subject category edited
    Then the subject category should have changed

  Scenario: Deleting an existing Subject Category
    When an existing subject category deleted
    Then the subject category should be removed from the list

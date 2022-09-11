Feature:Fields
  Background:
    Given User successfully logged in as Admin
    And navigated to Fields Page


  Scenario: User should be able to create field.
    When A new field is created
    Then the fields  should appear in the list

  Scenario:User should be able to edit fields so user can make changes.
    When edited an existing field
    Then the fields should have changed


  Scenario:User should be able to delete Fields.
    When User should be able to Fields delete
    Then the fields should be removed from the list




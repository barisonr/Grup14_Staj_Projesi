Feature: G14-11 Description Functionality

  Background:
    Given User successfully logged in as Admin
    And navigated to Discounts page

  Scenario: Add Discounts
    When User should be able to add Discounts
    Then Description success message should be displayed

  Scenario: Edit Discounts
    When User should be able to edit Discounts
    Then Description success message should be displayed

  Scenario: Delete Discounts
    When User should be able to delete Discounts
    Then  Description success message should be displayed

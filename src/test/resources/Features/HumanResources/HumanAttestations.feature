Feature: G14-2 Attestations Functionality

  Background:
  Given User successfully logged in as Admin
    And navigated to Attestations page

  Scenario: Add Attestations,
   Then User should be able to add Attestations
    And Attestation success message should be displayed

  Scenario: Edit Attestations
    Then User should be able to edit Attestations
    And Attestation success message should be displayed

  Scenario: Delete Attestations
    Then User should be able to delete Attestations
    And Attestation success message should be displayed
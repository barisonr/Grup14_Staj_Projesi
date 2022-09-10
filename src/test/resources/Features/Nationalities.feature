Feature: Nationalities Functionality

  Background:
    Given User successfully logged in as Admin
    And User navigate to Nationalities Page

    Scenario: User enter Nationality to the Nationality Page
      When User create a new Nationality
      Then Nationality transaction success message should be displayed

      Scenario: User edit Nationality to the Nationality Page
        When User edit old Nationality so can change personal data
        Then Nationality transaction success message should be displayed

        Scenario: User erase Nationality to the Nationality Page
          When User delete Nationality so can clean personal data
          Then Nationality transaction success message should be displayed

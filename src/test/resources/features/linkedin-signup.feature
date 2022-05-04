Feature: Linkedin sign up page
  Background:
    Given the home page is opened
    And the Login header button is clicked

    @requiredfield
  Scenario: Check profile pages
      When the User give Username and Password
        And the Login button is clicked
        And the Profil button is clicked
      Then the User in Profil page


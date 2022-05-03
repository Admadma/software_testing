Feature: Linkedin sign in page

  Background:
    Given the home page is opened
    And the Sign in header button is clicked

  Scenario: Check sign in required fields
    When the Sign in button is clicked
    Then the 'Please enter an email address or phone number' error message should be shown

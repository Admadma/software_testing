Feature: Linkedin sign in page

  Background:
    Given the home page is opened
    And the Sign in header button is clicked


  @requiredfield
  Scenario: Check empty Email or Phone field with empty password
    When the Sign in button is clicked
    Then the 'Please enter an email address or phone number' error message of the 'Email' field should be shown














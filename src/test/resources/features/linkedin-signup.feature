Feature: Linkedin sign up page

  Background:
    Given the home page is opened
      And the Join now header button is clicked

    @requiredfield
  Scenario: Check required fields
      Given it is scrolled down
      When the Agree & Join button is clicked
      Then the 'Please enter your email address.' error message of the 'Email' should be shown

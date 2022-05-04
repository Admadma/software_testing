Feature: Linkedin remember function
  Background:
    Given the homepage is opened
    And the Login header button is clicked

  Scenario: Login Remember
    When the User give Username and Password
      And the Login button is clicked
      And Go to logout page
      And Click remember button
      And the Login header button is clicked
    Then the 'Welcome Back' message should be shown

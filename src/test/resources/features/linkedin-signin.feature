Feature: Linkedin sign in page

  Background:
    Given the home page is opened
    And the Sign in header button is clicked


  Scenario Outline: Check the Email or Phone field with invalid parameters
    When the '<field>' is filled in with '<parameter>'
    And the 'Password' is filled in with '123456'
    And the Sign in button is clicked
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field             | parameter   | errorMessage                                                                          |
      | Email or Phone    | name        | Please enter a valid username                                                         |
      | Email or Phone    | 012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678  | Email or phone number must be between 3 to 128 characters                             |













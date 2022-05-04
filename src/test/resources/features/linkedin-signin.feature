Feature: Linkedin sign in page

  Background:
    Given the home page is opened
    And the Sign in header button is clicked

  @requiredfield
  Scenario: Check empty Email or Phone field with empty password
    When the Sign in button is clicked
    Then the 'Please enter an email address or phone number' error message of the 'Email' field should be shown

  Scenario Outline: Check the Email or Phone field with invalid parameters
    When the '<field>' is filled in with '<parameter>'
    And the 'Password' is filled in with '123456'
    And the Sign in button is clicked
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field             | parameter   | errorMessage                                                                          |
      | Email or Phone    | name        | Please enter a valid username                                                         |
      | Email or Phone    | 012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678  | Email or phone number must be between 3 to 128 characters                             |

  Scenario: Check Password field with 6 space character when Email or Phone is valid
    When the 'Email or Phone' is filled in with '+3630123123'
    And the 'Password' is filled in with '      '
    And the Sign in button is clicked
    Then the 'Please enter a password.' error message of the 'Password' field should be shown

  Scenario Outline: Check the Password field when Email or Phone is valid
    When the '<Email or Phone field>' is filled in with '<valid email or phone>'
    And the '<Password field>' is filled in with '<password parameter>'
    And the Sign in button is clicked
    Then the '<errorMessage>' error message of the '<Password field>' field should be shown

    Examples:
      | Email or Phone field | valid email or phone | Password field | password parameter | errorMessage                                                |
      | Email or Phone       | +3630123123          | Password       |                    | Please enter a password.                                    |
      | Email or Phone       | +3630123123          | Password       | asd                | The password you provided must have at least 6 characters.  |
      | Email or Phone       | +3630123123          | Password       | 012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890                | The password you provided must have at most 200 characters.  |







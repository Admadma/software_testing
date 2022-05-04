Feature: Linkedin sign in page

  Background:
    Given the home page is opened
    And the Sign in header button is clicked

  @requiredfield
  Scenario: Check empty Email or Phone field with empty password
    When the Sign in button is clicked
    Then the 'Please enter an email address or phone number' error message of the 'Email' field should be shown

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







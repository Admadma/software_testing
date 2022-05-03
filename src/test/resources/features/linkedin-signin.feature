Feature: Linkedin sign in page

  Background:
    Given the home page is opened
    And the Sign in header button is clicked


  @requiredfield
  Scenario: Check sign in required fields
    When the Sign in button is clicked
    Then the 'Please enter an email address or phone number' error message should be shown

  Scenario Outline: Check the fields with invalid parameters
    When the '<field>' is filled in with '<parameter>'
    And the Sign in button is clicked
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field             | parameter | errorMessage                                                         |
      | Email or Phone    | asd       | Please enter a valid username                                        |


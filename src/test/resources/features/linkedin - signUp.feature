Feature: Linkedin sign up page - registration

  Background:
    Given I have opened the browser
    And the sign up page is opened


  Scenario: Check required fields
    When the 'Agree & Join' button is clicked
    Then under the email field, a validation error message is appeared with Please enter your email address.
    Then under the password field, a validation error message is appeared with Please enter your password.


  Scenario Outline: Check the field with invalid parameters
    When the '<field>' field with the '<id>' id is filled in with '<parameter>'
    And the tab button is pressed in the previous field with '<id>'
    Then under the '<field>' field, a <validation error message> is appeared

    Examples:
      | field    | id            | parameter          | validation error message |
      | email    | email-address | @.com         | Please enter a valid email address.   |
      | email    | email-address | ex@mple@gmail.com  | Please enter a valid email address.   |
      | email    | email-address | example@.com       | Please enter a valid email address.   |
      | email    | email-address | example@gmailcom   | Please enter a valid email address.   |
      | email    | email-address | exa mple@gmail.com | Please enter a valid email address.   |
      | password | password      | asa              | Password must be 6 characters or more.|
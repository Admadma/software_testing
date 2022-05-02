Feature: Linkedin sign up page - registration

  Background:
    Given the sign up page is opened


  Scenario: Check required fields
    When the 'Agree & Join' button is clicked
    Then under the 'Email' field with the 'email-address' id, the 'Please enter your email address.' error message should be shown
    And under the 'Password' field with the 'password' id, the 'Please enter your password.' error message should be shown


  Scenario Outline: Check the field with invalid parameters
    When the '<field>' field with the '<id>' id is filled in with '<parameter>'
    And the tab button is pressed
    Then '<error message>' error message should be shown under the '<field> field'

    Examples:
      | field    | id            | parameter          | error message |
      | email    | email-address | @gmail.com         | Please enter a valid email address.   |
      | email    | email-address | ex@mple@gmail.com  | Please enter a valid email address.   |
      | email    | email-address | example@.com       | Please enter a valid email address.   |
      | email    | email-address | example@gmailcom   | Please enter a valid email address.   |
      | email    | email-address | exa mple@gmail.com | Please enter a valid email address.   |
      | password | password      | as df              | Password must be 6 characters or more.|
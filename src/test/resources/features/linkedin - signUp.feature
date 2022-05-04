Feature: Linkedin sign up page - registration

  Background:
    Given the sign up page is opened


  Scenario Outline: Check required fields
    When the 'Agree & Join' button is clicked
    Then under the email field, a validation error message is appeared with '<error message>' message or with '<secondary error message>' message
    Then under the password field, a validation error message is appeared with Please enter your password.

    Examples:
      | error message                      | secondary error message        |
      | Please enter your email address    | Please enter your mobile number |



  Scenario Outline: Check the field with invalid parameters
    When the '<field>' field with the '<id>' id or with the '<secondaryId>' id is filled in with '<parameter>'
    And the tab button is pressed in the previous field with '<id>' id or with '<secondaryId>' id
    Then under the '<field>' field, the <validation error message> is appeared or <secondary error message> is appeared

    Examples:
      | field    | id            | secondaryId          | parameter          | validation error message               | secondary error message |
      | email    | email-address | email-or-phone       | @.com              | Please enter a valid email address.    | Please enter a valid email address or mobile number. |
      | email    | email-address | email-or-phone       | ex@mple@gmail.com  | Please enter a valid email address.    | Please enter a valid email address or mobile number. |
      | email    | email-address | email-or-phone       | example@.com       | Please enter a valid email address.    | Please enter a valid email address or mobile number. |
      | email    | email-address | email-or-phone       | example@gmailcom   | Please enter a valid email address.    | Please enter a valid email address or mobile number. |
      | email    | email-address | email-or-phone       | exa mple@gmail.com | Please enter a valid email address.    | Please enter a valid email address or mobile number. |
      | password | password      | email-or-phone       | asa                | Password must be 6 characters or more. | Please enter a valid email address or mobile number. |
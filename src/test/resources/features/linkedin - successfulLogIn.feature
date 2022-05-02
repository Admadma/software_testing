Feature: Linkedin successful log in

  Background:
    Given the home page is opened
    And the Cookie disclaimer is closed
    And the Log in header button is clicked

  Scenario: Log in
    When we are on log in page
    And 'Email or Phone' field filled with 'exampleemail324@gmail.com'
    And 'Password' field filled with 'strongPassword'
    And 'Sing in' button is clicked
    Then the url will be 'https://www.linkedin.com/check/add-phone?country_code=hu'

    Scenario: Skip security check
      Given we are on url 'https://www.linkedin.com/check/add-phone?country_code=hu'
      And the 'Skip' button is clicked
      And the



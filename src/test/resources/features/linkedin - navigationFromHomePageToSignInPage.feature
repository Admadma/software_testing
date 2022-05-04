Feature: Linkedin navigation from home page to sign in page

  Scenario: Check link navigation
    Given I have opened the browser
    And the home page is opened
    And the Cookie disclaimer is closed
    When the Sign in header button is clicked
    Then the page url is "https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin"
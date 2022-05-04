Feature: Linkedin home page header display test

  Scenario: Check home page header elements
    Given I have opened the browser
    When the home page is opened
    Then the following elements are in the header
      |element type     | selector       | referenced page |
      |Linkedin logo    | nav > a > icon | https://www.linkedin.com/?trk=guest_homepage-basic_nav-header-logo |
      |Linkedin logo    | nav > a > icon | https://www.linkedin.com/?trk=guest_homepage-basic_nav-header-logo |
      |Linkedin logo    | nav > a > icon | https://www.linkedin.com/?trk=guest_homepage-basic_nav-header-logo |
#      |Discover icon    |          |                 |
#      |People icon      |          |                 |
#      |Learning icon    |          |                 |
#      |Jobs icon        |          |                 |
#      |'Join now' button|          |                 |
#      |'Sing in' button |          |                 |
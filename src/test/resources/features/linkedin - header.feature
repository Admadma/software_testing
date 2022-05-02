Feature: Linkedin home page header display test

  Scenario: Check home page header elements
    Given the home page is opened
    When the page loaded
    Then the following elements are in the header
      |element type     | selector       | referenced page |
      |Linkedin logo    | nav > a > icon |                 |
      |Discover icon    |          |                 |
      |People icon      |          |                 |
      |Learning icon    |          |                 |
      |Jobs icon        |          |                 |
      |'Join now' button|          |                 |
      |'Sing in' button |          |                 |
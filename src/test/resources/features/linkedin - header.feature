Feature: Linkedin home page header display test

  Scenario: Check home page header elements
    Given the home page is opened
    Then the following elements are in the header
      |element type     | selector                                   | referenced page |
#      |Linkedin logo    | body > nav > a                             | https://www.linkedin.com/?trk=guest_homepage-basic_nav-header-logo                        |
      |Discover icon    | body > nav > ul > li:nth-child(1) > a      | https://www.linkedin.com/content-hub/?trk=homepage-basic_guest_nav_menu_discover          |
      |People icon      | body > nav > ul > li:nth-child(2) > a      | https://www.linkedin.com/pub/dir/+/+?trk=homepage-basic_guest_nav_menu_people             |
#      |Learning icon    | body > nav > ul > li:nth-child(3) > a      | https://www.linkedin.com/learning/search?trk=homepage-basic_guest_nav_menu_learning       |
#      |Jobs icon        | body > nav > ul > li:nth-child(4) > a      | https://www.linkedin.com/jobs/jobs-in-debrecen?trk=homepage-basic_guest_nav_menu_jobs     |
#      |'Join now' button| body > nav > div > a.nav__button-tertiary  | https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join        |
#      |'Sing in' button | body > nav > div > a.nav__button-secondary | https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin |
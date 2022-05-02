Feature: Linkedin navigation from home page to sign in page

    Scenario: Check link navigation
      Given the home page is opened
      And the Cookie disclaimer is closed
      And the Sign in header button is clicked
      Then the page url will be 'https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin'
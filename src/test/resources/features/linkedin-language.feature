Feature: Language selector
  Background:
    Given the homepage is opened
      And the Login header button is clicked
      And the User give Username and Password
      And the Login button is clicked
      And the Profil button is clicked

  Scenario Outline: Check Languages
    When '<language>' is selected
      And Page refreshed.
    Then '<Open to>' , '<Add profile section>' and '<More>' field should be shown.

    Examples:
      | language | Open to           | Add profile section | More |
      | de_DE    | Offen für         | Profil ergänzen     | Mehr |
      | es_ES    | Tengo interés en… | Añadir sección      | Más  |
      | en_US    | Open to           | Add profile section | More |
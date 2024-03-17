Feature: Register Feature

  Scenario: TC.WEB.16-User registers with the valid value on the register page
    Given user has opened register page
    When user fills up all required fields with valid value on the register page
    And user clicks Daftar button on the register page
    Then user will be redirected to the dashboard page

  Scenario Outline: <case_id>-User does not fill up <field> when register on the register page
    Given user has opened register page
    When user fills up all required fields except <field> on the register page
    And user clicks Daftar button on the register page
    Then <message> will be received by user on the register page

    Examples: 
      | case_id   | field       | message               |
      | TC.WEB.17 | name field  | warning message name  |
      | TC.WEB.18 | email field | warning message email |

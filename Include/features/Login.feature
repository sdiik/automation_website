Feature: Login Feature

Scenario Outline: <case_id>-User <result> successfully login
    Given user on the Login page
    When user input <condition> value in the <fields> field in the Login page
    Then user <result> successfully login

    Examples: 
      | case_id    | condition  | fields   | result  |
      | TC.WEB.6   | valid			| all      | can     |
      | TC.WEB.7   | invalid		| email    | can not |
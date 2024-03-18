Feature: CRUD feature

  Background: user already login
    Given user on the Login page
    When user input valid value in the all field in the Login page
    Then user can successfully login

  @positive
  Scenario Outline: <case_id>-User can <result> product
    Given user has opened selling page
    When user input valid credential in all required fields user and select <button> in selling page
    Then user will successfully <result> product

    Examples: 
      | case_id   | button    | result  |
      | TC.WEB.11 | terbitkan | post    |
      | TC.WEB.12 | preview   | preview |

  @negative
  Scenario: TC.WEB.13-User doesn't choose one of category in kategori fields
    Given user has opened selling page
    When user input valid credential in all required except in kategori fields and click terbitkan button in selling page
    Then user will fail post new product

Feature: Web get a search products feature

  @Positive
  Scenario: TC.WEB.29-User can gets list of products based on correct keyword in the search
    Given user has opened homepage
    When user input alphabert in search field
    When user enter button in keyboard
    Then user will successfully get list of products based on the correct keywords

  @Negative
  Scenario: TC.WEB.30-User cannot gets list of products based on uncorrect keyword in the search
    Given user has opened homepage
    When user input characters in search field
    When user enter button in keyboard
    Then user will unsuccessfull get list of products based on the uncorrect keywords

Feature: Account Info Feature

  @positive
  Scenario: TC.WEB.21-User can set their Account Info from Homepage
    Given user can successfully login to the website
    And user already in the Account Info page from Homepage
    When user can fill all the required data and submit the data in the Account Info page
    Then users Account Info will be updated and user will be redirected back to Homepage

  @positive
  Scenario: TC.WEB.22-User can set their Account Info from Daftar Jual Saya page
    Given user can successfully login to the website
    And user already in the Account Info page from Daftar Jual Saya page
    When user can fill all the required data and submit the data in the Account Info page
    Then users Account Info will be updated and user will be redirected back to Homepage

  @positive
  Scenario: TC.WEB.23-User can set their Account Info first then user tries to sell a product
    Given user just registered a new account
    And user already in the Account Info page from clicking Jual button
    When user can fill all the required data and submit the data in the Account Info page
    Then users Account Info will be updated and user will be redirected to Add Product page

  @positive
  Scenario: TC.WEB.24-User tries to input the required files with empty value
    Given user can successfully login to the website
    And user already in the Account Info page from Homepage
    When user fill all the required data with empty value and submit the data in the Account Info page
    Then users Account Info will not be updated and user will be remain at Account Info page

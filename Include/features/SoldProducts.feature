Feature: Web sold product feature

	@Positive
	Scenario: TC.WEB.31-Seller gets list of product sold
    Given seller already in list product page
    When seller click sold in list category
    Then seller will successfull gets list of products sold

  @Negative
  Scenario: TC.WEB.32-Seller cannot gets list of product sold
    Given seller already in list product page
    When seller click sold in list category
    Then seller will unsuccessfull gets list of products sold

Feature: Dashboard Feature

Scenario Outline: <case_id>-User can go to the <page> page in Dashboard
	Given user successfully open website
	When user in <where> page user click <button> button on the bottom of page
	Then user will be redirect to <page> page of product listing

    Examples: 
      | case_id    | where   				 	 | button   | page    |
      | TC.WEB.8   | on the first      | next		  | next    |
      | TC.WEB.9   | not in the first  | previous | previous|


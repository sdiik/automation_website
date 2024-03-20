Feature: Notification Feature

  Scenario Outline: <case_id>-User sees <notification> on the notification pop-up
    Given user has opened Dashboard page
    When user clicks notification icon on the navigation bar
    Then user will be seen <notification> on the notification pop up
    
Examples:
    | case_id   | notification                    | 
    | TC.WEB.19 | negotiated product notification | 
    | TC.WEB.20 | published product notification  | 
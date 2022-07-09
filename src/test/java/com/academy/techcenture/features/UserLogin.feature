Feature: User login and logout functionality

  Scenario: Login and logout positive flow
    Given user is on the homepage
    When user clicks on sign in link
    And user should be navigated to login screen
    And user enters valid username and password in the credential inputs
    And user clicks on login button
    And user should be navigated to account page
    Then user should be able to see "Kevin Lee" name on top
    And user clicks on sing out link
    Then user should be navigated to login screen
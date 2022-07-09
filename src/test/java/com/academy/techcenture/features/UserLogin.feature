Feature: User login and logout functionality

  Scenario: Login and logout positive flow
    Given user is on the homepage
    When user clicks on sign in link
    And user should be navigated to login screen
    And user enters "kevinlee123@gmail.com" and "Kevin123" in the credential inputs
    And user clicks on login button
    And user should be navigated to account page
    Then user should be able to see their name on top
    And user clicks on sing out link
    Then user should be navigated to login screen
Feature: User login and logout functionality

  Background: Login feature test
    Given user is on the homepage
    When user clicks on sign in link
    And user should be navigated to login screen

    @smoke @regression
  Scenario: Login and logout positive flow
    And user enters "kevinlee123@gmail.com" and "Kevin123"
    And user clicks on login button
    And user should be navigated to account page
    Then user should be able to see "Kevin Lee" name on top
    And user clicks on sing out link
    Then user should be navigated to login screen

  Scenario Outline: User login negative scenario invalid
    And user enters "<username>" and "<password>" and clicks on login button and should see "<message>"
    @regression
    Examples:
      | username               | password | message                    |
      | kevinlee123@gmail.com  | Abc123   | Authentication failed.     |
      | kevinleegmail.com      | Hkl90    | Invalid email address.     |
      | kevinlee123@@gmail.com |          | Password is required.      |

      @smoke
      Examples:
      | username               | password | message                    |
      |                        | Bkldl123 | An email address required. |




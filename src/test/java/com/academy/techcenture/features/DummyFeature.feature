@regression
Feature: Dummy feture


  Scenario Outline: Testing tags
    Given user is in method one
    When user is in method two
    And user is in method three
    Then user is using "<username>" and "<password>"
    @all
    Examples:
      | username | password |
      | john1    | abc      |
      | john2    | abc      |
      | john3    | abc      |
      | john4    | abc      |
      | john5    | abc      |
      | john6    | abc      |

    @dummy
    Examples:
      | username | password  |
      | john7    | abc       |
      | john8    | abc       |





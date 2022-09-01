@Login
Feature: Verifying Adactin Hotel Login details

  Scenario Outline: Verifying Adactin Hotel Login with valid credentials
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"

    Examples: 
      | username  | password |
      | Neri10392 | Neri@1234 |

  Scenario Outline: Verifying Adactin Hotel Login with valid credentials
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>" with Enter Key
    Then User should Verify the after Login "Hello Neri10392!"

    Examples: 
      | username  | password |
      | Neri10392 | Neri@1234 |

  Scenario Outline: Verifying Adactin Hotel Login with valid credentials
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should verify the after Login error contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | username  | password  |
      | Neri10392 | Neri@12345 |

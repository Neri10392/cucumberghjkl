@SearchHotel
Feature: Verifying Adactin Search Hotel details

  Scenario Outline: Verifying Adactin Search Hotel by selecting all fields
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter valid "<location>","<hotels>","<roomtype>","<roomnos>","<datein>","<dateout>","<adultPerRoom>" and "<childPerRoom>"
    Then User should navigate to Select Hotel and verify success msg "Select Hotel"

    Examples: 
      | username  | password  | location | hotels      | roomtype | roomnos   | datein     | dateout    | adultPerRoom | childPerRoom |
      | Neri10392 | Neri@1234 | Brisbane | Hotel Creek | Standard | 3 - Three | 05/10/2022 | 06/10/2022 | 1 - One      | 0 - None     |

  Scenario Outline: Verifying Adactin Search Hotel by selecting mandatory fields
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter mandotory fields "<location>","<roomnos>","<datein>","<dateout>" and "<adultPerRoom>"
    Then User should navigate to Select Hotel and verify success msg "Select Hotel"

    Examples: 
      | username  | password  | location | roomnos   | datein     | dateout    | adultPerRoom |
      | Neri10392 | Neri@1234 | Brisbane | 3 - Three | 05/10/2022 | 06/10/2022 | 1 - One      |

  Scenario Outline: Verifying Adactin Date checking
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter valid "<location>","<hotels>","<roomtype>","<roomnos>","<datein>","<dateout>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify date error msg "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username  | password  | location | hotels      | roomtype | roomnos   | datein     | dateout    | adultPerRoom | childPerRoom |
      | Neri10392 | Neri@1234 | Brisbane | Hotel Creek | Standard | 3 - Three | 05/10/2022 | 06/10/1999 | 1 - One      | 0 - None     |

  Scenario Outline: Verifying Adactin Search hotel by without selecting all fields
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should click search button without entering any fields
    Then User should  verify error msg "Please Select a Location"

    Examples: 
      | username  | password  |
      | Neri10392 | Neri@1234 |

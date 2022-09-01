@SelectHotel
Feature: Verifying Adactin Select Hotel  details

  Scenario Outline: Verifying Select Hotel Name and Verify Book a Hotel
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter valid "<location>","<hotels>","<roomtype>","<roomnos>","<datein>","<dateout>","<adultPerRoom>" and "<childPerRoom>"
    Then User should navigate to Select Hotel and verify success msg "Select Hotel"
    When User should Select Hotel Name
    Then User should Verify after Select hotel name "Book A Hotel"

    Examples: 
      | username  | password  | location | hotels      | roomtype | roomnos   | datein     | dateout    | adultPerRoom | childPerRoom |
      | Neri10392 | Neri@1234 | Brisbane | Hotel Creek | Standard | 3 - Three | 05/10/2022 | 06/10/2022 | 1 - One      | 0 - None     |

  Scenario Outline: Verifying without Select Hotel Name and click continue
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter valid "<location>","<hotels>","<roomtype>","<roomnos>","<datein>","<dateout>","<adultPerRoom>" and "<childPerRoom>"
    Then User should navigate to Select Hotel and verify success msg "Select Hotel"
    When User should without select Hotel Name
    Then User should click continue after verify success msg "Please Select a Hotel"

    Examples: 
      | username  | password  | location | hotels      | roomtype | roomnos   | datein     | dateout    | adultPerRoom | childPerRoom |
      | Neri10392 | Neri@1234 | Brisbane | Hotel Creek | Standard | 3 - Three | 05/10/2022 | 06/10/2022 | 1 - One      | 0 - None     |

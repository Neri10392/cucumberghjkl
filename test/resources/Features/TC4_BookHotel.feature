@BookHotel
Feature: Verifying Adactin Book Hotel  details

  Scenario Outline: Verifying Select Hotel Name and Verify Book a Hotel
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter valid "<location>","<hotels>","<roomtype>","<roomnos>","<datein>","<dateout>","<adultPerRoom>" and "<childPerRoom>"
    Then User should navigate to Select Hotel and verify success msg "Select Hotel"
    And User should Select Hotel Name
    Then User should Verify after Select hotel name "Book A Hotel"
    And User should Book hotel "<firstName>","<lastName>" and "<address>"
      | cardNo           | cardType         | expMonth | expYear | cvv |
      | 4561237894561237 | American Express | December |    2022 | 546 |
      | 4561237894561237 | VISA             | November |    2022 | 767 |
      | 4561237894561237 | Master Card      | October  |    2022 | 455 |
      | 4561237894561237 | Other            | December |    2022 | 234 |
    Then User should navigate to Book Hotel and verify success msg "Booking Confirmation"

    Examples: 
      | username  | password  | location | hotels      | roomtype | roomnos   | datein     | dateout    | adultPerRoom | childPerRoom | firstName   | lastName | address   |
      | Neri10392 | Neri@1234 | Brisbane | Hotel Creek | Standard | 3 - Three | 05/10/2022 | 06/10/2022 | 1 - One      | 0 - None     | Neriyarasan | Lenin    | Thanjavur |

  Scenario Outline: Verifying Select Hotel Name and Verify Book a Hotel
    Given User is on the Adactin Login page
    When User should perform Login "<username>" and "<password>"
    Then User should Verify the after Login "Hello Neri10392!"
    When User should enter valid "<location>","<hotels>","<roomtype>","<roomnos>","<datein>","<dateout>","<adultPerRoom>" and "<childPerRoom>"
    Then User should navigate to Select Hotel and verify success msg "Select Hotel"
    And User should Select Hotel Name
    Then User should Verify after Select hotel name "Book A Hotel"
    And User should click Book Now without enter any fields
    Then User should verify error msg "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username  | password  | location | hotels      | roomtype | roomnos   | datein     | dateout    | adultPerRoom | childPerRoom |
      | Neri10392 | Neri@1234 | Brisbane | Hotel Creek | Standard | 3 - Three | 05/10/2022 | 06/10/2022 | 1 - One      | 0 - None     |

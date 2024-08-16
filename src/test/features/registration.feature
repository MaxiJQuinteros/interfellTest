Feature: Login test cases

  Scenario: Register user with valid information
    Given I open the app
    When I use "simbaLion" as username
    And I use "Hc12345!" as password
    And I use "Hc12345!" as re-password
    And I use "simbaLion@test.com" as email
    And press the Login button
    Then the Welcome screen is displayed

  Scenario Outline: Username field error message validation
    Given I open the app
    When I use "<username>" as username
    And I use "Hc12345!" as password
    And I use "Hc12345!" as re-password
    And I use "simbaLion@test.com" as email
    And press the Login button
    Then the error message "<message>" is displayed under the "username" field

    Examples:
      | username    | message                       |
      | simb@Lion   | Username should not contain @ |
      | ionixtester | Username exist                |
      |             | Username is required          |

  Scenario Outline: Password field error message validation
    Given I open the app
    When I use "simbaLion" as username
    And I use "<password>" as password
    And I use "Hc12345!" as re-password
    And I use "simbaLion@test.com" as email
    And press the Login button
    Then the error message "<message>" is displayed under the "password" field
    Examples:
      | password | message                           |
      | Hc123!   | Password does not have the format |
      | c123456! | Password does not have the format |
      | H123456! | Password does not have the format |
      | Hc123456 | Password does not have the format |
      | Hc++++++ | Password does not have the format |
      |          | Password is required              |

  Scenario Outline: Repeat password field error message validation
    Given I open the app
    When I use "simbaLion" as username
    And I use "Hc12345!" as password
    And I use "<repassword>" as re-password
    And I use "simbaLion@test.com" as email
    And press the Login button
    Then the error message "<message>" is displayed under the "repeat password" field
    Examples:
      | repassword | message                           |
      | c54321!H   | Password does not have the format |
      | Ca821!     | Password does not have the format |
      |            | Repeat password is required       |

  Scenario Outline: Email field error message validation
    Given I open the app
    When I use "simbaLion" as username
    And I use "Hc12345!" as password
    And I use "Hc12345!" as re-password
    And I use "<email>" as email
    And press the Login button
    Then the error message "<message>" is displayed under the "email" field
    Examples:
      | email      | message                    |
      | simba      | Please enter a valid email |
      | simba@lion | Please enter a valid email |
      | simba.com  | Please enter a valid email |

  Scenario: Register account without email
    Given I open the app
    When I use "simbaLion" as username
    And I use "Hc12345!" as password
    And I use "Hc12345!" as re-password
    And press the Login button
    And I press the confirm button
    Then the Welcome screen is displayed
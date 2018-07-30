Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to perform calculations myself
  The feature file needs to be in the "Test Resources Root" folder.

  Scenario: Addition
    Given I want to perform a calculation
    When I add 3 and 4
    Then the result should be 7

  Scenario: Subtraction
    Given I want to perform a calculation
    When I subtract 3 from 4
    Then the result should be 1

  Scenario: Multiplication
    Given I want to perform a calculation
    When I multiply 5 and 7
    Then the result should be 35

  Scenario: Division
    Given I want to perform a calculation
    When I divide 14 by 2
    Then the result should be 7

  Scenario: Power
    Given I want to perform a calculation
    When I raise 5 to the power of 4
    Then the result should be 625

  Scenario: Modulus
    Given I want to perform a calculation
    When I modulus 27 by 5
    Then the result should be 2

  Scenario Outline: Division Data Table
    Given I want to perform a data table calculation
    When I divide this <Numerator> by <Divisor>
    Then the result should be <Result>
    Examples:
      | Numerator | Divisor | Result |
      | 100       | 2       | 50     |
      | 100       | 4       | 25     |
      | 1000      | 200     | 5      |

  Scenario: The sum of a list of numbers should be calculated
    Given a list of numbers
      | 17   |
      | 42   |
      | 4711 |
    When I summarize them
    Then should I get 4770

  Scenario: A price list can be represented as price per item
    Given the price list for a donut shop
      | cocoa  | 1 |
      | donut  | 2 |
    When I order 1 cocoa and 1 donut
    Then should I pay 3

  Scenario: An international donut shop must handle currencies
    Given the price list for an international donut shop
      | product | currency | perUnitPrice |
      | cocoa   | EUR      | 1            |
      | donut   | SEK      | 18           |
    When I choose 1 cocoa and 1 donut
    Then should I pay 1 EUR and 18 SEK

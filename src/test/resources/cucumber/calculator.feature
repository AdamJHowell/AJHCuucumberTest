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
    When I divide <Numerator> by <Divisor>
    Then the result should be <Result>
    Examples:
      | Numerator | Divisor | Result |
      | 100       | 2       | 50     |
      | 100       | 4       | 25     |
      | 1000      | 200     | 5      |
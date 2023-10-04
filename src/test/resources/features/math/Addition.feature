@android
Feature: Adding numbers
  As a user
  I can add two numbers
  So that I can see the addition result

  Scenario: As a user I can add two numbers
    Given I am on the calculator page
    And a is 1
    And b is 2
    When I add a and b
    Then the total should be 3
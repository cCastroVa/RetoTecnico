# Autor: ccastrova@choucairtesting.com
@automation
Feature: Practical exercise
  As an operational trainee, I want complete the technical challenge

  Scenario: Create a new business unit
    Given he trainee is on the main page
    When he login on the page
      | user | password |
      |admin | serenity |
    When he create a Business Unit
      | name_unit | parents_unit |
      | Trainee | Operations   |
    Then he should see the Business Unit created in the page
      | name_unit |
      | Trainee |

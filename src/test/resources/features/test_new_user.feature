# Autor: ccastrova@choucairtesting.com
@test
Feature: Practical test
  As an operational trainee, I want verify user creation

  Scenario: Login
    Given the user is on the login page
    When he login on the main page
      | user   | password |
      | carlos | serenity |
    Then he should see the "Dashboard" page

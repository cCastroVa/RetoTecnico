# Autor: ccastrova@choucairtesting.com
@automation
Feature: Practical exercise
  As an operational trainee, I want complete the technical challenge
  @testA
  Scenario: Authentication in the application
    Given he trainee is on the main page
    When he login on the page
    Then he should see the "Dashboard" page
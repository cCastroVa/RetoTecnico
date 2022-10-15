# Autor: ccastrova@choucairtesting.com
@automation
Feature: Practical exercise
  As an operational trainee, I want complete the technical challenge

  @practiceA
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

  @practiceB
  Scenario: Create a new meeting
    Given he trainee logged on the page
      | user | password |
      |admin | serenity |
    When he program a new meeting
      |meeting_name|meeting_type|start_date|start_hour|location|organized_by|meeting_number|end_date  |end_hour|name_unit|reporter    |
      |introduction|General     |10/20/2022|10:00     |On Site |James Brooks|01            |10/20/2022|12:30   |Trainee  |Olivia Reed |
    And he program the attendee
      |attendee_name|attendee_type|attendee2_name|attendee2_type|attendee3_name|attendee3_type |
      |Olivia Reed  |2            |Alexis Lopez  |1             |Dylan Clark   |1              |
    Then he should see the new meeting created in the page
      |meeting_name|
      |introduction|
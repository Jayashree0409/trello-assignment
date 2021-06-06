#Author: Jayashree Eswaran
#Scenario Outline: Add a task in Trello
@CRUD @AddTask @PositiveScenario
Feature: CRUD operations via Web
  I want to add a task into list in Trello board

  Scenario: Successfully add a task into list in Trello board
    Given i open trello page "https://trello.com/"
    When i click the Log in
    And i enter my email "jaishree0409@gmail.com"
    And i click the Log in button of Atlassin
    And i enter my password "Coke@2021"
    And i click the Log in button of Trello
    Then i see the trello home page
    When i click on Boards on the header
    And i enter the exisiting board name "Trello CRUD"
    Then i should see the created trello board
    When i navigate to "To do" list
    And i click Add a card in the list
    And i enter task name "Monitor Splunk"
    And i click Add task button
    When i navigate to next "In progress" list
    And i click Add a next card in the list
    And i enter next task name "Automate the dashboard page"
    And i click Add next task button
    Then i should see the task in the list on Trello board

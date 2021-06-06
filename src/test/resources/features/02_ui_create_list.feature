#Author: Jayashree Eswaran
#Scenario Outline: Create a list in Trello
@CRUD @CreateList @PositiveScenario
Feature: CRUD operations via Web
  I want to create a list in Trello board

  Scenario: Successful creation of list in Trello board
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
    When i click on Add a list
    And i enter the name for the list "To do"
    And i click on Add list button
    And i enter the name for the list "In progress"
    And i click on Add list button
    And i enter the name for the list "Done"
    And i click on Add list button
    Then i should see the list added for my board

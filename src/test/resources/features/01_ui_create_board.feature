#Author: Jayashree Eswaran
#Scenario Outline: Create a board in Trello
@CRUD @CreateBoard @PositiveScenario
Feature: CRUD operations via Web
  I want to create a board in Trello

  Scenario: Successful creation of board in Trello
    Given i open trello page "https://trello.com/"
    When i click the Log in
    And i enter my email "jaishree0409@gmail.com"       
    And i click the Log in button of Atlassin
    And i enter my password "Coke@2021"       
    And i click the Log in button of Trello
    Then i see the trello home page
    When i click AddIcon on the trello home page
    And i click create board from the popup down menu of AddIcon
    And i enter new board title "Trello CRUD" on the popup       
    And i click on create board button
    Then i should see the board created

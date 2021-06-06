#Author: Jayashree Eswaran
#Scenario Outline: Search a invalid board in Trello
@CRUD @SearchInvalidBoard @NegativeScenario
Feature: CRUD operations via Web
  I want to search a board which is not created

  Scenario: Successfully search for the board which is not present
    Given i open trello page "https://trello.com/"
    When i click the Log in
    And i enter my email "jaishree0409@gmail.com"
    And i click the Log in button of Atlassin
    And i enter my password "Coke@2021"
    And i click the Log in button of Trello
    Then i see the trello home page
    When i click on jump to Boards on the header
    And i enter the nonexisiting board name "Trello CRUDS"
    But board is not present
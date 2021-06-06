#Author: Jayashree Eswaran
#Scenario Outline: Rest API calls on Trello Board
@CRUD 
Feature: CRUD operations via API Calls  
  
  @CreateBoard @PositiveScenario
  Scenario: Verify whether a new board trello board created using POST
    Given i create a new trello board "Trello-NewBoard"
    When i call POST http request
    Then the api call returns with a status code for create board
    And result contains a new trello board
    
  @GetBoard @PositiveScenario
  Scenario: Verify whether an existing board can be retreived using GET
    Given i retreive a existing board "60bbcf3f0a545b7d60ccace0"
    When i call GET http request
    Then the api call returns with a status code 
    And result contains an expected board
  
  @DeleteBoard @NegativeScenario
  Scenario: Verify whether a non existing board can be delete using DELETE
    Given i delete a nonexisting board "60bbb2a140d5ca3e9c3d39ed3434"
    When i call DELETE http request
    Then the api call returns with a bad request status code for delete board
    But result contains no board is present
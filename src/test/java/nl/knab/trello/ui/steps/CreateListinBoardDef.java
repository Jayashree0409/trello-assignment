package nl.knab.trello.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.knab.trello.ui.objects.CreateListonBoardPageObjects;

public class CreateListinBoardDef {
	
	private CreateListonBoardPageObjects trelloBoardPageObjects;

	public CreateListinBoardDef() {
		trelloBoardPageObjects = new CreateListonBoardPageObjects();
	}
	
	@When("i click on Boards on the header")
	public void i_click_on_Boards_on_the_header() throws Exception {
		trelloBoardPageObjects.chooseBoardinMenu();
		
		Thread.sleep(3000);
		
	}

	@When("i enter the exisiting board name {string}")
	public void i_enter_the_exisiting_board_name(String findboard) throws Exception {
		trelloBoardPageObjects.searchBoardName(findboard);
		
		Thread.sleep(2000);
	}

	@Then("i should see the created trello board")
	public void i_should_see_the_created_trello_board() throws Exception {

		Thread.sleep(2000);
		
	}

	@When("i click on Add a list")
	public void i_click_on_Add_a_list() {
		trelloBoardPageObjects.addList();
	}

	@When("i enter the name for the list {string}")
	public void i_enter_the_name_for_the_list(String listname) throws Exception {
		
		trelloBoardPageObjects.enterListName(listname);
		
		Thread.sleep(4000);
	}

	@When("i click on Add list button")
	public void i_click_on_Add_list_button() {
		trelloBoardPageObjects.addListtoBoard();
	}

	@Then("i should see the list added for my board")
	public void i_should_see_the_list_added_for_my_board() throws Exception {
		trelloBoardPageObjects.cancelListButton();
		
		Thread.sleep(6000);
	}

}

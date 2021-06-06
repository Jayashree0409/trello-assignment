package nl.knab.trello.ui.steps;

import io.cucumber.java.en.When;
import nl.knab.trello.ui.objects.SeachInvalidBoardPageObjects;

public class SearchInvalidBoardDef {
	
	private SeachInvalidBoardPageObjects trelloSearchBoardObjects;

	public SearchInvalidBoardDef() {
		trelloSearchBoardObjects = new SeachInvalidBoardPageObjects();
	}
	
	
	@When("i click on jump to Boards on the header")
	public void i_click_on_jump_to_Boards_on_the_header() throws Exception {
		
		trelloSearchBoardObjects.searchBoardinPage();
		Thread.sleep(3000);
		
	}
	
	@When("i enter the nonexisiting board name {string}")
	public void i_enter_the_nonexisiting_board_name(String boardname) throws Exception {
		trelloSearchBoardObjects.searchBoardName(boardname);
		
		Thread.sleep(2000);
	}
	
	@When("board is not present")
	public void board_is_not_present() {
		trelloSearchBoardObjects.boardMissing();
	}

}

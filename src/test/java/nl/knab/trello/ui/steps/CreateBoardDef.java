package nl.knab.trello.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.knab.trello.ui.objects.CreateBoardPageObjects;

public class CreateBoardDef {

	private CreateBoardPageObjects trelloPageObjects;

	public CreateBoardDef() {
		trelloPageObjects = new CreateBoardPageObjects();
	}

	@Given("i open trello page {string}")
	public void i_open_trello_page(String url) {
		trelloPageObjects.trelloPage(url);

	}

	@When("i click the Log in")
	public void i_click_the_Log_in() throws Exception {
		trelloPageObjects.clickLogin();
		Thread.sleep(4000);

	}

	@When("i enter my email {string}")
	public void i_enter_my_email(String email) {

		trelloPageObjects.loginMail(email);
	}

	@When("i click the Log in button of Atlassin")
	public void i_click_the_Log_in_button_of_Atlassin() throws Exception {
		
		trelloPageObjects.loginButtonAtlassin();
		Thread.sleep(4000);
		
	}

	@When("i enter my password {string}")
	public void i_enter_my_password(String pswd) {
		trelloPageObjects.password(pswd);

	}

	@When("i click the Log in button of Trello")
	public void i_click_the_Log_in_button_of_Trello() throws Exception {
		trelloPageObjects.loginToTrello();
		
		Thread.sleep(8000);
	}

	@Then("i see the trello home page")
	public void i_see_the_trello_home_page() throws Exception {
		
		trelloPageObjects.trelloHomePageVerification();
		
		Thread.sleep(2000);
		
	}

	@When("i click AddIcon on the trello home page")
	public void i_click_AddIcon_on_the_trello_home_page() {
		trelloPageObjects.addHeaderCreateButton();
	}

	@When("i click create board from the popup down menu of AddIcon")
	public void i_click_create_board_from_the_popup_down_menu_of_AddIcon() throws Exception {
		trelloPageObjects.createBoard();
		
		Thread.sleep(2000);
	}

	@When("i enter new board title {string} on the popup")
	public void i_enter_new_board_title_on_the_popup(String boardname) throws Exception {
		trelloPageObjects.addNameBoard(boardname);
		
		Thread.sleep(2000);
	}

	@When("i click on create board button")
	public void i_click_on_create_board_button() throws Exception {
		trelloPageObjects.createBoardButton();
		
		Thread.sleep(2000);
		
	}

	@Then("i should see the board created")
	public void i_should_see_the_board_created() throws Exception {
		
		Thread.sleep(4000);
	}

}

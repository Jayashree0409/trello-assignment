package nl.knab.trello.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.knab.trello.ui.objects.AddTaskinListPageObjects;

public class AddTaskinListDef {
	
	private AddTaskinListPageObjects trelloAddTaskPageObjects;

	public AddTaskinListDef() {
		trelloAddTaskPageObjects = new AddTaskinListPageObjects();
	}
	

	@When("i navigate to {string} list")
	public void i_navigate_to_list(String listname) throws Exception {
		
	trelloAddTaskPageObjects.listNameBoard(listname);
		
	}

	@When("i click Add a card in the list")
	public void i_click_Add_a_card_in_the_list() {
		trelloAddTaskPageObjects.addCard();
	}

	@When("i enter task name {string}")
	public void i_enter_task_name(String cardname) throws Exception {
		trelloAddTaskPageObjects.addCardNameList(cardname);
		
		Thread.sleep(1000);
	}

	@When("i click Add task button")
	public void i_click_Add_task_button() throws Exception {
		trelloAddTaskPageObjects.addCardButton();
		
		Thread.sleep(2000);
		
		trelloAddTaskPageObjects.cancelCardButton();
		
	}
	
	@When("i navigate to next {string} list")
	public void i_navigate_to_next_list(String nextlistname) throws Exception {
		
	trelloAddTaskPageObjects.nextlistNameBoard(nextlistname);
	
	Thread.sleep(1000);
		
	}
	
	@When("i click Add a next card in the list")
	public void i_click_Add_a_next_card_in_the_list() {
		trelloAddTaskPageObjects.addNextCard();
	}

	@When("i enter next task name {string}")
	public void i_enter_next_task_name(String nextcardname) throws Exception {
		trelloAddTaskPageObjects.addNextCardNameList(nextcardname);
		
		Thread.sleep(1000);
	}
	
	@When("i click Add next task button")
	public void i_click_Add_next_task_button() {
		trelloAddTaskPageObjects.addNextCardButton();
	}

	@Then("i should see the task in the list on Trello board")
	public void i_should_see_the_task_in_the_list_on_Trello_board() throws Exception {
		
		trelloAddTaskPageObjects.cancelNextCardButton();
		
		Thread.sleep(3000);
		
	}
}

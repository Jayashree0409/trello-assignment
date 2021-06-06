package nl.knab.trello.api.steps;

import static nl.knab.trello.utils.TrelloConstants.DELETE_OBJECT_URL;
import static nl.knab.trello.utils.TrelloConstants.KEY;
import static nl.knab.trello.utils.TrelloConstants.TOKEN;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class DeleteBoardAPIDef {
	
	private static Logger Log = Logger.getLogger(DeleteBoardAPIDef.class.getName());
	

	private HttpResponse<String> response = null;

	private String trelloBoardId = null;

	
	@Given("i delete a nonexisting board {string}")
	public void i_delete_a_nonexisting_board(String boardId) {
		trelloBoardId = boardId;
		
		Log.info("Get the invalid board id :  " + boardId);
		
	}
	
	@When("i call DELETE http request")
	public void i_call_DELETE_http_request() throws Exception {
		
		response = Unirest.get(DELETE_OBJECT_URL)
				.routeParam("id", trelloBoardId)
				.queryString("key", KEY)
				.queryString("token", TOKEN)
				.asString();		
		
		Log.info("Invalid response from API :- " + response.getBody());
		Log.info("response code :- " + response.getStatus());
		Log.info("response error :- " +response.getStatusText());
	}

	@Then("the api call returns with a bad request status code for delete board")
	public void the_api_call_returns_with_a_bad_request_status_code_for_delete_board() {
		
		Assert.assertTrue(response.getStatus() == 400);
		Assert.assertTrue(response.getStatusText().equals("Bad Request"));
		
	}

	@Then("result contains no board is present")
	public void result_contains_no_board_is_present() {		
		Assert.assertEquals("invalid id", response.getBody());
		
		Log.info("Retreived board to delete is not present");

	}
}

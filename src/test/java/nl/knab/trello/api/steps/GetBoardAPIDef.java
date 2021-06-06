package nl.knab.trello.api.steps;

import static nl.knab.trello.utils.TrelloConstants.GET_OBJECT_URL;
import static nl.knab.trello.utils.TrelloConstants.KEY;
import static nl.knab.trello.utils.TrelloConstants.TOKEN;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import nl.knab.trello.utils.TrelloHelper;

public class GetBoardAPIDef {	
	
	private static Logger Log = Logger.getLogger(GetBoardAPIDef.class.getName());

	private HttpResponse<String> response = null;

	private Map<String, Object> responseJsonObjectMap = null;

	private String trelloBoardId = null;
	
	@Given("i retreive a existing board {string}")
	public void i_retreive_a_existing_board(String boardId) {
		trelloBoardId = boardId;
		
		Log.info("Get the detail of board " + boardId);
	}

	@When("i call GET http request")
	public void i_call_GET_http_request() throws Exception {

		response = Unirest.get(GET_OBJECT_URL)
				.routeParam("id", trelloBoardId)
				.queryString("key", KEY)
				.queryString("token", TOKEN)
				.asString();

		responseJsonObjectMap = TrelloHelper.createResponseJsonObjectMap(response);			
		
	}

	@Then("the api call returns with a status code")
	public void the_api_call_returns_with_a_status_code() {
		
		Assert.assertTrue(response.getStatus() == 200);

	}

	@Then("result contains an expected board")
	public void result_contains_an_expected_board() {

		Assert.assertEquals("trello-api", responseJsonObjectMap.get("name"));
		
		Log.info(responseJsonObjectMap.get("name") + " Board is Successfully retreived");

	}

}

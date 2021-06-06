package nl.knab.trello.api.steps;

import static nl.knab.trello.utils.TrelloConstants.CREATE_OBJECT_URL;
import static nl.knab.trello.utils.TrelloConstants.KEY;
import static nl.knab.trello.utils.TrelloConstants.TOKEN;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import nl.knab.trello.utils.TrelloHelper;

public class CreateBoardAPIDef {
	
	private static Logger Log = Logger.getLogger(CreateBoardAPIDef.class.getName());
	
	private HttpResponse<String> response = null;

	private Map<String, Object> responseJsonObjectMap = null;

	private String trelloBoardName = null;
	
	@Before
	public void init() {
		Unirest.config().enableCookieManagement(false);
	}
	
	
	@Given("i create a new trello board {string}")
	public void i_create_a_new_trello_board(String boardName) {
		trelloBoardName = boardName;
		
		Log.info("Create the new board via API call " + boardName);
	}

	@When("i call POST http request")
	public void i_call_POST_http_request() throws JsonParseException, JsonMappingException, IOException {
		response = Unirest.post(CREATE_OBJECT_URL)
                .routeParam("object", "boards")
                .queryString("name", trelloBoardName)
				.queryString("key", KEY)
				.queryString("token", TOKEN)
				.asString();
	   
		responseJsonObjectMap = TrelloHelper.createResponseJsonObjectMap(response);		
		
	}
	
	
	@Then("the api call returns with a status code for create board")
	public void the_api_call_returns_with_a_status_code_for_create_board() {

		Assert.assertTrue(response.getStatus() == 200);

	}

	@Then("result contains a new trello board")
	public void result_contains_a_new_trello_board() {

		Assert.assertEquals(trelloBoardName, responseJsonObjectMap.get("name"));
		
		Log.info(responseJsonObjectMap.get("name") + " Board successfully created via API call");

	}


}

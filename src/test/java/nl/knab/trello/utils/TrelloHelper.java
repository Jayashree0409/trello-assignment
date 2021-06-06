package nl.knab.trello.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import kong.unirest.HttpResponse;

public class TrelloHelper {		
	private static Logger Log = Logger.getLogger(TrelloHelper.class.getName());

	public static Map<String, Object> createResponseJsonObjectMap(HttpResponse<String> response)
			throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		Map<String, Object> map = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
		});
		
		Log.info("Response Json  :"+mapper.writeValueAsString(mapper.readTree(response.getBody())));
		return map;
	}	
	
	}

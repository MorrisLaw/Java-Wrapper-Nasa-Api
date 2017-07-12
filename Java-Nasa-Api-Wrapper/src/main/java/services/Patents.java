package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This service provides data for Nasa patents.
 * @author Jeremy L. Morris
 *
 */
public class Patents {

	/**
	 * 
	 * @return JSON object containing nasa patent information based on a provided String query and int limit.
	 */
	public static JSONObject getData(String query, int limit) {
		String responseBody = null;
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.getResponse(ApiRequest.patentsService + "query=" + query + "&limit=" + limit);
		} catch(Exception e) {
			System.err.println(e);
		}
		// Get json object containing the http response result.
		try{
			json = (JSONObject) parser.parse(responseBody);
		} catch(Exception e) {
			System.err.print(e);
		}
		return json;
	}
}

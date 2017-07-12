package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NeoFeed {
	
	/**
	 * 
	 * @return JSON object containing neo information based on a date range. Provided start_date and end_date should be in String "yyyy-MM-dd" format.
	 */
	public static JSONObject getData(String startDate, String endDate) {
		String responseBody = null;
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.getResponse(ApiRequest.neoServiceFeed + "start_date=" + startDate + "&end_date=" + endDate);
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

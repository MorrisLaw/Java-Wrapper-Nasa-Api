package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NeoLookup {

	/**
	 * 
	 * @return JSON object containing neo information.
	 */
	public static JSONObject getData() {
		String responseBody = null;
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.getData(ApiRequest.neoServiceBrowse);
		} catch(Exception e) {
			System.err.println(e);
		}
		
		try{
			json = (JSONObject) parser.parse(responseBody);
		} catch(Exception e) {
			System.err.print(e);
		}
		return json;
	}
	
}

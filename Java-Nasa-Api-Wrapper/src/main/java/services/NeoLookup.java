package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NeoLookup {
	
	/**
	 * 
	 * @return JSON object containing neo information based on a provided neo reference id.
	 */
	public static JSONObject getData(int neoReferenceId) {
		String responseBody = null;
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.getResponse(ApiRequest.neoServiceLookup + String.valueOf(neoReferenceId));
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

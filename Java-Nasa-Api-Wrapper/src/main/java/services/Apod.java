package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Apod {
	
	private static final JSONObject apodJsonObj = getApodData();
	
	/**
	 * 
	 * @return JSON object containing APOD information.
	 */
	public static JSONObject getApodData() {
		String responseBody = null;
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.getData(ApiRequest.apodService);
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
	
	/**
	 * 
	 * @return Date of the Apod as a String.
	 */
	public static String date() {
		return apodJsonObj.get("date").toString();
	}
	
	/**
	 * 
	 * @return explanation of the Apod as a String.
	 */
	public static String explanation() {
		return apodJsonObj.get("explanation").toString();
	}
	
	/**
	 * 
	 * @return the url of the High Definition image as a String.
	 */
	public static String hdurl() {
		return apodJsonObj.get("hdurl").toString();
	}
	
	/**
	 * 
	 * @return the media type of the Apod as a String.
	 */
    	public static String media_type() {
        	return apodJsonObj.get("media_type").toString();
    	}
	
    	/**
     	* 
     	* @return
     	*/
	public static String service_version() {
		return apodJsonObj.get("service_version").toString();
	}
	
	/**
	 * 
	 * @return the title as a String.
	 */
	public static String title() {
    		return apodJsonObj.get("title").toString();
	}

	/**
	 * 
	 * @return the url of the standard definition image as a String.
	 */
	public static String url() {
		return apodJsonObj.get("url").toString();
	}
}

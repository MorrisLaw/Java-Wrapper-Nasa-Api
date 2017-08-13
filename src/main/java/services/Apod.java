package services;

import java.time.LocalDate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.*;

/**
 * 
 * @author Jeremy L. Morris
 *
 */
public class Apod {
	
	private static final Gson gson = new Gson();
//	private static final JSONObject apodJsonObj = getData();
	
//	/**
//	 * 
//	 * @return JSON object containing APOD information.
//	 */
//	public static JSONObject getData() {
//		String responseBody = null;
//		JSONObject json = new JSONObject();
//		JSONParser parser = new JSONParser();
//		
//		try {
//			// String object of key value pairs.
//			responseBody = ApiRequest.getResponse(ApiRequest.apodService);
//		} catch(Exception e) {
//			System.err.println(e);
//		}
//		
//		try{
//			json = (JSONObject) parser.parse(responseBody);
//		} catch(Exception e) {
//			System.err.print(e);
//		}
//		return json;
//	}
	
	public static void main(String[] args) {
		getData();
	}
	
	public static JsonObject getData() {
		String responseBody = null;
		try {
			responseBody = ApiRequest.getResponse(ApiRequest.apodService);
		} catch(Exception e) {
			System.err.println(e);
		}
		JsonElement responseBodyElem = new JsonPrimitive(responseBody);
		JsonObject jsonObj = responseBodyElem.getAsJsonObject();
		System.out.println(jsonObj);
		return jsonObj;
	}
//	/**
//	 * 
//	 * @return LocalDate object of the Apod date, in yyyy-MM-dd format.
//	 */
//	public static LocalDate date() {
//		final String date = apodJsonObj.get("date").toString();
//		final LocalDate dateObj = LocalDate.parse(date);
//		return dateObj;
//	}
//	
//	/**
//	 * 
//	 * @return explanation of the Apod as a String.
//	 */
//	public static String explanation() {
//		return apodJsonObj.get("explanation").toString();
//	}
//	
//	/**
//	 * 
//	 * @return the url of the High Definition image as a String.
//	 */
//	public static boolean hdurl() {
//		return Boolean.parseBoolean(apodJsonObj.get("hdurl").toString());
//	}
//	
//	/**
//	 * 
//	 * @return the media type of the Apod as a String.
//	 */
//	public static String media_type() {
//    	return apodJsonObj.get("media_type").toString();
//	}
//
//	/**
// 	 * 
// 	 * @return version number of Apod service.
// 	 */
//	public static String service_version() {
//		return apodJsonObj.get("service_version").toString();
//	}
//	
//	/**
//	 * 
//	 * @return the title as a String.
//	 */
//	public static String title() {
//    		return apodJsonObj.get("title").toString();
//	}
//
//	/**
//	 * 
//	 * @return the url of the standard definition image as a String.
//	 */
//	public static String url() {
//		return apodJsonObj.get("url").toString();
//	}
}

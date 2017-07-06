package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NeoBrowse {

	private static final JSONObject neoBrowseJsonObj = getData();
	
	/**
	 * 
	 * @return JSON object containing APOD information.
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
	
	public static JSONObject links() {
		final JSONObject links = (JSONObject) neoBrowseJsonObj.get("link");
		return links;
	}
	
	/**
	 * 
	 * @return the next link of neo browse.
	 */
	public static String linkNext() {
		return links().get("next").toString();
	}
	
	/**
	 * 
	 * @return the current link of neo browse.
	 */
	public static String linkSelf() {
		return links().get("self").toString();
	}
	
	/**
	 * 
	 * @return page json object.
	 */
	public static JSONObject page() {
		final JSONObject page = (JSONObject) neoBrowseJsonObj.get("page");
		return page;
	}
	/**
	 * 
	 * @return the pages current size, number of neo json objects on this page.
	 */
	public static int pageSize() {
		return Integer.parseInt(page().get("size").toString());
	}
	
	/**
	 * 
	 * @return the total number of neo elements.
	 */
	public static int totalElements() {
		return Integer.parseInt(page().get("total_elements").toString());
	}
	
	/**
	 * 
	 * @return the total number of pages.
	 */
	public static int totalPages() {
		return Integer.parseInt(page().get("total_pages").toString());
	}
	
	/**
	 * 
	 * @return the current page number.
	 */
	public static int pageNumber() {
		return Integer.parseInt(page().get("number").toString());
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}

package services;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NeoBrowse {

	private static final JSONObject neoBrowseJsonObj = getData();
	private static final JSONObject page = (JSONObject) neoBrowseJsonObj.get("page");
	private static final JSONObject links = (JSONObject) neoBrowseJsonObj.get("link");
	private static final JSONArray neo = (JSONArray) neoBrowseJsonObj.get("near_earth_objects");
	
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
	
	/**
	 * 
	 * @return links json object.
	 */
	public static JSONObject links() {
		return NeoBrowse.links;
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
		return NeoBrowse.page;
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
	
	/**
	 * 
	 * @return LinkedHashSet of NEO json objects.
	 */
	public static Set<JSONObject> nearEarthObject() {
		Set<JSONObject> neoSet = new LinkedHashSet<>();
		JSONArray neo = NeoBrowse.neo;
		// Populate set with NEO objects.
		for(int i = 0; i < neo.size(); i++) {
			JSONObject json = (JSONObject) neo.get(i);
			neoSet.add(json);
		}
		return neoSet;
	}
	
	/**
	 * 
	 * @return LinkedHashSet of NEO links.
	 */
	public static Set<String> neoLinks() {
		Set<String> neoLinksSet = new LinkedHashSet<>();
		// Add links.
		Iterator<JSONObject> iter = nearEarthObject().iterator();
		while(iter.hasNext()) {
			JSONObject json = (JSONObject) iter.next(); // Near Earth Object.
			JSONObject links = (JSONObject) json.get("links"); // Links Object.
			neoLinksSet.add(links.get("self").toString()); // Add link, as String.
		}
		return neoLinksSet;
	}
}

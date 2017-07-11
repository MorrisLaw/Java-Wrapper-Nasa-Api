package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NeoBrowse {

	private static final JSONObject neoBrowseJsonObj = getData();
	private static final JSONObject page = (JSONObject) neoBrowseJsonObj.get("page");
	private static final JSONObject pageLinks = (JSONObject) neoBrowseJsonObj.get("links");
	private static final JSONArray neo = (JSONArray) neoBrowseJsonObj.get("near_earth_objects");
	
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
	
	/**
	 * 
	 * @return the next link of neo browse.
	 */
	public static String linkNext() {
		return pageLinks.get("next").toString();
	}
	
	/**
	 * 
	 * @return the current link of neo browse.
	 */
	public static String linkSelf() {
		return pageLinks.get("self").toString();
	}
	
	/**
	 * 
	 * @return the pages current size, number of neo json objects on this page.
	 */
	public static int pageSize() {
		return Integer.parseInt(page.get("size").toString());
	}
	
	/**
	 * 
	 * @return the total number of neo elements.
	 */
	public static int totalElements() {
		return Integer.parseInt(page.get("total_elements").toString());
	}
	
	/**
	 * 
	 * @return the total number of pages.
	 */
	public static int totalPages() {
		return Integer.parseInt(page.get("total_pages").toString());
	}
	
	/**
	 * 
	 * @return the current page number.
	 */
	public static int pageNumber() {
		return Integer.parseInt(page.get("number").toString());
	}
	
	/**
	 * 
	 * @return ArrayList of NEO json objects.
	 */
	public static List<JSONObject> nearEarthObject() {
		List<JSONObject> neoList = new ArrayList<>();
		JSONArray neoArray = neo;
		for (int i = 0; i < neoArray.size(); i++) {
			JSONObject neoObj = (JSONObject) neoArray.get(i);
			neoList.add(neoObj);
		}
		return neoList;
	}
	
	/**
	 * 
	 * @return an ArrayList of NEO links.
	 */
	public static List<String> neoLinks() {
		List<String> neoLinks = new ArrayList<>();
		for (int i = 0; i < nearEarthObject().size(); i++) {
			final JSONObject neoObj = (JSONObject) nearEarthObject().get(i);
			final JSONObject links = (JSONObject) neoObj.get("links");
			final String linkSelf = links.get("self").toString();
			neoLinks.add(linkSelf);
		}
		return neoLinks;
	}
	
	/**
	 * 
	 * @return an ArrayList of NEO Reference IDs.
	 */
	public static List<String> referenceIds() {
		List<String> refIds = new ArrayList<>();
		for (int i = 0; i < nearEarthObject().size(); i++) {
			final JSONObject refIdJson = (JSONObject) nearEarthObject().get(i);
			final String refId = refIdJson.get("neo_reference_id").toString();
			refIds.add(refId);
		}
		return refIds;
	}
	
	/**
	 * 
	 * @return an ArrayList of names, as strings.
	 */
	public static List<String> names() {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < nearEarthObject().size(); i++) {
			final JSONObject json = (JSONObject) nearEarthObject().get(i);
			final String name = json.get("name").toString();
			names.add(name);
		}
		return names;
	}
	
	/**
	 * 
	 * @return an ArrayList of Nasa jpl url's.
	 */
	public static List<String> nasaJplUrls() {
		List<String> urls = new ArrayList<>();
		for (int i = 0; i < nearEarthObject().size(); i++) {
			final JSONObject json = (JSONObject) nearEarthObject().get(i);
			final String url = json.get("nasa_jpl_url").toString();
			urls.add(url);
		}
		return urls;
	}
	
	/**
	 * 
	 * @return an arraylist of absolute_magnitude_h values.
	 */
	public static List<String> absoluteMagnitudes() {
		List<String> absMagnitudes = new ArrayList<>();
		for (int i = 0; i < nearEarthObject().size(); i++) {
			final JSONObject json = (JSONObject) nearEarthObject().get(i);
			final String absMags = json.get("absolute_magnitude_h").toString();
			absMagnitudes.add(absMags);
		}
		return absMagnitudes;
	}
	
//	public static void main(String[] args) {
//		List<String> test = absoluteMagnitudes();
//		for (int i = 0; i < test.size(); i++) {
//			System.out.println(test.get(i));
//		}
//	}
}

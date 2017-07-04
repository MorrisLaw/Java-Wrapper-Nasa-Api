package services;

import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 
 * @author Jeremy L. Morris
 *
 */
public class EpicNaturalImages {

	private static final JSONArray epicJsonObj = getData();
	
	/**
	 * 
	 * @return JSONArray containing data from EPIC Natural Images API.
	 */
	public static JSONArray getData() {
		String responseBody = null;
		JSONArray json = new JSONArray();
		JSONParser parser = new JSONParser();
		
		try {
			responseBody = ApiRequest.getData(ApiRequest.epicServiceNaturalImages);
		} catch(Exception e) {
			System.err.print(e);
		}
		try {
			json = (JSONArray) parser.parse(responseBody);
		} catch(Exception e) {
			System.err.print(e);
		}
		return json;
	}
	
	/**
	 * 
	 * @return an ArrayList of Strings containing the names of natural images.
	 */
	public static List<String> images() {
		List<String> images = new ArrayList<>();
		JSONObject json = null;
		String image = null;
		// Iterate through an JSONArray of JSONObjects and store each image string into an ArrayList.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			image = json.get("image").toString();
			images.add(image);
		}
		return images;
	}
	
	public static List<String> captions() {
		List<String> captions = new ArrayList<>();
		JSONObject json = null;
		String caption = null;
		// Iterate through an JSONArray of JSONObjects and store each caption string into an ArrayList;
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			caption = json.get("caption").toString();
			captions.add(caption);
		}
		return captions;
	}
	
//	public static double[] centroid_coordinates() {
//		double[] coord = new double[2];
//		
//		return coord;
//	}
	
//	public static double[][] dscovr_j2000_positions() {
//		
//	}
//	
//	public static double[][] lunar_j2000_positions() {
//		
//	}
//	
//	public static double[][] sun_j2000_positions() {
//		
//	}
//	
//	public static double[][] attitude_quaternions() {
//		
//	}
//	
//	public static LocalDate dates() {
//		
//	}
	
	public static List<String> coordinates() {
		List<String> coordinates = new ArrayList<>();
		JSONObject json = null;
		String coordinate = null;
		// Iterate through an JSONArray of JSONObjects and store each caption string into an ArrayList;
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			coordinate = json.get("coords").toString();
			coordinates.add(coordinate);
		}
		return coordinates;
	}
	
	public static void main(String[] args) {
//		System.out.println(images());
//		System.out.println(captions());
//		System.out.println(coordinates());
	}
	
}

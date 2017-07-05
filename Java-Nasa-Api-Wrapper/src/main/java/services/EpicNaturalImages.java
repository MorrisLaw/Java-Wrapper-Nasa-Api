package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		// Iterate through a JSONArray of JSONObjects and store each image string into an ArrayList.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			image = json.get("image").toString();
			images.add(image);
		}
		return images;
	}
	
	/**
	 * 
	 * @return An arraylist of Strings, of which are captions for the EPIC Natural Image.
	 */
	public static List<String> captions() {
		List<String> captions = new ArrayList<>();
		JSONObject json = null;
		String caption = null;
		// Iterate through a JSONArray of JSONObjects and store each caption string into an ArrayList;
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			caption = json.get("caption").toString();
			captions.add(caption);
		}
		return captions;
	}
	
	/**
	 * 
	 * @return An arraylist of double array objects containing the centroid_coordinates for the EPIC natural image.
	 */
	public static List<double[]> centroid_coordinates() {
		List<double[]> centroid_coords = new ArrayList<>();
		JSONObject json = null;
		double latitude = 0;
		double longitude = 0;
		double[] coordinates = new double[2];
		// Iterate through a JSONArray of JSONObjects and store centroid_coordinates in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save latitude and longitude as doubles.
			JSONObject centroid_coord_pair = (JSONObject) json.get("centroid_coordinates");
			latitude = Double.parseDouble(centroid_coord_pair.get("lat").toString());
			longitude = Double.parseDouble(centroid_coord_pair.get("lon").toString());
			// Populate the double array with the two coordinates, then add to the arraylist of double arrays.
			coordinates[0] = latitude;
			coordinates[1] = longitude;
			centroid_coords.add(coordinates);
			// Need to clear out the array by re-initializing it to null array of size 2. Otherwise, values won't change.
			coordinates = new double[2];
		}
		return centroid_coords;
	}
	
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
	public static List<String> dates() {
		List<String> dates = new ArrayList<>();
		JSONObject json = null;
		String date = null;
		// Iterate through an JSONArray of JSONObjects and store each date object into an ArrayList.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			date = json.get("date").toString();
			dates.add(date);
		}
		return dates;
	}
	
	public static List<String> coordinates() {
		List<String> coordinates = new ArrayList<>();
		JSONObject json = null;
		String coordinate = null;
		// Iterate through an JSONArray of JSONObjects and store each caption string into an ArrayList.
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
//		System.out.println(dates());
      System.out.println(centroid_coordinates());
	}
	
}

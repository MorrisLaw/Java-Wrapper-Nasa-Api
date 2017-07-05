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
		List<double[]> centroidCoords = new ArrayList<>();
		JSONObject json = null;
		double latitude = 0;
		double longitude = 0;
		double[] coordinates = new double[2];
		// Iterate through a JSONArray of JSONObjects and store centroid_coordinates in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save latitude and longitude as doubles.
			JSONObject centroidCoordPair = (JSONObject) json.get("centroid_coordinates");
			latitude = Double.parseDouble(centroidCoordPair.get("lat").toString());
			longitude = Double.parseDouble(centroidCoordPair.get("lon").toString());
			// Populate the double array with the two coordinates, then add to the arraylist of double arrays.
			coordinates[0] = latitude;
			coordinates[1] = longitude;
			centroidCoords.add(coordinates);
			// Need to clear out the array by re-initializing it to null array of size 2. Otherwise, values won't change.
			coordinates = new double[2];
		}
		return centroidCoords;
	}
	
	/**
	 * 
	 * @return An arraylist of double array objects containing the position, x,y,z coordinates, of dscovr j2000.
	 */
	public static List<double[]> dscovr_j2000_positions() {
		List<double[]> dscovr = new ArrayList<>();
		JSONObject json = null;
		// Coordinates for a given position.
		double x = 0;
		double y = 0;
		double z = 0;
		double[] positions = new double[3];
		// Iterate through a JSONArray of JSONObjects and store dscovr j2000 position coordinates in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save x,y and z coordinates, and store as doubles.
			JSONObject dscovrPosition = (JSONObject) json.get("dscovr_j2000_position");
			x = Double.parseDouble(dscovrPosition.get("x").toString());
			y = Double.parseDouble(dscovrPosition.get("y").toString());
			z = Double.parseDouble(dscovrPosition.get("z").toString());
			// Add position array to arraylist.
			positions[0] = x;
			positions[1] = y;
			positions[2] = z;
			dscovr.add(positions);
			// Need to clear out the array by re-initializin it to null array of size 3. Otherwise, values won't change.
			positions = new double[3];
		}
		return dscovr;
	}
	
//	public static double[] lunar_j2000_positions() {
//		
//	}
//	
//	public static double[] sun_j2000_positions() {
//		
//	}
//	
//	public static double[] attitude_quaternions() {
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
//      System.out.println(centroid_coordinates());
//      System.out.println(dscovr_j2000_positions());
//      for (int i = 0; i < dscovr_j2000_positions().size(); i++) {
//    	  System.out.println(Arrays.toString(dscovr_j2000_positions().get(i)));
//      }
	}
	
}

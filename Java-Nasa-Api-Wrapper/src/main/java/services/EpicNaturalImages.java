package services;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Get and returns a json array from the EPIC Natural Images API service as well as options 
 * for getting individual fields as lists of the original type.
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
	public static List<double[]> centroidCoordinates() {
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
	public static List<double[]> dscovrJ2000Positions() {
		List<double[]> dscovr = new ArrayList<>();
		JSONObject json = null;
		// Coordinates for a given position.
		double x = 0;
		double y = 0;
		double z = 0;
		double[] position = new double[3];
		// Iterate through a JSONArray of JSONObjects and store dscovr j2000 position coordinates in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save x,y and z coordinates, and store as doubles.
			JSONObject dscovrPosition = (JSONObject) json.get("dscovr_j2000_position");
			x = Double.parseDouble(dscovrPosition.get("x").toString());
			y = Double.parseDouble(dscovrPosition.get("y").toString());
			z = Double.parseDouble(dscovrPosition.get("z").toString());
			// Add position array to arraylist.
			position[0] = x;
			position[1] = y;
			position[2] = z;
			dscovr.add(position);
			// Need to clear out the array by re-initializing it to null array of size 3. Otherwise, values won't change.
			position = new double[3];
		}
		return dscovr;
	}
	
	/**
	 * 
	 * @return An arraylist of double array objects containing the position, x,y,z coordinates, of lunar j2000.
	 */
	public static List<double[]> lunarJ2000Positions() {
		List<double[]> lunar = new ArrayList<>();
		JSONObject json = null;
		// Coordinates for a given position.
		double x = 0;
		double y = 0;
		double z = 0;
		double[] position = new double[3];
		// Iterate through a JSONArray of JSONObjects and store lunar j2000 position coordinates in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save x,y and z coordinates, and store as doubles.
			JSONObject lunarPosition = (JSONObject) json.get("lunar_j2000_position");
			x = Double.parseDouble(lunarPosition.get("x").toString());
			y = Double.parseDouble(lunarPosition.get("y").toString());
			z = Double.parseDouble(lunarPosition.get("z").toString());
			// Add position array to arraylist.
			position[0] = x;
			position[1] = y;
			position[2] = z;
			lunar.add(position);
			// Need to clear out the array by re-initializing it to null array of size 3. Otherwise, values won't change.
			position = new double[3];
		}
		return lunar;
	}
	
	/**
	 * 
	 * @return An arraylist of double array objects containing the position, x,y,z coordinates, of sun j2000.
	 */
	public static List<double[]> sunJ2000Positions() {
		List<double[]> sun = new ArrayList<>();
		JSONObject json = null;
		// Coordinates for a given position.
		double x = 0;
		double y = 0;
		double z = 0;
		double[] position = new double[3];
		// Iterate through a JSONArray of JSONObjects and store sun j2000 position coordinates in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save x,y and z coordinates, and store as doubles.
			JSONObject sunPosition = (JSONObject) json.get("sun_j2000_position");
			x = Double.parseDouble(sunPosition.get("x").toString());
			y = Double.parseDouble(sunPosition.get("y").toString());
			z = Double.parseDouble(sunPosition.get("z").toString());
			// Add position array to arraylist.
			position[0] = x;
			position[1] = y;
			position[2] = z;
			sun.add(position);
			// Need to clear out the array by re-initializing it to null array of size 3. Otherwise, values won't change.
			position = new double[3];
		}
		return sun;
	}
	
	/**
	 * 
	 * @return An arraylist of attitude quaternions.
	 */
	public static List<double[]> attitudeQuaternions() {
		List<double[]> quaternions = new ArrayList<>();
		JSONObject json = null;
		// Quaternion elements.
		double q0 = 0;
		double q1 = 0;
		double q2 = 0;
		double q3 = 0;
		double[] quaternion = new double[4];
		// Iterate through a JSONArray of JSONObjects and store quaternion elements in double array.
		for (int i = 0; i < epicJsonObj.size(); i++) {
			json = (JSONObject) epicJsonObj.get(i);
			// Save JSON element values as doubles.
			JSONObject attitudeQuaternion = (JSONObject) json.get("attitude_quaternions");
			q0 = Double.parseDouble(attitudeQuaternion.get("q0").toString());
			q1 = Double.parseDouble(attitudeQuaternion.get("q1").toString());
			q2 = Double.parseDouble(attitudeQuaternion.get("q2").toString());
			q3 = Double.parseDouble(attitudeQuaternion.get("q3").toString());
			// Add the attitude quaternion to the arraylist.
			quaternion[0] = q0;
			quaternion[1] = q1;
			quaternion[2] = q2;
			quaternion[3] = q3;
			quaternions.add(quaternion);
			// Need to clear out the array re-initializing it to null array of size 3. Otherwise, values won't change.
			quaternion = new double[4];
		}
		return quaternions;
	}
	
	/**
	 * 
	 * @return An arraylist of String dates.
	 */
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
	
	/**
	 * 
	 * @return an arraylist of String coordinates.
	 */
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
}

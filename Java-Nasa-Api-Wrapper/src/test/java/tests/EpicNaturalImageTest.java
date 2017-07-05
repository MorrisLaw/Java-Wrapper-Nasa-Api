package tests;

import static org.junit.Assert.assertTrue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import services.EpicNaturalImages;

/**
 * 
 * @author Jeremy L. Morris
 *
 */
public class EpicNaturalImageTest {

	private static final JSONArray epicJsonArray = EpicNaturalImages.getData();
	private static final JSONObject json = (JSONObject) epicJsonArray.get(0);

	@Test
	public void testImages() {
		assertTrue(json.containsKey("image"));
	}

	@Test
	public void testCaptions() {
		assertTrue(json.containsKey("caption"));
	}

	@Test
	public void testCentroidCoordinates() {
		assertTrue(json.containsKey("centroid_coordinates"));
	}

	@Test
	public void testDscovrJ2000Positions() {
		assertTrue(json.containsKey("dscovr_j2000_position"));
	}

	@Test
	public void testLunarJ2000Positions() {
		assertTrue(json.containsKey("lunar_j2000_position"));
	}

	@Test
	public void testSunJ2000Positions() {
		assertTrue(json.containsKey("sun_j2000_position"));
	}

	@Test
	public void testAttitudeQuaternions() {
		assertTrue(json.containsKey("attitude_quaternions"));
	}

	@Test
	public void testDates() {
		assertTrue(json.containsKey("date"));
	}

	@Test
	public void testCoordinates() {
		assertTrue(json.containsKey("coords"));
	}

}

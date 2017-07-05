package tests;

import org.json.simple.JSONObject;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import services.Apod;

/**
 * Tests for Apod service.
 * @author Jeremy L. Morris
 *
 */
public class ApodTest {

	public static final JSONObject apodObject = Apod.getData();
	
	@Test
	public void testGetDate() {
		assertTrue(apodObject.containsKey("date"));
	}
	
	@Test
	public void testGetExplanation() {
		assertTrue(apodObject.containsKey("explanation"));
	}
	
	@Test
	public void testGetMediaType() {
		assertTrue(apodObject.containsKey("media_type"));
	}
	
	@Test
	public void testGetServiceVersion() {
		assertTrue(apodObject.containsKey("service_version"));
	}
	
	@Test
	public void testGetTitle() {
		assertTrue(apodObject.containsKey("title"));
	}
	
	@Test
	public void testGetUrl() {
		assertTrue(apodObject.containsKey("url"));
	}
}

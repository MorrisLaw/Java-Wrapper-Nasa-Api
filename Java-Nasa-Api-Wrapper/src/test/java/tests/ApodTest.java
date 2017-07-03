package tests;

import org.json.simple.JSONObject;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import services.Apod;

public class ApodTest {

	public static final JSONObject apodObject = Apod.getApodData();
	
	@Test
	public void testGetDate() {
		assertTrue(apodObject.containsKey("date"));
	}
	
	@Test
	public void testGetExplanation() {
		assertTrue(apodObject.containsKey("explanation"));
	}
	
	@Test
	public void testGetHdurl() {
		assertTrue(apodObject.containsKey("hdurl"));
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

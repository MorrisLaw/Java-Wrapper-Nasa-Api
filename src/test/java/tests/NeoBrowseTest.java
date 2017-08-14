package tests;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import services.NeoBrowseService;

public class NeoBrowseTest {

	private static final JSONObject neoBrowseJsonObj = NeoBrowseService.getData();
	private static final JSONObject page = (JSONObject) neoBrowseJsonObj.get("page");
	private static final JSONObject pageLinks = (JSONObject) neoBrowseJsonObj.get("links");
	private static final JSONArray neo = (JSONArray) neoBrowseJsonObj.get("near_earth_objects");
	
	@Test
	public void testNeoBrowseJsonObjNotNull() {
		assertNotNull(neoBrowseJsonObj);
	}
	
	@Test
	public void testPageNotNull() {
		assertNotNull(page);
	}
	
	@Test
	public void testPageLinksNotNull() {
		assertNotNull(pageLinks);
	}
	
	@Test
	public void testNeoNotNull() {
		assertNotNull(neo);
	}

}

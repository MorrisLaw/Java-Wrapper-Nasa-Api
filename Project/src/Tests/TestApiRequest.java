package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import nasa.ApiRequest;

public class TestApiRequest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test public void TestGetApiKey() {
		String envKey = System.getenv("NASA_API_KEY");
		String apiKey = nasa.ApiRequest.apiKey;
		assertEquals(apiKey, envKey);
	}
	

}

package tests;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApiRequestTest {

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

	@Test
	public void testGetApiKey() {
		String envKey = System.getenv("NASA_API_KEY");
		String apiKey = services.ApiRequest.apiKey;
		assertEquals(apiKey, envKey);
	}
	
	@Test 
	public void testGetApiKeyWrongKey() {
		String envKey = "fake key";
		String apiKey = System.getenv("NASA_API_KEY");
		assertNotEquals(apiKey, envKey);
	}
	
	@Test
	public void testGetApiKeyNullKet() {
		assertNotEquals(System.getenv("NASA_API_KEY"), "");
	}
}

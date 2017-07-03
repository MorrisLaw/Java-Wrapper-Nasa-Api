package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import services.ApiRequest;

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

//	@Test
//	public void testGetApiKeyEqualsSystemEnvironmentVariableByDefault() {
//		String sysEnvKey = System.getenv("NASA_API_KEY");
//		ApiRequest.SetApiKey(sysEnvKey);
//		String getApiKeyValue = ApiRequest.GetApiKey(null);
//		assertEquals(sysEnvKey, getApiKeyValue);
//	}
//	
//	@Test
//	public void testGetApiKeyEqualsWhatItsSetTo() {
//		ApiRequest.SetApiKey("A fake key");
//		String getApiKeyValue = ApiRequest.GetApiKey(ApiRequest.apiKey);
//		assertEquals("A fake key", getApiKeyValue);
//	}
}

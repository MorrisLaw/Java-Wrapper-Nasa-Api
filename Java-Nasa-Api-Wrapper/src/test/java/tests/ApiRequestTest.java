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

	@Test
	public void testGetApiKeyEqualsSystemEnvironmentVariable() {
		String sysEnvKey = System.getenv("NASA_API_KEY");
		String getApiKeyValue = services.ApiRequest.GetApiKey(sysEnvKey);
		assertEquals(sysEnvKey, getApiKeyValue);
	}
	
	@Test 
	public void testApiRequestReturnsNullWhenApiKeyIsNull() {
		ApiRequest.SetApiKey(null);
		String nullApiKey = ApiRequest.GetApiKey(ApiRequest.apiKey);
		String nullResponseBody = ApiRequest.GetData(service);
		assertEquals(nullApiKey, envKey);
	}
//	
//	@Test
//	public void testGetApiKeyNullKet() {
//		assertNotEquals(System.getenv("NASA_API_KEY"), "");
//	}
//	
}

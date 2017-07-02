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
//	
//	@Test 
//	public void testApiRequestReturnsEnvVariableKeyByDefault() {
//	}
	
//	@Test 
//	public void testApiRequestReturnsNullWhenApiKeyIsNull() {
//		ApiRequest.SetApiKey(null);
//		String apiRequestResponse = "Should switch to null";
//		try {
//			apiRequestResponse = ApiRequest.GetData(ApiRequest.apodService);
//			assertEquals(null, apiRequestResponse);
//		} catch(Exception e) {
//			System.err.print(e);
//		}
//	}
//}

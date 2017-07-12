package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import services.ApiRequest;

/**
 * Tests for Api Request.
 * @author Jeremy L. Morris
 *
 */
public class ApiRequestTest {

	@Test
	public void testGetApiKeyEqualsSystemEnvironmentVariableByDefault() {
		String sysEnvKey = System.getenv("NASA_API_KEY");
		ApiRequest.setApiKey(sysEnvKey);
		String getApiKeyValue = ApiRequest.getApiKey(null);
		assertEquals(sysEnvKey, getApiKeyValue);
	}
	
	@Test
	public void testGetApiKeyEqualsWhatItsSetTo() {
		ApiRequest.setApiKey("A fake key");
		String getApiKeyValue = ApiRequest.getApiKey(ApiRequest.apiKey);
		assertEquals("A fake key", getApiKeyValue);
	}
	
}

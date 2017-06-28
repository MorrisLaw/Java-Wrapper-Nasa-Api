package nasa;

import org.apache.http.HttpResponse;

public class ApiRequest {
	/**
	 * Gateway to NASA open API service(s).
	 */
	public static final String apiKey = System.getenv("NASA_API_KEY");
	
	/**
	 * Returns the HTTP response in the form of JSON.
	 * 
	 * @param url
	 * @return The HTTP response for the HTTP GET request.
	 */
	private HttpResponse ApiRequest(String url) {
		try {
//			HttpGet httpGet = new HttpGet("http://")
		} finally {
			
		}
	}
	/**
	 * 
	 * @return The NASA API key set in the environment variables.
	 */
	private String GetApiKey() {
		return apiKey;
	}
	
}

package services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiRequest {
	/**
	 * Gateway to NASA open API service(s).
	 */
	// By default the api key is set to your environment variable.
	public static String apiKey = null;
	private static final String urlApiKeySuffix = "?api_key=" + GetApiKey(apiKey);
	private static final String baseUrl = "https://api.nasa.gov";
	// NASA services.
	public static final String apodService = "/planetary/apod";
	// Variable to be passed in to GetData() as a String, representing specific NASA service.
	static String service = null;
	/**
	 * Returns the HTTP response in the form of JSON.
	 * 
	 * @param service, a String that specifies which API service is passed in to the HTTP GET request.
	 * @return The HTTP response for the HTTP GET request.
	 */
	public static String GetData(String service) throws Exception {
		
		// HTTP response object.
		String responseBody = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// URL builder for the HTTP GET request.
			HttpGet httpGet = new HttpGet(baseUrl + service + urlApiKeySuffix);
			System.out.println("Executing request " + httpGet.getRequestLine());
			
			// Create a custom response handler.
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			
			    public String handleResponse(
			    		final HttpResponse response) throws ClientProtocolException, IOException {
			    	// Handling HTTP status codes.
			    	int status = response.getStatusLine().getStatusCode();
			    	if(status >= 200 && status < 300) {
			    		HttpEntity entity = response.getEntity();
			    		return entity != null ? EntityUtils.toString(entity) : null;
			    	} else {
			    		throw new ClientProtocolException("Unexpected response satus: " + status);
			    	}
			    }
			};
		    responseBody = httpClient.execute(httpGet, responseHandler);
		} finally {
			httpClient.close();
		}
		return responseBody;
	}
	
	/**
	 * 
	 * @param newApiKey, a String value that the user can define as being their new Api Key as 
	 * opposed to using the system environment variable.
	 */
	public static void SetApiKey(String newApiKey) {
		apiKey = newApiKey;
	}
	
	/**
	 * 
	 * @param apiKey, the current String value of the apiKey being used for HTTP GET requests.
	 * @return the current String value of apiKey as seen by this API wrapper. By default, this returns the 
	 * system environment variable for NASA_API_KEY if it has not already been set, even if it's null. 
	 * You can change this by setting a new NASA API key via SetApiKey(String newApiKey).
	 */
	public static String GetApiKey(String apiKey) {
		if(apiKey == null || apiKey == "") {
			apiKey = System.getenv("NASA_API_KEY");
		}
		return apiKey;
	}
	
}

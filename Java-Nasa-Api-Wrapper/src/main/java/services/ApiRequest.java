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
	public static final String apiKey = System.getenv("NASA_API_KEY");
	private static final String urlApiKeySuffix = "?api_key=" + apiKey;
	public static final String baseUrl = "https://api.nasa.gov";
	// Nasa service specific url parts.
	public static final String apodRequest = "/planetary/apod";
//	public static String responseBody = null;
	public static String service = null;
	/**
	 * Returns the HTTP response in the form of JSON.
	 * 
	 * @param url
	 * @return The HTTP response for the HTTP GET request.
	 */
	private void ApiRequest(String service) throws Exception {
		
		String responseBody = null;
		service = GetService();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// Using test url.
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
		    GetResponse(responseBody);
//		    System.out.println("----------------------------------------");
//		    System.out.println(responseBody);
		} finally {
			httpClient.close();
		}
	}
	/**
	 * 
	 * @return Returns the Nasa API Key, found via the systems environment variables.
	 */
	private String GetApiKey() {
		return apiKey;
	}
	
	/**
	 * 
	 * @return Returns the Apod url part needed for the api request.
	 */
	public String Apod() {
		return apodRequest;
	}

	/**
	 * 
	 * @param apiService
	 */
	public static void SetService(String apiService) {
		service = apiService;
	}
	
	/**
	 * 
	 * @return API service as specified by the user.
	 */
	public static String GetService() {
		return service;
	}
	
	public String GetResponse(String responseBody) {
		return responseBody;
	}
}

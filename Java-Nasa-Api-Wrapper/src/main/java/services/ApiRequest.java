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
	public static String ApiRequest(String service) throws Exception {
		
		String responseBody = null;
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
//		    System.out.println("----------------------------------------");
//		    System.out.println(responseBody);
		} finally {
			httpClient.close();
		}
		return responseBody;
	}
	
	/**
	 * 
	 * @param responseBody
	 * @return HTTP Response if not null, otherwise throw NullPointerException and return null.
	 */
//	public String GetResponse(String responseBody) {
//		try {
//			String result = responseBody;
//			return result;
//		} catch(NullPointerException e) {
//			System.err.println(e);
//		}
//		return null;
//	}
	
	public static void main(String[] args) {
		String httpResponse = null;
		try {
			httpResponse = ApiRequest.ApiRequest(apodRequest);
		} catch(Exception e) {
			System.err.println(e);
		}
		System.out.println(httpResponse);
	}
}

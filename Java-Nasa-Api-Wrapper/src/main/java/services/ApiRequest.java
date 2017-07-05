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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This is the where the HTTP GET request occurs. An HTTP response object, as a string, is returned.
 * @author Jeremy L. Morris
 *
 */
public class ApiRequest {
	/**
	 * Gateway to NASA open API service(s).
	 */
	// By default the api key is set to your environment variable.
	public static String apiKey = null;
	private static final String urlApiKeySuffix0 = "?api_key=" + getApiKey(apiKey);
	private static final String urlApiKeySuffix1 = "&api_key=" + getApiKey(apiKey);
	private static final String baseUrl = "https://api.nasa.gov/";
	// NASA services.
	public static final String apodService = "planetary/apod";
	public static final String neoServiceFeed = "neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08"; //&api_key=DEMO_KEY";
	public static final String neoServiceLookup = "neo/rest/v1/neo/3542519";
	public static final String neoServiceBrowse = "neo/rest/v1/neo/browse";
	public static final String epicServiceNaturalImages = "/EPIC/api/natural/images";
	public static final String epicServiceEnhancedAll = "EPIC/api/enhanced/all";
	// Variable to be passed in to GetData() as a String, representing specific NASA service.
	static String service = null;
	
	/**
	 * Returns the HTTP response in the form of JSON.
	 * 
	 * @param service, a String that specifies which API service is passed in to the HTTP GET request.
	 * @return The HTTP response for the HTTP GET request.
	 */
	protected static String getData(String service) throws Exception {
		// HTTP response object.
		String responseBody = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = null;
			// URL builder for the HTTP GET request.
			if (service == neoServiceFeed) {
				httpGet = new HttpGet(baseUrl + service + urlApiKeySuffix1);
			}else{
				httpGet = new HttpGet(baseUrl + service + urlApiKeySuffix0);
			}
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
	public static void setApiKey(String newApiKey) {
		apiKey = newApiKey;
	}
	
	/**
	 * 
	 * @param apiKey, the current String value of the apiKey being used for HTTP GET requests.
	 * @return the current String value of apiKey as seen by this API wrapper. By default, this returns the 
	 * system environment variable for NASA_API_KEY if it has not already been set, even if it's null. 
	 * You can change this by setting a new NASA API key via SetApiKey(String newApiKey).
	 */
	public static String getApiKey(String apiKey) {
		if(apiKey == null || apiKey == "") {
			apiKey = System.getenv("NASA_API_KEY");
		}
		return apiKey;
	}
	
	/**
	 * 
	 * @param responseBody, String object of JSON data.
	 * @return a json object that has been parsed and read using json text via the JSONParser object.
	 */
	public static JSONObject getJsonObject(String responseBody) {
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		try{
			json = (JSONObject) parser.parse(responseBody);
		} catch(Exception e) {
			System.err.print(e);
		}
		return json;
	}
	
}

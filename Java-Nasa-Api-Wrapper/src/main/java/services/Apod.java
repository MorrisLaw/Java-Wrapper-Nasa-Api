package services;

import services.ApiRequest;

public class Apod {
	
	/**
	 * 
	 * @param responseBody, represents the HTTP response object.
	 * @param service, the unique identifier to be passed into the HTTP GET request String URL.
	 */
	public static String GetApodData() {
		String responseBody = null;
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.GetData(ApiRequest.apodService);
		} catch(Exception e) {
			System.err.println(e);
		}
		return responseBody;
	}
}
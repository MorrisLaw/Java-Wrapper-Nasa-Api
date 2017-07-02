package services;

import services.ApiRequest;

public class Apod {
	
	/**
	 * 
	 * @param responseBody, represents the HTTP response object.
	 * @param service, the unique identifier to be passed into the HTTP GET request String URL.
	 */
	public static String GetApodData(String responseBody, String service) {
		try {
			// String object of key value pairs.
			responseBody = ApiRequest.GetData(service);
		} catch(Exception e) {
			System.err.println(e);
		}
		return responseBody;
	}
//	public static void main(String[] args) {
//		String responseBody = null;
//		String service = ApiRequest.apodService;
//		System.out.println(GetApodData(responseBody, service));
//	}
}
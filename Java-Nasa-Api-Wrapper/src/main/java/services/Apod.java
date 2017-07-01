package services;

import services.ApiRequest;

public class Apod {
	/**
	 * Wrapper for Astronomy Picture of the Day. 
	 */
	private static String GetApod() {
//		try {
//			String test = "/planetary/apod";
//			return ApiRequest(test);
//		} catch(Exception e) {
//			System.err.print("Error");
//		}
		ApiRequest request = null;
		ApiRequest.SetService(ApiRequest.apodRequest);
		return ApiRequest.responseBody;
	}
	
	public static void main(String[] args) {
		System.out.println(GetApod());
	}
}
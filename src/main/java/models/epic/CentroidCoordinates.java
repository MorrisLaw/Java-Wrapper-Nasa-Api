package models.epic;

public class CentroidCoordinates {

	private double lat;
	private double lon;
	
	public void data(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
	public double getLatitude() {
		return lat;
	}
	
	public double getLongitude() {
		return lon;
	}
}

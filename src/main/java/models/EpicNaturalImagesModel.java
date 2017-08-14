package models;

import models.epic.AttitudeQuaternions;
import models.epic.CentroidCoordinates;
import models.epic.Coordinates;
import models.epic.DscovrJ2000;
import models.epic.LunarJ2000;
import models.epic.SunJ2000;

/**
 * 
 * @author Jeremy L. Morris
 *
 */
public class EpicNaturalImagesModel {

	private String image;
	private String caption;
	private CentroidCoordinates centroid_coordinates;
	private DscovrJ2000 dscovr_j2000_position;
	private LunarJ2000 lunar_j2000_position;
	private SunJ2000 sun_j2000_position;
	private AttitudeQuaternions attitude_quaternions;
	private String date;
	private Coordinates coords;
	
	public void data(String image, String caption, CentroidCoordinates centroid_coordinates, 
			DscovrJ2000 dscovr_j2000_position, LunarJ2000 lunar_j2000_position, SunJ2000 sun_j2000_position, 
			AttitudeQuaternions attitude_quaternions, String date, Coordinates coords) {
		this.image = image;
		this.caption = caption;
		this.centroid_coordinates = centroid_coordinates;
		this.dscovr_j2000_position = dscovr_j2000_position;
		this.lunar_j2000_position = lunar_j2000_position;
		this.sun_j2000_position = sun_j2000_position;
		this.attitude_quaternions = attitude_quaternions;
		this.date = date;
		this.coords = coords;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public CentroidCoordinates getCentroidCoordinates() {
		return centroid_coordinates;
	}
	
	public DscovrJ2000 getDscovrJ2000Position() {
		return dscovr_j2000_position;
	}
	
	public LunarJ2000 getLunarJ2000Position() {
		return lunar_j2000_position;
	}
	
	public SunJ2000 getSunJ2000Position() {
		return sun_j2000_position;
	}
	
	public AttitudeQuaternions getAttitudeQuaternions() {
		return attitude_quaternions;
	}
	
	public String getDate() {
		return date;
	}
	
	public Coordinates getCoordinates() {
		return coords;
	}
}
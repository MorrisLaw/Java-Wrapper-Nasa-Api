package models;

import java.time.LocalDate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.*;

/**
 * 
 * @author Jeremy L. Morris
 *
 */
public class ApodModel {
	
	private String copyright;
	private String date;
	private String explanation;
	private String hdurl;
	private String media_type;
	private String service_version;
	private String title;
	private String url;
	
	public void data(String copyright, String date, String explanation, String hdurl,
					String media_type, String service_version, String title, String url) {
		this.copyright = copyright;
		this.date = date;
		this.explanation = explanation;
		this.hdurl = hdurl;
		this.media_type = media_type;
		this.service_version = service_version;
		this.title = title;
	}
	
	public String getCopyright() {
		return copyright;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getExplanation() {
		return explanation;
	}
	
	public String getHdurl() {
		return hdurl;
	}
	
	public String getMediaType() {
		return media_type;
	}
	
	public String getServiceVersion() {
		return service_version;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getUrl() {
		return url;
	}
}
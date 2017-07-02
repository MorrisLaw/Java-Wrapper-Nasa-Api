package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import services.ApiRequest;
import services.Apod;

public class ApodTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void GetApodDataTest() {
		String responseBody = null;
		String service = ApiRequest.apodService;
		assertNotEquals(Apod.GetApodData(responseBody, service), null);
	}
}

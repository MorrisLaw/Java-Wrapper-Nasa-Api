package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import services.NeoFeed;

public class NeoFeedTest {

	@Test
	public void testNeoFeedObject() {
		String startDate = "2015-09-07";
		String endDate = "2015-09-08";
		assertNotNull(NeoFeed.getData(startDate, endDate));
	}
}

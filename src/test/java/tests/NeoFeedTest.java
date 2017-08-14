package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import services.NeoFeedService;

public class NeoFeedTest {

	@Test
	public void testNeoFeedObjectNotNull() {
		String startDate = "2015-09-07";
		String endDate = "2015-09-08";
		assertNotNull(NeoFeedService.getData(startDate, endDate));
	}
}

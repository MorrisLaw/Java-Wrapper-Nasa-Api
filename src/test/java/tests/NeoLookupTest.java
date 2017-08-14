package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import services.NeoLookupService;

public class NeoLookupTest {
	
	@Test
	public void testNeoLookupObjectNotNull() {
		assertNotNull(NeoLookupService.getData(3542519));
	}

}

package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import services.NeoLookup;

public class NeoLookupTest {
	
	@Test
	public void testNeoLookupObject() {
		assertNotNull(NeoLookup.getData(3542519));
	}

}

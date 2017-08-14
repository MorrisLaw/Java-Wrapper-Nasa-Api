package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import services.PatentsService;

public class PatentsTest {

	@Test
	public void testPatentsObjectNotNull() {
		assertNotNull(PatentsService.getData("temperature", 5));
	}

}

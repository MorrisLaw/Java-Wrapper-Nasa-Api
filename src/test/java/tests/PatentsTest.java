package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import services.Patents;

public class PatentsTest {

	@Test
	public void testPatentsObjectNotNull() {
		assertNotNull(Patents.getData("temperature", 5));
	}

}

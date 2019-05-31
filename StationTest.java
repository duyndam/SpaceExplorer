package Game;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class StationTest {
	
	@Test
	void testStation() {
		Station testOutpost = new Station();
		
		assertNotNull(testOutpost.availableItems);
	}


	@Test
	void testGet_ItemCount() {
		Station testOutpost = new Station();
		
		assertEquals(testOutpost.availableItems.size(), testOutpost.get_ItemCount());
	}

}

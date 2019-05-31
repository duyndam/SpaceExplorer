package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MedicalItemTest {

	@Test
	void testStringIfy() {
		MedicalItem testMed = new MedicalItem();
		testMed.stringIfy(25);
		assertEquals(MedicalItem.typeMedical.BANDAGE, testMed.get_Type());
	}

}

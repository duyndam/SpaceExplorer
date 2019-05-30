package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CrewMemberTest {

	@Test
	void testDoAction() {
		CrewMember testBoy = new CrewMember("Greg", CrewMember.type.ENGINEER);
		
		assertTrue(testBoy.doAction("Do a thing"));
	}

	@Test
	void testIsActionDoAble() {
		CrewMember testBoy = new CrewMember("Greg", CrewMember.type.ENGINEER);
		testBoy.doAction("First Action");
		testBoy.doAction("Second Action");
		
		assertFalse(testBoy.isActionDoAble("Third Action"));
	}

	@Test
	void testClearActions() {
		CrewMember testBoy = new CrewMember("Greg", CrewMember.type.ENGINEER);
		testBoy.doAction("Do a thing");
		testBoy.clearActions();
		
		assertNull(testBoy.actionList);
	}

}

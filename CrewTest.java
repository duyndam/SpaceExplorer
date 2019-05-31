package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class CrewTest {

	@Test
	void testAddCrew() {
		Ship testShip = new Ship("test");
		CrewMember testCrew1 = new CrewMember("Bob", CrewMember.type.PILOT);
		ArrayList members = new ArrayList<>();
		Crew testCrew = new Crew(members, testShip);
		testCrew.addCrew(testCrew1);
		
		assertNotNull(testCrew.crewMembers);
	}

	@Test
	void testAddFood() {
		Ship testShip = new Ship("test");
		ArrayList members = new ArrayList<>();
		Crew testCrew = new Crew(members, testShip);
		FoodItem testFood = new FoodItem();
		testCrew.addFood(testFood);
		
		assertNotNull(testCrew.inventory);
	}

	@Test
	void testRemoveItem() {
		Ship testShip = new Ship("test");
		ArrayList members = new ArrayList<>();
		Crew testCrew = new Crew(members, testShip);
		FoodItem testFood = new FoodItem();
		testCrew.addFood(testFood);
		testCrew.removeItem(testFood);
		
		assertNull(testCrew.inventory);
	}

	@Test
	void testAddPart() {
		Ship testShip = new Ship("test");
		ArrayList members = new ArrayList<>();
		Crew testCrew = new Crew(members, testShip);
		String testPart = "Thing";
		testCrew.addPart(testPart);
		
		assertNotNull(testCrew.shipParts);
	}

	@Test
	void testCargoHold() {
		Ship testShip = new Ship("test");
		ArrayList members = new ArrayList<>();
		Crew testCrew = new Crew(members, testShip);
		FoodItem testFood = new FoodItem();
		testCrew.addFood(testFood);
	
		assertNotNull(testCrew.cargoHold());
	}

	@Test
	void testJobCount() {
		
		Ship testShip = new Ship("test");
		CrewMember testCrew1 = new CrewMember("Bob", CrewMember.type.PILOT);
		CrewMember testCrew2 = new CrewMember("John", CrewMember.type.PILOT);
		ArrayList members = new ArrayList<>();
		
		Crew testCrew = new Crew(members, testShip);
		testCrew.addCrew(testCrew1);
		testCrew.addCrew(testCrew2);
		
		assertEquals(2, testCrew.jobCount(CrewMember.type.PILOT));
		
	}

}

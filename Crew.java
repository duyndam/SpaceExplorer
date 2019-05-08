// Import statements
import java.util.*;
import java.util.Scanner;

/**
 * @author      Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

public class Crew {

  private ArrayList<CrewMember> crew;

  public Crew(Ship vessel) {
    int money = 100;
    crew = new ArrayList<CrewMember>();
  }

  /**
   * Establishes initial crew size
   */
  public int crewSize() {
    return 4;
  }

  /**
   * Adds a cosmonaut to the crew.
   *
   * @param cosmonaut cosmonaut to be added
   * @return          true if successfully adds cosmonaut to crew, otherwise false
   */
  public boolean addCrew(CrewMember cosmonaut) {
    if (crew.size() < crewSize() && !crew.contains(cosmonaut)) {
      crew.add(cosmonaut);
      System.out.println(cosmonaut.getName() + " was added to the crew.");
      return true;
    }
    else {
      System.out.println("The ship is fully crewed.");
      return false;
    }
  }

  public String inventory() {
    String stuff = "This is everything the crew has:";
    return stuff;
  }


  public String toString() {
    String crewManifest = "";
    for (CrewMember cosmonaut: crew) {
      crewManifest += "\n" + cosmonaut.getName();
    }
    return crewManifest;
  }
}

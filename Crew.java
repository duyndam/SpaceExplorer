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

  public Crew() {
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

  /**
   *
   */
  public String toString() {
    String crewManifest = "";
    for (CrewMember cosmonaut: crew) {
      crewManifest += "\n" + cosmonaut.getName();
    }
    return crewManifest;
  }

  public static void main(String[] args) {
    Crew theTeam = new Crew();

    CrewMember yuri = new CrewMember();
    CrewMember val = new CrewMember("Engineer", "Valentina", 100, 0);
    CrewMember bob = new CrewMember("Scientist", "Bob", 100, 0);

    theTeam.addCrew(yuri);
    theTeam.addCrew(val);
    theTeam.addCrew(bob);

    System.out.println(theTeam.toString());

  }
}

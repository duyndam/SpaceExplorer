// Import statements
import java.util.*;
import java.util.Scanner;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class Crew {

  private ArrayList<CrewMember> crewMembers;
  private Ship crewShip;
  private ArrayList<Item> crewItems;

  public Crew(ArrayList<CrewMember> listOfMembers, Ship spaceShip) {
    int money = 100;
    crewMembers = listOfMembers;
    crewShip = spaceShip;
  }

  /**
   * Establishes initial crew size
   */
  public int crewSize() {
    return crewMembers.size();
  }

  /**
   * Adds a cosmonaut to the crew.
   *
   * @param cosmonaut cosmonaut to be added
   * @return          true if successfully adds cosmonaut to crew, otherwise false
   */
  public boolean addCrew(CrewMember cosmonaut) {
    if (crewMembers.size() < crewSize() && !crewMembers.contains(cosmonaut)) {
      crewMembers.add(cosmonaut);
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
    for (CrewMember cosmonaut: crewMembers) {
      crewManifest += "\n" + cosmonaut.getName();
    }
    return crewManifest;
  }
}

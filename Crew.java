// Import statements
import java.util.*;
import java.util.Scanner;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class Crew {

  public ArrayList<CrewMember> crewMembers;
  public Ship crewShip;

  public Crew(ArrayList<CrewMember> listOfMembers, Ship spaceShip) {
    int money = 100;
    crewMembers = listOfMembers;
    crewShip = spaceShip;
  }

  public int crewSize() {
    return crewMembers.size();
  }

  public void setShip(Ship vessel) {
    crewShip = vessel;
  }
  
  public void addCrew(CrewMember cosmonaut) {
    crewMembers.add(cosmonaut);
  }

  public String toString() {
    String crewManifest = "";
    for (CrewMember cosmonaut: crewMembers) {
      crewManifest += "\n" + cosmonaut.toString();
    }
    crewManifest += crewShip.toString();
    return crewManifest;
  }
}

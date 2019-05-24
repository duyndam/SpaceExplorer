// Import statements
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

/**
 * Crew class. This is where all player information is stored, including:
 *
 *  - List of crew members
 *  - Ship object
 *  - Crew inventory
 *  - Crew money
 *
 */
public class Crew
{

  public ArrayList<CrewMember> crewMembers;
  public ArrayList<String> shipParts;
  public ArrayList<Item> inventory = new ArrayList<>();
  public Ship crewShip;
  private int crewMoney;


  /**
   * Initialises a new Crew object.
   *
   * During the setup phase of the game, the player adds crew members to the Crew.
   *
   * @param listOfMembers initially empty list of crewMembers, which is updated throughout gameplay.
   * @param spaceShip     Ship object, named by the player, with default health.
   */
  public Crew(ArrayList<CrewMember> listOfMembers, Ship spaceShip)
  {
	  crewMoney = 100;
    crewMembers = listOfMembers;
    crewShip = spaceShip;
  }

  /**
   * How many crew members there are. Used rarely.
   *
   * @return      the size of the crew.
   */
  public int crewSize()
  {
    return crewMembers.size();
  }

  /**
   * Assigns a ship to the crew.
   *
   * @param vessel ship to be assigned.
   */
  public void setShip(Ship vessel)
  {
    crewShip = vessel;
  }

  public Ship getShip()
  {
    return crewShip;
  }

  public boolean addMoney(int amount) {
    if(amount < 0 && crewMoney + amount < 0)
    {
      crewMoney = 0;
      return false;
    }
    else
    {
      crewMoney += amount;
      return true;
    }
  }

  public boolean removeMoney(int amount) {
    if(amount < 0 && crewMoney + amount < 0)
    {
      crewMoney = 0;
      return false;
    }
    else
    {
      crewMoney -= amount;
      return true;
    }
  }

  public int getMoney() {
    return crewMoney;
  }
  /**
   * Adds a crew member to the crew. only called during the setup phase of the game.
   *
   * @param cosmonaut the crew member to be added.
   */
  public void addCrew(CrewMember cosmonaut)
  {
    crewMembers.add(cosmonaut);
  }

  /**
   * Adds an item to the crew's inventory.
   *
   * Called whenever buying from stations or searching a planet.
   *
   * @param item item to be added to inventory.
   */
  public void addMedical(MedicalItem item)
  {
    inventory.add(item);
  }

  public void addFood(FoodItem item)
  {
    inventory.add(item);
  }

  /**
   * Removes an item from the crew's inventory.
   *
   * Called whenever selling to stations, or during alien attacks.
   *
   * @param item item to be removed from inventory.
   */
  public void removeItem(Item item)
  {
    inventory.remove(item);
  }

  /**
   * Adds a spaceShip part to the crew.
   *
   * @param part  string part name
   */
  public void addPart(String part)
  {
    shipParts.add(part);
  }

  /**
   * Show contents of the crew's inventory.
   *
   * @return      string detailing the contents of the cargo hold.
   */
  public String cargoHold()
  {
    String cargo = "";
    int index = 0;
    for (Item thing: inventory)
    {
      index += 1;
      cargo += index + ": " + thing.toString()+ "\n";

    }
    cargo += inventory.size()+1 + ": Exit";
    return cargo;
  }

  public int jobCount(CrewMember.type job) {
    int count = 0;
    for (CrewMember cosmonaut: crewMembers)
    {
      if (cosmonaut.getType() == job)
      {
        count += 1;
      }
    }
    return count;
  }

  public String createActionChoseString()
  {
	  String strActionString = "";
	  for(int iCrewIndex = 0; iCrewIndex < crewMembers.size(); iCrewIndex++)
	  {
		  strActionString += iCrewIndex+1 + ": " + crewMembers.get(iCrewIndex).getName() +  crewMembers.get(iCrewIndex).getActionCountString() + "\n";
	  }
	  strActionString += crewMembers.size()+1 + ": Exit";
	  return strActionString;
  }

  /**
   * Crew toString method.
   *
   * @return      string detailing all crew members and attributes, as well as ship attributes.
   */
  public String toString()
  {
    String crewManifest = "";
    for (CrewMember cosmonaut: crewMembers)
    {
      crewManifest += cosmonaut.toString();
    }
    //crewManifest += crewShip.toString();
    crewManifest += "Money: " + crewMoney;
    crewManifest += "\n--------------------";
    return crewManifest;
  }
}

package Game;
/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

/**
 * Ship class, containing the player's spaceship. Has name, shield level, hull integrity,
 * and number of crew members piloting (two "pilot seats").
 */
public class Ship
{

  private String name;
  private int shield;
  private int hull;
  private int numPilots;
  private final int MAX_PILOTS = 2;

  /**
   * Ship constructor. Initializes new ship object with given name, and default
   * other attributes.
   *
   * @param shipName string with name for ship.
   */
  public Ship(String shipName)
  {
    name = shipName;
    shield = 100;
    hull = 100;
    numPilots = 0;
  }

  /**
   * Ship constructor. Initializes new ship object with given values.
   *
   * @param shipName          string with name for ship.
   * @param shieldStartValue  int between 0 and 100
   * @param hullIntegrity     int between 0 and 100
   * @param pilots            int value for starting number of pilots.
   */
  public Ship(String shipName, int shieldStartValue, int hullIntegrity, int pilots)
  {
	  name = shipName;
	  shield = shieldStartValue;
    hull = hullIntegrity;
    numPilots = pilots;
  }

  /**
   * Name getter.
   *
   * @return name       string with ship name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Shield getter.
   *
   * @return shield     int with shield value
   */
  public int getShield()
  {
    return shield;
  }

  /**
   * Hull integrity getter.
   *
   * @return hull       int with hull value.
   */
  public int getHull()
  {
    return hull;
  }

  /**
   * Pilot getter.
   *
   * @return numPilots  int with current piloted by number.
   */
  public int getNumPilots()
  {
    return numPilots;
  }

  /**
   * Adds a pilot to the ship's cockpit.
   *
   * @return false      if ship already has 2 pilots
   * @return true       if pilot successfully added
   */
  public boolean addPilot()
  {
    if (numPilots >= MAX_PILOTS)
    {
      return false;
    }
    else
    {
      numPilots += 1;
      return true;
    }
  }

  /**
   * Updates ship shield/hull values when repairing/taking damage.
   *
   * @param  amount    int amount to repair/damage
   * @return true      if ship destroyed (i.e. hull <= 0)
   * @return false     if values updated successfully
   */
  public boolean update(int amount)
  {
    if(shield > 0) {
      if(amount > 0 && shield+amount > 100)
      {
      	shield = 100;
      }
      else
      {
      	shield += amount;
      }
    }
    else
    {
      if(amount > 0 && hull+amount > 100)
      {
      	hull = 100;
      }
      else
      {
      	hull += amount;
      }
      if (hull <= 0)
      {
        return true;
      }
      else
      {
      	return false;
      }
    }
    return false;
  }

  public String serialize()
  {
	  String strSerialize = "";
	  strSerialize += name + ",";
	  strSerialize += shield + ",";
	  strSerialize += hull + ",";
	  strSerialize += numPilots + ",";
	  return strSerialize;
  }
  
  /**
   * Ship toString.
   *
   * @return shipString   string containing all ship attributes.
   */
  public String toString()
  {
    String shipString = "--------------------\n";
    shipString += "Ship name : " + name + "\n";
    shipString += "Shield    : " + shield + "\n";
    shipString += "Hull      : " + hull + "\n";
    shipString += "Piloted by: " + numPilots + " out of " + MAX_PILOTS + "\n";
    shipString += "--------------------\n";
    return shipString;
  }
}

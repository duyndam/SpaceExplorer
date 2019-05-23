/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

public class Ship {

  private String name;
  private int shield;
  private int hull;
  private int numPilots;
  private final int MAX_PILOTS = 2;

  public Ship(String shipName) {
    name = shipName;
    shield = 100;
    hull = 100;
    numPilots = 0;
  }

  public Ship(String shipName, int shieldStartValue)
  {
	  name = shipName;
	  shield = shieldStartValue;
  }

  public String getName() {
    return name;
  }

  public int getShield() {
    return shield;
  }

  public int getHull() {
    return hull;
  }

  public int getNumPilots() {
    return numPilots;
  }

  public boolean addPilot() {
    if (numPilots >= MAX_PILOTS) {
      return false;
    }
    else {
      numPilots += 1;
      return true;
    }

  }

  public boolean update(int amount) {
    if(shield > 0) {
      if(amount > 0 && shield+amount > 100) {
      	shield = 100;
      }
      else {
      	shield += amount;
      }
    }
    else {
      if(amount > 0 && hull+amount > 100) {
      	hull = 100;
      }
      else {
      	hull += amount;
      }
      if (hull <= 0) {
        return true;
      }
      else {
      	return false;
      }

    }
    return false;
  }

  public String toString() {
    String shipString = "--------------------\n";
    shipString += "Ship name : " + name + "\n";
    shipString += "Shield    : " + shield + "\n";
    shipString += "Hull      : " + hull + "\n";
    shipString += "Piloted by: " + numPilots + " out of " + MAX_PILOTS + "\n";
    shipString += "--------------------\n";
    return shipString;
  }
}

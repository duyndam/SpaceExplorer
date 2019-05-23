/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

public class Ship {

  private String name;
  private int shield;
  private int hull;

  public Ship(String shipName) {
    name = shipName;
    shield = 100;
    hull = 100;
  }

  public Ship(String shipName, int shieldStartValue)
  {
	  name = shipName;
	  shield = shieldStartValue;
  }

  public int getShield() {
    return shield;
  }

  public int getHull() {
    return hull;
  }

  
  //updated check to make sure the shield is at 0 or below before the ship counts as destroyed
  //also build in security that the ship can't get repaired over 100%
  //also switched to boolean so the print will happen after the call
  /* return:
   * true  - if ship was destroyed with update
   * false - if ship wasn't destroyed with update
   */
  public boolean updateShield(int amount) {
    if(amount > 0 && shield+amount > 100) {
    	shield = 100;
    }
    else {
    	shield += amount;
    }
    if (shield <= 0) {
      return true;
    }
    else {
    	return false;
    }
  }

  public boolean updateHull(int amount) {
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

  public String toString() {
    String shipString = "--------------------\n";
    shipString += "Ship name : " + name + "\n";
    shipString += "Shield    : " + shield + "\n";
    shipString += "Hull      : " + hull + "\n";
    shipString += "--------------------\n";
    return shipString;
  }
}

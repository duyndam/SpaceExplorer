public class Ship {

  private String name;
  private int shield;

  public Ship(String shipName) {
    name = shipName;
    shield = 100;
  }
  
  public Ship(String shipName, int shieldStartValue)
  {
	  name = shipName;
	  shield = shieldStartValue;
  }

  public int getShield() {
    return shield;
  }

  //updated check to make sure the shield is at 0 or below before the ship counts as destroyed
  //also build in security that the ship can't get repaired over 100%
  //also switched to boolean so the print will happen after the call 
  /* return:
   * true  - if ship was destroyed with update
   * false - if ship wasn't destroyed with update
   */
  public boolean updateShield(int amount) {
    if(amount > 0 && shield+amount > 100)
    {
    	shield = 100;
    }
    else
    {
    	shield += amount;
    }
    
    if (shield <= 0) {
      return true;
    	//System.out.println("Ship destroyed :(");
    }
    else
    {
    	return false;
    }
  }

  public String toString() {
    String shipString = "--------------------\n";
    shipString += "Shipname : " + name + "\n";
    shipString += "Shield   : " + shield + "\n";
    shipString += "--------------------\n";
    return shipString;
  }

/*  public static void main(String[] args) {
    Ship starShip = new Ship("Nautilus");
    System.out.println(starShip.toString());
    starShip.updateShield(-50);
    starShip.updateShield(-50);
  }
*/
}

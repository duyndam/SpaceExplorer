// Import statements
import java.util.ArrayList;
import java.util.Random;
/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class Planet {

  private String name;
  private String climate;

  public Planet() {
    name = "Europa";
    climate = "desert";
  }

  /**public void search() {

    Random rand = new Random();
    int luckyFind = rand.nextInt(5);
    int money = rand.nextInt(100);
    MedicalItem meds = new MedicalItem();
    FoodItem food = new FoodItem();
    String nothing = "NOTHING";
    String spaceShipPart = "SPARE PART";
    if (luckyFind == 0) {
      return meds;
    }
    else if (luckyFind == 1) {
      return food;
    }
    else if (luckyFind == 2) {
      return money;
    }
    else if (luckyFind == 3) {
      return spaceShipPart;
    }
    else {
      return nothing;
    }
  }*/

  public String toString() {
    String body = "";
    body += "The planet " + this.name + " is a(n) " + this.climate + " planet.";
    return body;
  }

}

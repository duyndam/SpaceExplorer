// Import statements
import java.util.ArrayList;
import java.util.Random;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

 /**
   View objects, such as food and medical supplies that are for sale.

   See the prices of each object.

   See the attributes of the object

   Enable the player to purchase objects such as food and medical supplies.

   Be able to purchase multiple objects at a time without leaving the
   outpost.
   */
public class Station {

  Random rand = new Random();

  private int numMed = rand.nextInt(6);
  private int numFood = rand.nextInt(6);
  ArrayList<Item> wares;

  public Station() {
    wares = new ArrayList<>();
  }

  public void populateStation() {
    for (int i = 0; i < numMed; i++) {
      MedicalItem meds = new MedicalItem();
      wares.add(meds);
    }
    for (int j = 0; j < numFood; j++) {
      FoodItem food = new FoodItem();
      wares.add(food);
    }
  }
}

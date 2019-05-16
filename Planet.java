// Import statements
import java.util.ArrayList;
import java.util.Random;
/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class Planet {
  
  Random rand = new Random();

  private int luckyFind = rand.nextInt(5);

  public Planet() {
    name = "Europa";
    climate = "Desert";
  }

}

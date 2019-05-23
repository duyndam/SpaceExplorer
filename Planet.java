// Import statements
import java.util.ArrayList;
import java.util.Random;
/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

public class Planet {

  private String name;
  private String climate;
  private ArrayList things = new ArrayList<>();

  public Planet() {
    name = "Europa";
    climate = "desert";
    //found = "Thing";
  }

  public String toString() {
    String body = "";
    body += "The planet " + this.name + " is a(n) " + this.climate + " planet.";
    //body += "\n You find a(n) " + this.found + ".";
    return body;
  }

}

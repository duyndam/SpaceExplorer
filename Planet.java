// Import statements
import java.util.ArrayList;
import java.util.Random;
/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

public class Planet {

	static private final String[] PLANET_NAMES = {	"kolvupra", "dotruinia", "batruna",
													"xagnoth", "seutis", "uebos",
													"gidazuno", "moxuphun",	"dippe PJ06", 
													"trars 3" };
	Random randomGenerator = null;
	public Planet()
	{
		randomGenerator = new Random();
	}

  public String toString() {
    String body = "";
    body += "The planet " + this.name + " is a(n) " + this.climate + " planet.";
    //body += "\n You find a(n) " + this.found + ".";
    return body;
  }

}

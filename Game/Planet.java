package Game;
// Import statements
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */


/**
 * Planet class. Player may send a crew member to the nearest planet, where they
 * have a chance of finding:
 *
 * - random amount of money
 * - random food item
 * - random medical item
 * - random spaceship part
 * - nothing :(
 *
 */
public class Planet
{

	private final int MIN_AMOUNT_MONEY = 10;
	private final int MAX_AMOUNT_MONEY = 50;
	private final int MAX_DIFFERENT_PARTS_COUNT = 24;
	static private int MAX_PLANET_COUNT = 10;
	private boolean partFound = false;
	static private final String[] PLANET_NAMES = {	"kolvupra", "dotruinia", "batruna",
													"xagnoth", "seutis", "uebos",
													"gidazuno", "moxuphun",	"dippe PJ06",
													"trars 3" };
	private Random randomGenerator = null;

	/**
	 * Planet constructor.
	 *
	 * initializes the random number generator to be used throughout.
	 */
	public Planet()
	{
		randomGenerator = new Random();
	}

	/**
	 * Medical item generator. Creates randomized medical item to be found.
	 *
	 * @return generatedItem 	medical item, chosen from items.txt
	 */
	public MedicalItem get_RandomMedicalItem()
	{
		MedicalItem generatedItem = new MedicalItem();
		int iChoice = 0;
		iChoice = randomGenerator.nextInt(MedicalItem.AMOUNT_MED_ITEMS);
		iChoice += 24;
		generatedItem.stringIfy(iChoice);
		return generatedItem;
	}

	/**
	 * Food item generator. Creates randomized food item to be found.
	 *
	 * @return generatedItem 	food item, chosen from items.txt
	 */
	public FoodItem get_RandomFoodItem()
	{
		FoodItem generatedItem = new FoodItem();
		int iChoice = 0;
		iChoice = randomGenerator.nextInt(FoodItem.AMOUNT_FOOD_ITEMS);
		generatedItem.stringIfy(iChoice);
		return generatedItem;
	}

	/**
	 * Ship part generator. Creates randomized ship part to be found.
	 *
	 * @return strRandomShipPart 	string with name of part found, from parts.txt
	 */
	public String get_RandomShipPart()
	{
		String strRandomShipPart = "";
		int iChoice = 0;
		iChoice = randomGenerator.nextInt(MAX_DIFFERENT_PARTS_COUNT);
		try
		{

 			FileInputStream fs= new FileInputStream(getClass().getResource("/graphics/parts.txt").getFile());
 			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
 			String[] strLineSplit = null;
 			for (String line = br.readLine(); line != null; line = br.readLine()) {
 				strLineSplit = line.split(",");
 			    if(Integer.toString(iChoice).equals(strLineSplit[0]))
 			    {
 			    	strRandomShipPart = strLineSplit[1];
 			    }
 			}
		}catch(Exception e)
		{

		}
		return strRandomShipPart;
	}

	/**
	 * Money generator. Creates random amount of money to be found.
	 *
	 * @return iMoney 	Integer amount of money
	 */
	public int get_RandomAmountMoney()
	{
		int iMoney = 0;
		iMoney = randomGenerator.nextInt(MAX_AMOUNT_MONEY - MIN_AMOUNT_MONEY + 1) + MIN_AMOUNT_MONEY;
		return iMoney;
	}

	/**
	 * Finding method - determines if a part will be found on the planet.
	 *
	 * @return true 		if player finds a part on the planet
	 * @return false    if player does not find a part
	 */
	public boolean findingPart()
	{
		if(!partFound)
		{
			partFound = true;
			return true;
		}
		else
		{
			return false;
		}
	}

}

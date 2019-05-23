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

public class Planet {

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
	public Planet()
	{
		randomGenerator = new Random();
	}

	public MedicalItem get_RandomMedicalItem()
	{
		MedicalItem generatedItem = new MedicalItem();
		int iChoice = 0;
		iChoice = randomGenerator.nextInt(MedicalItem.MEDIC_INDEX_MIN + MedicalItem.AMOUNT_MED_ITEMS - MedicalItem.MEDIC_INDEX_MIN +1) + MedicalItem.MEDIC_INDEX_MIN;
		generatedItem.stringIfy(iChoice);
		return generatedItem;
	}
	
	public FoodItem get_RandomFoodItem()
	{
		FoodItem generatedItem = new FoodItem();
		int iChoice = 0;
		iChoice = randomGenerator.nextInt(FoodItem.AMOUNT_FOOD_ITEMS);
		generatedItem.stringIfy(iChoice);
		return generatedItem;
	}
	
	public String get_RandomShipPart()
	{
		String strRandomShipPart = "";
		int iChoice = 0;
		iChoice = randomGenerator.nextInt(MAX_DIFFERENT_PARTS_COUNT);
		try 
		{
			
 			FileInputStream fs= new FileInputStream("txts/parts.txt");
 			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
 			String[] strLineSplit = null;
 			for (String line = br.readLine(); line != null; line = br.readLine()) {
 				strLineSplit = line.split(",");
 			    if(Integer.toString(iChoice) == strLineSplit[0])
 			    {
 			    	strRandomShipPart = strLineSplit[1];
 			    }
 			}
		}catch(Exception e)
		{
			
		}
		return strRandomShipPart;
	}
	
	public int get_RandomAmountMoney()
	{
		int iMoney = 0;
		iMoney = randomGenerator.nextInt(MAX_AMOUNT_MONEY - MIN_AMOUNT_MONEY + 1) + MIN_AMOUNT_MONEY;
		return iMoney;
	}
	
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

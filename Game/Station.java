package Game;
// Import statements
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */


/**
 * Station object. Upon initialization, generates a random list of Food and/or
 * Medical items. The player may visit this station and buy/sell whenever they wish.
 *
 */
public class Station
{
    ArrayList<Item> availableItems;
    Random randomGenerator = null;

	private final int MAX_NUMBER_FOOD_ITEMS = 8;
	private final int MIN_NUMBER_FOOD_ITEMS = 2;

    private final int MAX_NUMBER_MEDICAL_ITEMS = 4;
    private final int MIN_NUMBER_MEDICAL_ITEMS = 1;


 /**
  * Null constructor. Left in for redundancy.
  *
  * @return null 			nothing :(
  */
    public String showOutpostMenu()
    {
        return null;
    }

    /*
    NOTE: the following methods are not used in current version -- REMOVE?

    public String showItemsForSale()
    {
        String strItemsForSale = "";
        for(int iIndex = 0; iIndex < availableItems.size(); ++iIndex)
        {
            strItemsForSale += availableItems.get(iIndex).get_Name();
            if(!(iIndex == availableItems.size()-1))
            {
                strItemsForSale += "|";
            }
        }
        return strItemsForSale;
    }


    public String showItemsAndMoneyPossesion(List<Item> crewPossesion, int crewMoney)
    {
        String strItemsPossesionAndMoney = "";
        for(int iIndex = 0; iIndex < crewPossesion.size(); ++iIndex)
        {
            strItemsPossesionAndMoney += crewPossesion.get(iIndex).get_Name();
            if(!(iIndex == crewPossesion.size()-1))
            {
                strItemsPossesionAndMoney += "|";
            }
        }
        return strItemsPossesionAndMoney;
    }

    public String showPrices(List<Item> crewPossesion)
    {
        String strPrices = "";
        Item indexItem = null;
        for(int iIndex = 0; iIndex < availableItems.size(); ++iIndex)
        {
            indexItem = availableItems.get(iIndex);
            strPrices += indexItem.get_Name() + ":" + indexItem.get_BuyPrice() + "/" + indexItem.get_SellPrice();
            if(!(iIndex == crewPossesion.size()-1))
            {
                strPrices += "|";
            }
        }
        strPrices += "Crew Possession: ";
        for(int iIndex = 0; iIndex < crewPossesion.size(); ++iIndex)
        {
            indexItem = crewPossesion.get(iIndex);
            strPrices += indexItem.get_Name() + ":" + indexItem.get_BuyPrice() + "/" + indexItem.get_SellPrice();
            if(!(iIndex == crewPossesion.size()-1))
            {
                strPrices += "|";
            }
        }
        return strPrices;
    }

    public String showAttributes(List<Item> crewPossesion)
    {
        String strAttributes = "";
        Item indexItem = null;
        for(int iIndex = 0; iIndex < availableItems.size(); ++iIndex)
        {
            indexItem = availableItems.get(iIndex);
            if(indexItem instanceof FoodItem)
            {
                strAttributes += indexItem.get_Name() + ": Reduces Hunger level by " + indexItem.get_Value() + "%";
                if(!(iIndex == availableItems.size()-1))
                {
                    strAttributes += "|";
                }
            }
            else if(indexItem instanceof MedicalItem)
            {
                    strAttributes += indexItem.get_Name() + ": Heals a crew member by " + indexItem.get_Value() + "%";
                    if(!(iIndex == availableItems.size()-1))
                    {
                        strAttributes += "|";
                    }
            }
            else
            {

            }

        }
        return strAttributes;
    }

    public String purchaseObject(List<Item> crewPossesion, int money, String name)
    {
        String strPurchase = "";
        Item indexItem = null;
        int iRemoveIndex = -1;
        for(int iIndex = 0; iIndex < crewPossesion.size(); ++iIndex)
        {
            indexItem = availableItems.get(iIndex);
            if(indexItem.get_Name() == name)
            {
                strPurchase += indexItem.get_Name() + " was purchased for " + indexItem.get_BuyPrice() + " asteroidCoins";
                money -= indexItem.get_BuyPrice();
                iRemoveIndex = iIndex;
                crewPossesion.add(indexItem);
                break;
            }
        }
        availableItems.remove(iRemoveIndex);
        return strPurchase;
    }

    public String sellObject(List<Item> crewPossesion, int money, String name)
    {
        String strPurchase = "";
        Item indexItem = null;
        int iRemoveIndex = -1;
        for(int iIndex = 0; iIndex < crewPossesion.size(); ++iIndex)
        {
            indexItem = crewPossesion.get(iIndex);
            if(indexItem.get_Name() == name)
            {
                strPurchase += indexItem.get_Name() + " was sold for " + indexItem.get_SellPrice() + " asteroidCoins";
                money += indexItem.get_SellPrice();
                iRemoveIndex = iIndex;
                availableItems.add(crewPossesion.get(iRemoveIndex));
                break;
            }
        }
        crewPossesion.remove(iRemoveIndex);
        return strPurchase;
    }*/

    /**
     * Station constructor; initializes a new station object and generates its
     * available items.
     *
     */
  public Station()
    {
        availableItems = new ArrayList<Item>();
        randomGenerator = new Random();

	int numMed = randomGenerator.nextInt(MAX_NUMBER_MEDICAL_ITEMS - MIN_NUMBER_MEDICAL_ITEMS)+MIN_NUMBER_MEDICAL_ITEMS;
	int numFood = randomGenerator.nextInt(MAX_NUMBER_FOOD_ITEMS - MIN_NUMBER_FOOD_ITEMS)+MIN_NUMBER_FOOD_ITEMS;
    for(int iMedItemAmount = 0; iMedItemAmount < numMed; iMedItemAmount++)
    {
        int itemNum = randomGenerator.nextInt(MedicalItem.AMOUNT_MED_ITEMS);
        itemNum += 24;
        MedicalItem meds = new MedicalItem();
        meds.stringIfy(itemNum);
        availableItems.add(meds);
    }
    for(int iFoodItemAmount = 0; iFoodItemAmount < numFood; iFoodItemAmount++)
    {
        int itemNum = randomGenerator.nextInt(FoodItem.AMOUNT_FOOD_ITEMS);
        FoodItem food = new FoodItem();
        food.stringIfy(itemNum);
        availableItems.add(food);
    }

  }


    /**
     * Station toString.
     * Outputs all available items with associated attributes.
     *
     * @return shopInventory string with all items + attributes.
     */
    public String toString()
    {
    String shopInventory = "";
    int counter = 0;
    for (Item product: availableItems) {

        
      shopInventory +=  (counter+1) + ": " + product.toString() + "\n";
      counter++;
    }
    shopInventory += (counter+1) + ": leave Outpost";
    return shopInventory;
  }
    public List<Item> get_ItemList()
    {
    	return this.availableItems;
    }
    
    public int get_ItemCount()
    {
        return availableItems.size();
    }

}

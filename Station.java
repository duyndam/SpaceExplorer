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
	List<Item> availableItems;
	
	
	public Station()
	{
		
	}
	
	public String showOutpostMenue()
	{
		return null;
	}
	
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
	
	/**
    View objects, such as food and medical supplies that are for sale.

  Random rand = new Random();

  private int numMed = rand.nextInt(6);
  private int numFood = rand.nextInt(6);
  ArrayList<Item> wares;

  public Station() {
    numFood += 1;
    numMed += 1;
    wares = new ArrayList<>();
  }

  public void populateStation() {
    for (int i = 0; i <= numMed; i++) {
      MedicalItem meds = new MedicalItem();
      wares.add(meds);
    }
    for (int j = 0; j <= numFood; j++) {
      FoodItem food = new FoodItem();
      wares.add(food);
    }
  }

  public String toString() {
    String shopInventory = "";
    for (Item product: wares) {
      shopInventory += "\n" + product.toString();
    }
    return shopInventory;
  }
}

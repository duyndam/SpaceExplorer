import java.io.*;

/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

enum typeFood
{
	MEAT,
	FRUIT,
	DAIRY,
	POULTRY,
	VEGETABLE,
	LIQUID
}

public class FoodItem extends Item{
	static final int AMOUNT_FOOD_ITEMS = 24;

	private typeFood m_Type = typeFood.MEAT;

	/**
	 * Getter method for food Item
	 *
	 * @return      the type of food, e.g. Meat, vegetable - this affects m_value
	 */
	public typeFood get_Type() {
		return m_Type;
	}

	/**
	 * Setter method for food Item
	 *
	 * @param m_Type the type of food, e.g. Meat, vegetable - this affects m_value
	 */
	public void set_Type(typeFood m_Type) {
		this.m_Type = m_Type;
	}

  /**
	 * Food item toString method - calls to superclass toString method.
	 *
	 * @return       string containing the type of food, and associated attributes
	 */

	 public void stringIfy(int choice) {
		 try {
 			//FileInputStream fs= new FileInputStream("/graphics/items.txt");
 			FileInputStream fs= new FileInputStream(getClass().getResource("/graphics/items.txt").getFile());
 		  BufferedReader br = new BufferedReader(new InputStreamReader(fs));

 		  for(int i = 0; i < choice; ++i)
 		  {
 		    br.readLine();
 		  }

 		  String lineIWant = br.readLine();
 			String details[] = lineIWant.split(",");
			super.stringIfy(choice);
	 		if (choice < 24)
	 		{
	 			if (details[2].equals("0"))
	 			{
	 				this.set_Type(typeFood.MEAT);
	 			}
	 			else if (details[2].equals("1"))
	 			{
	 				this.set_Type(typeFood.FRUIT);
	 			}
				else if (details[2].equals("2"))
	 			{
	 				this.set_Type(typeFood.DAIRY);
	 			}
				else if (details[2].equals("3"))
	 			{
	 				this.set_Type(typeFood.POULTRY);
	 			}
				else if (details[2].equals("4"))
	 			{
	 				this.set_Type(typeFood.VEGETABLE);
	 			}
				else
	 			{
	 				this.set_Type(typeFood.LIQUID);
	 			}
	 		}
			super.set_Name(details[1]);
			super.set_BuyPrice(Integer.parseInt(details[3]));
			super.set_SellPrice(Integer.parseInt(details[4]));
			super.set_Value(Integer.parseInt(details[5]));
		}
		catch (IOException exception) {
			System.out.println(":(");
		}

 	}

	 public String toString() {
		    String strItem = this.m_Type + " " + super.toString();
		    return strItem;
		  }

}

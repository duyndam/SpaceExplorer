/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

/**
 * Item class, used by outposts, crew, and planets.
 *
 * Items may be bought and sold by the crew at outposts.
 *
 * Items may also be found on planet surfaces.
 *
 * There are two subclasses of Item:
 * 				FoodItem | MedicalItem
 * Each has subtypes which detail the items' effects.
 */
public class Item {
	private String m_Name = "Default";
	private int m_BuyPrice = -1;
	private int m_SellPrice = -1;
	private int m_Value = -1;

	/**
	 * name Getter method - primarily flavour text, though some items' names
	 * have associated nutritional value.
	 *
	 * @return       the name of the item, e.g. "Energy Bar", "Pizza"
	 */

	public Item() {
		
	}
	public String get_Name() {
		return m_Name;
	}

	/**
	 * name Setter method - primarily flavour text, though some items' names
	 * have associated nutritional value.
	 *
	 * @param m_Name the name to set
	 */
	public void set_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	/**
	 * Item cost Getter method
	 *
	 * @return        the price of the item in the outpost store
	 */
	public int get_BuyPrice() {
		return m_BuyPrice;
	}

	/**
	 * Item cost Setter method
	 *
	 * @param m_BuyPrice price to set
	 */
	public void set_BuyPrice(int m_BuyPrice) {
		this.m_BuyPrice = m_BuyPrice;
	}

	/**
	 * Gets the price that the crew can sell the Item for
	 *
	 * @return         price the item can be sold to an outpost for
	 */
	public int get_SellPrice() {
		return m_SellPrice;
	}

	/**
	 * Sets the price that the crew can sell the Item for
	 *
	 * @param m_SellPrice sell price to set
	 */
	public void set_SellPrice(int m_SellPrice) {
		this.m_SellPrice = m_SellPrice;
	}

	/**
	 * @return        the nutritional value/healing value of the item
	 */
	public int get_Value() {
		return m_Value;
	}

	/**
	 * @param m_Value the m_Value to set
	 */
	public void set_Value(int m_Value) {
		this.m_Value = m_Value;
	}
  /**
	 * Item toString method
	 *
	 * @return        string containg all attributes of the Item
	 */
  public String toString() {
	    String strItem =  m_Name + " | Buy: " + m_BuyPrice + " | Sell: " + m_SellPrice + " | Attribute(s): " + m_Value;
	    return strItem;
	  }

}

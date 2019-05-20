/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class Item {
	private String m_Name = "Default";
	private int m_BuyPrice = -1;
	private int m_SellPrice = -1;
	private int m_Value = -1;

	/**
	 * Flavour text
	 * @return the name of the item, e.g. "Energy Bar", "Pizza"
	 */
	public String get_Name() {
		return m_Name;
	}

	/**
	 * Flavour text
	 * @param m_Name the name to set
	 */
	public void set_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	/**
	 * @return the price of the item in the outpost store
	 */
	public int get_BuyPrice() {
		return m_BuyPrice;
	}

	/**
	 * @param m_BuyPrice price to set
	 */
	public void set_BuyPrice(int m_BuyPrice) {
		this.m_BuyPrice = m_BuyPrice;
	}

	/**
	 * @return price the item can be sold to an outpost for
	 */
	public int get_SellPrice() {
		return m_SellPrice;
	}

	/**
	 * @param m_SellPrice sell price to set
	 */
	public void set_SellPrice(int m_SellPrice) {
		this.m_SellPrice = m_SellPrice;
	}

	/**
	 * @return the nutritional value/healing value of the item
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

  public String toString() {
	    String strItem =  m_Name + " | Buy: " + m_BuyPrice + " | Sell: " + m_SellPrice + " | Attribute(s): " + m_Value;
	    return strItem;
	  }

}

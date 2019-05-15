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
	 * @return the m_Name
	 */
	public String get_Name() {
		return m_Name;
	}

	/**
	 * @param m_Name the m_Name to set
	 */
	public void set_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	/**
	 * @return the m_BuyPrice
	 */
	public int get_BuyPrice() {
		return m_BuyPrice;
	}

	/**
	 * @param m_BuyPrice the m_BuyPrice to set
	 */
	public void set_BuyPrice(int m_BuyPrice) {
		this.m_BuyPrice = m_BuyPrice;
	}

	/**
	 * @return the m_SellPrice
	 */
	public int get_SellPrice() {
		return m_SellPrice;
	}

	/**
	 * @param m_SellPrice the m_SellPrice to set
	 */
	public void set_SellPrice(int m_SellPrice) {
		this.m_SellPrice = m_SellPrice;
	}

	/**
	 * @return the m_Value
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
	    String strItem =  m_Name + " | " + m_BuyPrice + " | " + m_SellPrice + " | " + m_Value;
	    return strItem;
	  }

}

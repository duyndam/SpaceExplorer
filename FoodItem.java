/**
 * @author      Royal Duyndam, Alex Siegmund
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
	private typeFood m_Type = typeFood.MEAT;

	/**
	 * @return the m_Type
	 */
	public typeFood get_Type() {
		return m_Type;
	}

	/**
	 * @param m_Type the m_Type to set
	 */
	public void set_Type(typeFood m_Type) {
		this.m_Type = m_Type;
	}

	 public String toString() {
		    String strItem =  m_Type + super.toString();
		    return strItem;
		  }

}

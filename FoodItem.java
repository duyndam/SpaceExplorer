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
	 public String toString() {
		    String strItem =  m_Type + " " + super.toString();
		    return strItem;
		  }

}

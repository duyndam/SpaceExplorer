enum typeMedical
{
	BANDAGE,
	PAINKILLER,
	CURES_SPACE_PLAGUE
}

/**
 * Subclass that extends the generalized Item class. Includes two types of
 * item, one that heals damage to crew health, and one that cures a crew member
 * of space plague.
 *
 * Actual amounts healed vary based on the item's "m_value"
 */
public class MedicalItem extends Item{
	static final int AMOUNT_MED_ITEMS = 5;
	
	private typeMedical m_Type = typeMedical.HEALING;

	/**
	 * Getter method for medical Item
	 *
	 * @return the type of item, e.g. anti-space plague medicine
	 */
	public typeMedical get_Type() {
		return m_Type;
	}

	/**
	 * setter method for medical Item
	 *
	 * @param the type of item, e.g. anti-space plague medicine
	 */
	public void set_Type(typeMedical m_Type) {
		this.m_Type = m_Type;
	}
	 public String toString() {
		    String strItem =  m_Type + " " + super.toString();
		    return strItem;
		  }

}

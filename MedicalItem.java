enum typeMedical
{
	HEALING,
	CURES_SPACE_PLAGUE
}
public class MedicalItem extends Item{
	private typeMedical m_Type = typeMedical.HEALING;

	/**
	 * @return the m_Type
	 */
	public typeMedical get_Type() {
		return m_Type;
	}

	/**
	 * @param m_Type the m_Type to set
	 */
	public void set_Type(typeMedical m_Type) {
		this.m_Type = m_Type;
	}
	 public String toString() {
		    String strItem =  m_Type + super.toString();
		    return strItem;
		  }

}

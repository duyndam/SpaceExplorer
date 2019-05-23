import java.io.*;


enum typeMedical
{
	BANDAGE,
	PAINKILLER,
	CURES_SPACE_PLAGUE
}

/**
 * Subclass that extends the generalized Item class. Includes three types of
 * item, two that heal damage to crew health, and one that cures a crew member
 * of space plague.
 *
 * Actual amounts healed vary based on the item's "m_value"
 */
public class MedicalItem extends Item{
	private typeMedical m_Type = typeMedical.BANDAGE;
	static final int AMOUNT_MED_ITEMS = 12;
	static final int MEDIC_INDEX_MIN = 24;

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

	public void stringIfy(int choice) {
		try {
			FileInputStream fs= new FileInputStream("/Users/Royal/Desktop/Game/items.txt");
		  BufferedReader br = new BufferedReader(new InputStreamReader(fs));

		  for(int i = 0; i < choice; ++i)
		  {
		    br.readLine();
		  }

		  String lineIWant = br.readLine();
			String details[] = lineIWant.split(",");
			super.stringIfy(choice);
			if (choice >= MEDIC_INDEX_MIN)
			{
				if (details[2].equals("0"))
				{
					this.set_Type(typeMedical.BANDAGE);
				}
				else if (details[2].equals("1"))
				{
					this.set_Type(typeMedical.PAINKILLER);
				}
				else
				{
					this.set_Type(typeMedical.CURES_SPACE_PLAGUE);
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

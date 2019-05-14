// Import statements
import java.util.ArrayList;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class CrewMember {
	static enum type
	{
		PILOT,
		ENGINEER,
		SOLDIER,
		MEDICAL_OFFICER,
		SCAVENGER,
		NAVIGATOR
	}
	static enum status
	{
		NORMAL,
		CURED,
		SPACE_PLAGUE_INFECTED
	}
  private type job;
  private status state;
  private String name;
  private int health;
  private int hunger;
  private int fatigue;
  private ArrayList<String> actionList;

  /*public CrewMember() {
    job = type.PILOT;
    name = "Yuri";
    health = 100;
    hunger = 0;
    fatigue = 0;
  }*/

  public CrewMember(String crewName, type role)
  {
	  name = crewName;
	  job = role;
	  health = 100;
	  hunger = 0;
	  fatigue = 0;
	  actionList = new ArrayList<>();
  }
  public CrewMember(type role, String crewName, int vitality, int food) {
    job = role;
    name = crewName;
    health = vitality;
    hunger = food;
    fatigue = 0;
	actionList = new ArrayList<>();
  }

  public boolean doAction(String actionLogMessage)
  {
	  if(actionList.size() < 2)
	  {
		  actionList.add(actionLogMessage);
		  return true;
	  }
	  return false;
  }

  public boolean undoAction(String actionLogMessage)
  {
	  if(actionList.size() == 0)
	  {
		  return false;
	  }
	  else
	  {
		  actionList.remove(actionLogMessage);
		  return true;
	  }
  }

  public void setName(String crewName) {
    name = crewName;
  }

  public String getName() {
    return name;
  }

  public void updateHealth(int amount) {
    health += amount;
  }

  public int getHealth() {
    return health;
  }

  public void updateHunger(int amount) {
    hunger += amount;
  }

  public int getHunger() {
    return hunger;
  }

  public void updateFatigue(int amount) {
    fatigue += amount;
  }

  public int getFatigue() {
    return fatigue;
  }

  //adapted toString function
  public String toString() {
    String crewString = "--------------------\n";
    crewString += "Name    : " + name + "\n";
    crewString += "Type    : " + job + "\n";
    crewString += "State   : " + state + "\n";
    crewString += "Health  : " + health + "\n";
    crewString += "Hunger  : " + hunger + "\n";
    crewString += "Fatigue : " + fatigue + "\n";
    crewString += "--------------------\n";
    return crewString;
  }
/**
 * @return the state
 */
public status getState() {
	return state;
}
/**
 * @param state the state to set
 */
public void setState(status state) {
	this.state = state;
}

}

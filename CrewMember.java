// Import statements
import java.util.ArrayList;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

/**
 * Crew members which are added to the Crew class upon initialisation of the
 * game instance.
 *
 * Each crew member has a Name, Job, Health level, Fatigue level, Hunger level,
 * and State.
 *
 * Name                   : string of any length, has no effect on gameplay.
 * Job                    : type, affects daily actions and random events.
 * Health, Fatigue, Hunger: all integer values, increase/decrease when actions are
 * performed or when time is advanced.
 * State                  : type, either HEALTHY (default) or SPACE_PLAGUE_INFECTED,
 * which causes health to decrease over time until removed by medicine.
 *
 */
public class CrewMember {
	static enum type
	{
		PILOT,
		ENGINEER,
		SOLDIER,
		DOCTOR,
		SCAVENGER,
		NAVIGATOR
	}
	static enum status
	{
		HEALTHY,
		SPACE_PLAGUE_INFECTED
	}
  public type job;
  private status state;
  private String name;
  private int health;
  private int hunger;
  private int fatigue;
  private ArrayList<String> actionList;

	/**
	 * Initialise a new CrewMember with input name and role.
	 *
	 * Other attributes are default.
	 *
	 * @param crewName string input my player.
	 * @param role     type chosen by player, stored as job.
	 */
  public CrewMember(String crewName, type role) {
	  name = crewName;
	  job = role;
	  health = 100;
	  hunger = 0;
	  fatigue = 0;
		state = status.HEALTHY;
	  actionList = new ArrayList<>();
  }

	/**
	 * Initialise a new CrewMember with input name, role, and other attributes.
	 *
	 * @param role     type chosen by player, stored as job.
	 * @param crewName string
	 * @param vitality health value to initialise.
	 * @param food     hunger value to initialise.
	 * @param tired    fatigue value to initialise.
	 */
  public CrewMember(type role, String crewName, int vitality, int food, int tired) {
    job = role;
    name = crewName;
    health = vitality;
    hunger = food;
    fatigue = tired;
		state = status.HEALTHY;
	  actionList = new ArrayList<>();
  }

	/**
	 * Crew member does an action.
	 *
	 * Adds an action to the list of actions performed by this crew member on the
	 * current day. This list is reset at the start of every new day.
	 */
  public boolean doAction(String actionLogMessage)
  {
	  if(actionList.size() < 2)
	  {
		  actionList.add(actionLogMessage);
		  return true;
	  }
	  return false;
  }

	/**
	 * Crew member undoes an action.
	 *
	 * This method should never be called, since players cannot undo actions - it's
	 * only here for redundancy.
	 *
	 * Removes an action from the list of actions performed by this crew member on the
	 * current day. This list is reset at the start of every new day.
	 */
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

  /**
	 * Getters and setters for crew member attributes.
	 *
	 * these are called primarily by the ConsoleGame class.
	 */
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

	public status getState() {
		return state;
	}

	public void setState(status state) {
		this.state = state;
	}

  /**
	 * Crew member toString method
	 *
	 * @return      string containing all CrewMember attributes, nicely formatted.
	 */
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

}

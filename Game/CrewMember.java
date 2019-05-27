package Game;
// Import statements
import java.util.ArrayList;

/**
 * @author      Alexander Siegmund, Royal Duyndam
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
public class CrewMember
{
	final int MAX_ACTION_COUNT = 2;
	static final String PILOTING_ACTION = " is piloting the ship";
	static final String ITEM_ACTION   = " is using an item.";
	static final String SLEEPING_ACTION = " is sleeping";
	static final String VISIT_PLANET_ACTION = " is visiting a planet";
	static final String REPAIR_ACTION   = " is repairing the ship";

	public static enum type
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
  public CrewMember(String crewName, type role)
	{
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
  public CrewMember(type role, String crewName, int vitality, int food, int tired)
	{
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
	 *
	 * @return true 	if action was completed successfully.
	 * @return false  if crew member is already doing action.
	 */
  public boolean doAction(String actionLogMessage)
  {
	  if(actionList.contains(actionLogMessage))
	  {
		  return false;
	  }
	  if(actionList.size() < MAX_ACTION_COUNT)
	  {
		  actionList.add(actionLogMessage);
		  return true;
	  }
	  return false;
  }
  
  public boolean isActionDoAble(String actionLogMessage)
  {
	  if(actionList.contains(actionLogMessage))
	  {
		  return false;
	  }
	  if(actionList.size() >= MAX_ACTION_COUNT)
	  {
		  return false;
	  }
	  else
	  {
		  return true;
	  }
	  
  }
  
  public String get_ActionWithCount()
  {
	  String strActionWithCount = "";
	  strActionWithCount += "," + this.name;
	  strActionWithCount += ",(" + actionList.size() + "/" + MAX_ACTION_COUNT + ")";
	  strActionWithCount += "," + actionList.size();
	  for(int iActionIndex = 0; iActionIndex < actionList.size(); iActionIndex++)
	  {
		  strActionWithCount += ",..." + actionList.get(iActionIndex); 
	  }
	  strActionWithCount += "," + this.job;
	  return strActionWithCount;
  }

	/**
	 * Crew member undoes an action.
	 *
	 * This method should never be called, since players cannot undo actions - it's
	 * only here for redundancy.
	 *
	 * Removes an action from the list of actions performed by this crew member on the
	 * current day. This list is reset at the start of every new day.

	 * @return true 	if action was completed successfully.
	 * @return false  if crew member is already doing action.
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
	 * Clears the list of actions the crew member is performing. Called at the end
	 * of each day.
	 */
	public void clearActions()
	{
		actionList.clear();
	}

	/**
	 * Updates the crew member health when taking damage/healing.
	 *
	 * @return true 	if crew member dies (health <= 0)
	 * @return false 	if health updated successfully without dying
	 */
	public boolean updateHealth(int amount)
	{
      if(amount > 0 && health+amount > 100)
			{
      	health = 100;
      }
      else
			{
      	health += amount;
      }
      if (health <= 0)
			{
        return true;
      }
      else
			{
      	return false;
      }
    }

	/**
	 * Updates the crew member hunger daily and when eating.
	 *
	 * @return true 	if crew member is starving (takes damage)
	 * @return false 	if hunger updated successfully
	 */
	public boolean updateHunger(int amount)
	{
			if(amount > 0 && hunger + amount > 100)
			{
				hunger = 100;
				return true;
			}
			else if (amount < 0 && hunger + amount < 0)
			{
				hunger = 0;
				return false;
			}
			else
			{
				hunger += amount;
				return false;
			}
		}

	/**
	 * Updates the crew member hunger daily and when eating.
	 *
	 * @return true 	if crew member is exhausted (cannot take actions)
	 * @return false 	if fatigue updated successfully
	 */
	public boolean updateFatigue(int amount)
	{
		if(amount > 0 && fatigue + amount > 100)
		{
			fatigue = 100;
			return true;
		}
		else if (amount < 0 && fatigue + amount < 0)
		{
			fatigue = 0;
			return false;
		}
		else
		{
			fatigue += amount;
			return false;
		}
	}

	/**
	 * Set name of the crew member.
	 *
	 * @param crewName string name to set
	 */
	public void setName(String crewName)
	{
		name = crewName;
	}

	/**
	 * Sets the state of the crew member - e.g. Healthy
	 *
	 * @param state 	status enum
	 */
	public void setState(status state)
	{
		this.state = state;
	}

	/**
	 * Get name of the crew member.
	 *
	 * @return name 	string name
	 */
  public String getName()
	{
    return name;
  }

	/**
	 * Get the crew member's health.
	 *
	 * @return health 	integer health value
	 */
	public int getHealth()
	{
		return health;
	}

	/**
	 * Get the crew member's hunger.
	 *
	 * @return hunger 	integer hunger value
	 */
	public int getHunger()
	{
		return hunger;
	}

	/**
	 * Get the crew member's fatigue.
	 *
	 * @return fatigue 	integer fatigue value
	 */
  public int getFatigue()
	{
    return fatigue;
  }

	/**
	 * Get the crew member's state.
	 *
	 * @return state 	state type, e.g. SPACE_PLAGUE_INFECTED
	 */
	public status getState()
	{
		return state;
	}

	/**
	 * Get the crew member's type.
	 *
	 * @return job  	type, e.g. PILOT
	 */
	public type getType()
	{
		return job;
	}

	/**
	 * Generates a string of all actions being performed by the crew member.
	 *
	 * @return strActionCountString 	string containing the crew member's actions.
	 */
	public String getActionCountString()
	{
		String strActionCountString = "";
		strActionCountString += ("(" + actionList.size() + "/" + MAX_ACTION_COUNT + ") Actions");
		for(int iActionIndex = 0; iActionIndex < actionList.size(); iActionIndex++)
		{
			strActionCountString += "\n..." + actionList.get(iActionIndex);
		}
		return strActionCountString;
	}

	
	public String serialize()
	{
		String strSerialized = ",";
		strSerialized += name + ",";
		strSerialized += health + ",";
		strSerialized += fatigue + ",";
		strSerialized += hunger + ",";
		strSerialized += state + ",";
		strSerialized += job;
		return strSerialized;
	}
  /**
	 * Crew member toString method
	 *
	 * @return      string containing all CrewMember attributes, nicely formatted.
	 */
  public String toString()
	{
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

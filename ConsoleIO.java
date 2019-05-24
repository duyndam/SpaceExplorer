// Import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author      Alexander Siegmund, Royal Duyndam
 * @version     0.1.0
 * @since       0.0.0
 */

/**
 * Essentially a printer. Prints all outputs from the ConsoleGame to the terminal
 * window.
 *
 * ConsoleGame will call methods within this class when actions occur.
 *
 * When running the GUI version of the game, ConsoleIO is not used.
 */
public class ConsoleIO
{

  public static void printGameLength()
  {
    System.out.println("[ How many days do you want to play for? (3-10) ]");
  }

  public void printCrewInit()
  {
    System.out.println("[ Choose the number of crew members you would like (2-4) ]");
  }

  public void printCrewInstructions(int iCrewIndex)
  {
    System.out.println("--------------------- Creation of Crew member " + (iCrewIndex + 1) + " ----------------------\n");
    System.out.println("---How to create a crew member---");
    System.out.println("Enter First line : [name] e.g. Yuri");
    System.out.println("Enter Second line: [type] e.g. 1");
    System.out.println("\nCrew member types may be stacked, e.g. multiple Pilots.");
    System.out.println("\n----------------------------------------------------------------------");
    System.out.println("Crew Specializations (You may choose more than one of each):\n");
    System.out.println("1: PILOT - Reduces damage taken from asteroid belts.");
    System.out.println("2: ENGINEER - Repairs the ship more effectively.");
    System.out.println("3: SOLDIER - Decreases chance of an alien attack.");
    System.out.println("4: DOCTOR - Decreases chance of space plague infection.");
    System.out.println("5: SCAVENGER - Increases chance of finding ship parts.");
    System.out.println("6: NAVIGATOR - Decreases the chance of going through an asteroid belt.");
    System.out.println("----------------------------------------------------------------------");
  }

  public void printAreYouSure(String strName, CrewMember.type inputType)
  {
    System.out.println("[ Are you sure you want to create the crew member: " + strName + " as a(n) " + inputType + "? (y/n) ]");
  }

  public void printCrewError()
  {
    System.out.println("[ That is not a valid crew type. ]");
  }

  public void printShipCreate()
  {
    System.out.println("-------------------------- Creation of Ship --------------------------");
    System.out.println("[ Enter a name for your ship. ]");
  }

  public void printShipConfirm(String strName)
  {
    System.out.println("[ Do you want to name your ship " + strName + "? (y/n) ]");
  }

  public void printAdvConfirm(Crew gameCrew)
  {
    System.out.println("--- This would be your crew ---");
    System.out.println(gameCrew.toString());
    System.out.println("[ Are you sure you want to start the adventure? (y/n) ]");
  }

  public void printAdvStart()
  {
    System.out.println("[ The adventure begins! ]" );
  }

  public void printOutpostMenu()
  {
    System.out.println("--- Remote Outpost ---");
    System.out.println("\nOutpost menu: ");
    System.out.println("1: Show station inventory");
    System.out.println("2: Show ship inventory");
    System.out.println("3: Exit Outpost");
  }

  public void printOutpostInventory(Station outpost)
  {
    System.out.println(outpost.toString());
  }

  public void printCrewInventory(Crew gameCrew)
  {
    System.out.println("--- Items on board the " + gameCrew.crewShip.getName() + " ---");
    System.out.println(gameCrew.cargoHold());
  }

  public void printPlanet(Planet body)
  {
    System.out.println(body.toString());
  }

  public void printDailyMenu()
  {
    System.out.println("--- Day " + StartGame.m_iActualDay + " ---");
    System.out.println("Choose your action: ");
    System.out.println("1: Show crew status");
    System.out.println("2: Show spaceship status");
    System.out.println("3: Visit nearest outpost");
    System.out.println("4: Do crew action");
    System.out.println("5: Move on to next day");
  }

  public void printCrewStatus(Crew gameCrew)
  {
    System.out.println(gameCrew.toString());
  }

  public void printShipStatus(Crew gameCrew)
  {
    System.out.println(gameCrew.crewShip.toString());
  }

  public void printCrewActions()
  {
    System.out.println("--------------------------");
    System.out.println("Potential Crew Actions: ");
    System.out.println("1: Pilot ship");
    System.out.println("2: Use item");
    System.out.println("3: Sleep");
    System.out.println("4: Visit planet");
    System.out.println("5: Repair ship");
    System.out.println("6: Exit");
  }

  public void printCrewChooser(String strCrewMemberActionChooser)
  {
	  System.out.print(strCrewMemberActionChooser);
  }

  public void printActionCrewMemberDoes(String strCrewMemberAction)
  {
	  System.out.println(strCrewMemberAction);
  }

  public void printDoingActionAlready()
  {
	  System.out.println("[ This action can not be done!");
  }

  public void printAsteroids(int damage)
  {
    System.out.println("[ You fly through an asteroid belt, colliding with some large rocks... ]");
    System.out.println("[ Your ship takes " + -damage + "points of damage. ]");
  }

  public void printPirates()
  {
    System.out.println("[ Pirates board your ship while you sleep, stealing an item! ]");
  }

  public void printPlague()
  {
    System.out.println("[ A member of your crew comes down with a strange illness. ]");
  }

  public void printBuy(Item item)
  {
    System.out.println("[ You buy " + item.get_Name() + " for " + item.get_BuyPrice() + " credits. ]");
  }

  public void printSell(Item item)
  {
    System.out.println("[ You sell " + item.get_Name() + " for " + item.get_SellPrice() + " credits. ]");
  }

  public void printNothing()
  {
    System.out.println("You don't find anything :(");
  }
}

// Import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class ConsoleIO {

  public static void printGameLength() {
    System.out.println("How many days you wanna play this game?(3-10): ");
  }

  public void printCrewInit() {
    System.out.println("Choose the amount of crew members you would like(2-4): ");
  }

  public void printCrewInstructions(int iCrewIndex) {
    System.out.println("--------------------- Creation of Crew member " + (iCrewIndex + 1) + " ----------------------");
    System.out.println("---How to create a crew member---");
    System.out.println("First line : [name] e.g. Yuri");
    System.out.println("Second line: [type] e.g. 1");
    System.out.println("----------------------------------------------------------------------");
    System.out.println("Types(1-6):");
    System.out.println("1: Pilot - Reduces damage taken from asteroid belts");
    System.out.println("2: Engineer - Repairs the ship more effectively");
    System.out.println("3: Soldier - Decreases chance of alien attack");
    System.out.println("4: Medical Officer - Decreases chance that space plague will spread");
    System.out.println("5: Scavenger - Increases chance of finding ship parts");
    System.out.println("6: Navigator - Decreases the chance of going through an asteroid belt");
    System.out.println("----------------------------------------------------------------------");
  }

  public void printAreYouSure(String strName, CrewMember.type inputType) {
    System.out.println("Are you sure you want to create the crew member: " + strName + " as a " + inputType + "? (y/n): ");
  }

  public void printCrewError() {
    System.out.println("That is not a valid crew type.");
  }

  public void printShipCreate() {
    System.out.println("-------------------------- Creation of Ship --------------------------");
    System.out.println("Enter a name for your ship: ");
  }

  public void printShipConfirm(String strName) {
    System.out.println("You want to name your ship " + strName + "? (y/n)");
  }

  public void printAdvConfirm(Crew gameCrew) {
    System.out.println("This would be your crew:");
    /**for(int iCrewIndex = 0; iCrewIndex < gameCrew.crewMembers.size(); iCrewIndex++)
    {
      System.out.print(gameCrew.crewMembers.get(iCrewIndex).toString());
    }*/
    System.out.println(gameCrew.toString());
    System.out.println("Are you sure you want to start the adventure? (y/n)");
  }

  public void printAdvStart() {
    System.out.println("The adventure starts!!!");
  }

  public void printOutpostMenu() {
    System.out.println("Outpost menu: ");
    System.out.println("1: Show objects for sale");
    System.out.println("2: Show own objects & money");
    System.out.println("3: See objects prices");
    System.out.println("4: See object attributes");
    System.out.println("5: Open purchase menu");
    System.out.println("6: Exit Outpost");
  }

  public void printDailyMenu() {
    System.out.println("--- Day " + StartGame.m_iActualDay + " ---");
    System.out.println("Choose your action: ");
    System.out.println("1: Show crew status");
    System.out.println("2: Show spaceship status");
    System.out.println("3: Visit nearest outpost");
    System.out.println("4: Do crew action");
    System.out.println("5: Move on to next day");
  }

  public void printCrewStatus(Crew gameCrew, int iCrewIndex) {
    System.out.print(gameCrew.crewMembers.get(iCrewIndex).toString());
  }

  public void printShipStatus(Crew gameCrew) {
    System.out.print(gameCrew.crewShip.toString());
  }

}

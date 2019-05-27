package Game;
import java.util.Scanner;

/**
 * Initialise the game environment.
 *
 * Prompts the player to choose a length of gameplay, crew size, crew members,
 * and ship name.
 *
 * Once all are chosen, confirms choices with player and starts gameplay.
 *
 * If game is run from console, will launch instance of ConsoleGame.
 *
 * Else, will launch GUI application.
 *
 */
public class StartGame
{

	public static int m_iDays = 0;
	public static int m_iParts = 0;
	public static int m_iGameScore = 0;
	public static int m_iActualParts = 0;
	public static int m_iActualDay = 1;
	public static int score = 0;
	public static boolean m_bEndCondition = false;
	public static ConsoleIO printer = new ConsoleIO();

	public static String m_stringInputGUI = "";
	public static boolean m_stringInputReadyGUI = false;

	public static String m_stringInputLogic = "";
	public static boolean m_stringInputReadyLogic = false;
	public static boolean bGUI = false;


  /**
	 * Checks for game mode Console/GUI, takes appropriate action.
	 *
	 *
	 */
  public static void main(String[] args)
	{
		String mode = "";
		
		if(args.length == 1)
		{
			mode = args[0];
		}

		// Check which game mode; if CONSOLE, run text-based console instance; else,
		// run GUI.
		if(mode.equals("CONSOLE"))
		{
			
			ConsoleGame spaceExplorer = new ConsoleGame();
			spaceExplorer.run();
		}
		else
		{
			gui.StartFrame spaceExplorerGUI = new gui.StartFrame();
			spaceExplorerGUI.main(args);
			ConsoleGame spaceExplorer = new ConsoleGame();
			bGUI = true;
			spaceExplorer.run();
		}

		if (m_bEndCondition)
		{
			printer.printEndGame();
		}
	}
}

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
public class StartGame {

	public static int m_iDays;
	public static int m_iParts;
	public static int m_iGameScore = 0;
	public static int m_iActualParts = 0;
	public static int m_iActualDay = 1;
	public static boolean m_bEndCondition = false;
	
	public static String m_stringInputGUI = "";
	public static boolean m_stringInputReadyGUI = false;
	
	public static String m_stringInputLogic = "";
	public static boolean m_stringInputReadyLogic = false;

  public static void main(String[] args) {
		String mode = "CONSOLE";
		if(args.length == 1) {
			mode = args[0];
		}

		Scanner inputDays = new Scanner(System.in);
		boolean inputCorrect = false;
		do {
			inputCorrect = false;
			System.out.println("How many days you wanna play this game?(3-10): ");
			try {
				m_iDays = inputDays.nextInt();
				inputCorrect = true;
			}
			catch(Exception e) {
				inputCorrect = false;
				inputDays.nextLine();
			}
		}
		while(m_iDays < 3 || m_iDays > 10 || inputCorrect == false);

		m_iParts = m_iDays * 2 / 3;

		if(mode.equals("CONSOLE")) {
			ConsoleGame spaceExplorer = new ConsoleGame();
			spaceExplorer.run();
		}
		else {
			gui.StartFrame spaceExplorerGUI = new gui.StartFrame();
			spaceExplorerGUI.main(args);
		}
	}
}

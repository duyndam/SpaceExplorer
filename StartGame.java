// Import statements
import java.util.Scanner;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

public class StartGame {

	public static int m_iDays;
	public static int m_iParts;
	public static int m_iGameScore = 0;
	public static int m_iActualParts = 0;
	public static int m_iActualDay = 1;

     public static void main(String[] args) {

    	 String mode = "CONSOLE";
    	 if(args.length == 1) {
    		 mode = args[0];
    	 }

    	 Scanner inputDays = new Scanner(System.in);
    	 boolean inputCorrect = false;
			 ConsoleIO printer = new ConsoleIO();
    	 do {
    		 inputCorrect = false;
				 printer.printGameLength();
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

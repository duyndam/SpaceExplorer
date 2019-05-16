import java.util.Scanner;


public class StartGame {

	public static int m_iDays;
	public static int m_iParts;
	public static int m_iGameScore = 0;
	public static int m_iActualParts = 0;
	public static int m_iActualDay = 1;
	
  /**Choose 2-4 crew members from the following classes:
     - Engineer:
       ~ Bonus to repair
       ~ Passive buff to shields
     - Pilot:
       ~ Reduces chance of asteroid impact
     - Soldier:
       ~ Most health
       ~ Intimidate: Reduces chance of aliens boarding
     - Navigator:
       ~
     - Medical Officer:
       ~ Able to heal crew members
     - Scavenger:
       ~ Increased chance of finding ship parts



     Name each crew member

     Name ship (create new Ship object):

     Start adventure */
     public static void main(String[] args) 
     {    
    	 
    	 String mode = "";
    	 if(args.length == 1)
    	 {
    		 mode = args[0];
    	 }
    	 
    	 Scanner inputDays = new Scanner(System.in);
    	 boolean inputCorrect = false;
    	 do
    	 {
    		 inputCorrect = false;
    		 System.out.println("How many days you wanna play this game?(3-10): ");
    		 try
    		 {
    			 m_iDays = inputDays.nextInt();
    			 inputCorrect = true;
    		 }catch(Exception e)
    		 {
    			 inputCorrect = false;
    			 inputDays.nextLine();
    		 }
    		 
    	 }while(m_iDays < 3 || m_iDays > 10 || inputCorrect == false);
    	 
    	 m_iParts = m_iDays * 2 / 3;
    	 
    	 
    	 if(mode.equals("CONSOLE"))
    	 {
    		 ConsoleGame spaceExplorer = new ConsoleGame();
    		 spaceExplorer.run();
    	 }
    	 else
    	 {
    		 gui.StartFrame spaceExplorerGUI = new gui.StartFrame();
    		 spaceExplorerGUI.main(args);
    	 }
    	 
     }

}

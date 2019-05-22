// Import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author      Royal Duyndam, Alex Siegmund
 * @version     0.1.0
 * @since       0.0.0
 */

/**
 * Console game environment.
 *
 * Includes all gameplay logic.
 */
public class ConsoleGame {

	public void run() {
		Scanner inputScanner = new Scanner(System.in);
		int amountCM = 0;
	  ArrayList<CrewMember> crewMembers = new ArrayList<>();
		Ship spaceShip = null;
	  String strName = "";
		Crew gameCrew = new Crew(crewMembers, spaceShip);
	  int iInputType = 0;
	  CrewMember.type inputType = CrewMember.type.PILOT;
	  boolean characterCreate = false;
	  boolean shipCreate = false;
	  boolean inputTypeCorrect = false;
	  boolean startAdventure = false;

		ConsoleIO printer = new ConsoleIO();

		 	do {
				/**
				 * Choose crew size
				 */
		   	 do {
		   		 inputTypeCorrect = true;
		   		 printer.printCrewInit();
		   		 try {
		   			 amountCM = inputScanner.nextInt();
		   		 }
					 catch(InputMismatchException e) {
		   			 inputTypeCorrect = false;
		   			 inputScanner.nextLine();
		   		 }
		   	 }
				 while((!inputTypeCorrect) || (amountCM < 2 || amountCM > 4));

		   	inputScanner.nextLine();
		   	 //CREW CREATION
		   	 //crewList.clear();
		   	 for(int iCrewIndex = 0; iCrewIndex < amountCM; iCrewIndex++) {
		    	 do {
		    		 inputTypeCorrect = true;
		    		 characterCreate = false;
		    		 printer.printCrewInstructions(iCrewIndex);
		    		 try {
		    			 strName = inputScanner.nextLine();
		    			 iInputType = Integer.parseInt(inputScanner.nextLine());
		    			 --iInputType;
		    			 inputType = CrewMember.type.values()[iInputType];
		    		 }
						 catch(Exception e) {
		    			 inputTypeCorrect = false;
		    		 }
		    		 if(inputTypeCorrect) {
		    			 printer.printAreYouSure(strName, inputType);
		    			 String strCreation = inputScanner.nextLine();
		    			 if(strCreation.equals("y")) {
		    				 characterCreate = true;
		    			 }
		    		 }
		    		 else {
		    			 printer.printCrewError();
		    		 }
		    	 }
					 while(!characterCreate);
		    	 //crewList.add(new CrewMember(strName,inputType));
					 gameCrew.addCrew(new CrewMember(strName,inputType));
		   	 }

		   	 //inputScanner.nextLine();
		   	 //SHIP CREATION
		   	 do {
		   		shipCreate = false;
		   		printer.printShipCreate();
		   		strName = inputScanner.nextLine();
					printer.printShipConfirm(strName);
		   		String strCreation = inputScanner.nextLine();
		   		if(strCreation.equals("y")) {
		   			 shipCreate = true;
	   			}
		   	}
				while(!shipCreate);
		   	spaceShip = new Ship(strName);
				gameCrew.setShip(spaceShip);
		   	printer.printAdvConfirm(gameCrew);

		   	String strCreation = inputScanner.nextLine();
	   		if(strCreation.equals("y")) {
	   			startAdventure = true;
   			}
	}
	while(!startAdventure);

	printer.printAdvStart();
	/**
	 * MAIN GAME LOOP
	 *
	 * Print out daily menu with options, visit outposts and planets
	 */
	   	do {
	   		inputTypeCorrect = false;
				printer.printDailyMenu();
		   	try {
	   			iInputType = inputScanner.nextInt();
	   			if(iInputType >= 1 && iInputType <= 4) {
	   				inputTypeCorrect = true;
	   			}
	   		}
				catch(Exception e) {
	   			inputTypeCorrect = false;
	   			inputScanner.nextLine();
	   		}
	   	}
			while(!inputTypeCorrect);
			Station outpost = new Station();
	   	switch(iInputType) {
		   	case 1:
		   		for(int iCrewIndex = 0; iCrewIndex < gameCrew.crewMembers.size(); iCrewIndex++) {
		   			printer.printCrewStatus(gameCrew, iCrewIndex);
		   		}
		   		break;
		   	case 2:
		   		printer.printShipStatus(gameCrew);
		   		break;
		   	case 3:
		   		do {
		   			inputTypeCorrect = false;
						outpost.populateStation();
			   		printer.printOutpostMenu();
				   	try {
			   			iInputType = inputScanner.nextInt();
			   			if(iInputType >= 1 && iInputType <= 6) {
			   				inputTypeCorrect = true;
			   			}
			   		}
						catch(Exception e) {
			   			inputTypeCorrect = false;
			   			inputScanner.nextLine();
			   		}
			   	}
					while(!inputTypeCorrect);
					switch(iInputType) {
						case 1:
							printer.printOutpostInventory(outpost);
							break;
						case 2:
							printer.printCrewInventory(gameCrew);
							break;
						case 3:
							break;
					}
		   		break;
				case 4:
					Planet body = new Planet();
					printer.printPlanet(body);
					break;
		   	case 5:
					do {
						inputTypeCorrect = false;
						printer.printCrewActions();
						try {
							iInputType = inputScanner.nextInt();
							if(iInputType >= 1 && iInputType <= 6) {
								inputTypeCorrect = true;
							}
						}
						catch(Exception e) {
							inputTypeCorrect = false;
							inputScanner.nextLine();
						}
					}
					while(!inputTypeCorrect);
					switch(iInputType) {
						case 1:
							printer.printPilotShip();
							break;
						case 2:
							printer.printEat();
							break;
						case 3:
							printer.printMeds();
							break;
						case 4:
							printer.printSleep();
							break;
						case 5:
							printer.printRepair();
							break;
						}
		   		break;
	   		case 6:
	   			break;
				default:
					break;
	   	}
	}
}

// Import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleGame {

	public void run() {
		Scanner inputScanner = new Scanner(System.in);
		int amountCM = 0;
	  ArrayList<CrewMember> crewList = new ArrayList<>();
	  Ship crewShip = null;
	  String strName = "";
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
		   	 crewList.clear();
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
		    	 crewList.add(new CrewMember(strName,inputType));
		   	 }

		   	 //inputScanner.nextLine();
		   	 //SHIP CREATION
		   	 do
		   	 {
		   		shipCreate = false;
		   		printer.printShipCreate();
		   		strName = inputScanner.nextLine();
					printer.printShipConfirm(strName);
		   		String strCreation = inputScanner.nextLine();
		   		if(strCreation.equals("y"))
	   			{
		   			 shipCreate = true;
	   			}
		   	 }while(!shipCreate);
		   	crewShip = new Ship(strName);

		   	printer.printAdvConfirm(crewList, crewShip);

		   	String strCreation = inputScanner.nextLine();
	   		if(strCreation.equals("y"))
   			{
	   			startAdventure = true;
   			}
	   	}while(!startAdventure);

	   	Crew gameCrew = new Crew(crewList,crewShip);
	   	printer.printAdvStart();
	   	do
	   	{
	   		inputTypeCorrect = false;
				printer.printDailyMenu();
		   	try
	   		{
	   			iInputType = inputScanner.nextInt();
	   			if(iInputType >= 1 && iInputType <= 4)
	   			{
	   				inputTypeCorrect = true;
	   			}
	   		}catch(Exception e)
	   		{
	   			inputTypeCorrect = false;
	   			inputScanner.nextLine();
	   		}
	   	}while(!inputTypeCorrect);
	   	switch(iInputType)
	   	{
		   	case 1:
		   		for(int iCrewIndex = 0; iCrewIndex < crewList.size(); iCrewIndex++)
		   		{
		   			printer.printCrewStatus(crewList, iCrewIndex);
		   		}
		   		break;
		   	case 2:
		   		printer.printShipStatus(crewShip);
		   		break;
		   	case 3:
		   		do
			   	{
		   			inputTypeCorrect = false;
			   		printer.printOutpostMenu();
				   	try
			   		{
			   			iInputType = inputScanner.nextInt();
			   			if(iInputType >= 1 && iInputType <= 6)
			   			{
			   				inputTypeCorrect = true;
			   			}
			   		}catch(Exception e)
			   		{
			   			inputTypeCorrect = false;
			   			inputScanner.nextLine();
			   		}
			   	}while(!inputTypeCorrect);
		   		break;
		   	case 4:
		   		break;
	   		default:
	   			break;
	   	}

	}
}

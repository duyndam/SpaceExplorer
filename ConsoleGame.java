// Import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleGame {



	public void run()
	{
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
	   	do
	   	{
	   	 //CREW AMOUNT
		   	 do
		   	 {
		   		 inputTypeCorrect = true;
		   		 System.out.println("Choose the amount of crew members you would like(2-4): ");
		   		 try
		   		 {
		   			 amountCM = inputScanner.nextInt();
		   		 }catch(InputMismatchException e)
		   		 {
		   			 inputTypeCorrect = false;
		   			 inputScanner.nextLine();
		   		 }
		   	 }while((!inputTypeCorrect) || (amountCM < 2 || amountCM > 4));

		   	inputScanner.nextLine();
		   	 //CREW CREATION
		   	 crewList.clear();
		   	 for(int iCrewIndex = 0; iCrewIndex < amountCM; iCrewIndex++)
		   	 {
		    	 do
		    	 {
		    		 inputTypeCorrect = true;
		    		 characterCreate = false;

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
		    		 try
		    		 {
		    			 strName = inputScanner.nextLine();
		    			 iInputType = Integer.parseInt(inputScanner.nextLine());
		    			 --iInputType;
		    			 inputType = CrewMember.type.values()[iInputType];
		    		 }catch(Exception e)
		    		 {
		    			 inputTypeCorrect = false;
		    		 }
		    		 if(inputTypeCorrect)
		    		 {
		    			 System.out.println("Are you sure you want to create the crew member: " + strName + " as a " + inputType + "? (y/n): ");
		    			 String strCreation = inputScanner.nextLine();
		    			 if(strCreation.equals("y"))
		    			 {
		    				 characterCreate = true;
		    			 }
		    		 }
		    		 else
		    		 {
		    			 System.out.println("That is not a valid crew type.");
		    		 }
		    	 }while(!characterCreate);
		    	 crewList.add(new CrewMember(strName,inputType));
		   	 }

		   	 //inputScanner.nextLine();
		   	 //SHIP CREATION
		   	 do
		   	 {
		   		shipCreate = false;
		   		System.out.println("-------------------------- Creation of Ship --------------------------");
		   		System.out.println("Enter a name for your ship: ");
		   		strName = inputScanner.nextLine();
		   		System.out.println("You want to name your ship " + strName + "? (y/n)");
		   		String strCreation = inputScanner.nextLine();
		   		if(strCreation.equals("y"))
	   			{
		   			 shipCreate = true;
	   			}
		   	 }while(!shipCreate);
		   	crewShip = new Ship(strName);

		   	System.out.println("This would be your crew:");
		    for(int iCrewIndex = 0; iCrewIndex < crewList.size(); iCrewIndex++)
		    {
		    	System.out.print(crewList.get(iCrewIndex).toString());
		    }
		    System.out.print(crewShip.toString());
		   	System.out.println("Are you sure you want to start the adventure? (y/n)");
		   	String strCreation = inputScanner.nextLine();
	   		if(strCreation.equals("y"))
   			{
	   			startAdventure = true;
   			}
	   	}while(!startAdventure);

	   	Crew gameCrew = new Crew(crewList,crewShip);
	   	System.out.println("The adventure starts!!!");

	   	do
	   	{
	   		inputTypeCorrect = false;

	   		System.out.println("--- Day " + StartGame.m_iActualDay + " ---");
		   	System.out.println("Choose your action: ");
		   	System.out.println("1: Show crew status");
		   	System.out.println("2: Show spaceship status");
		   	System.out.println("3: Visit nearest outpost");
		   	System.out.println("4: Do crew action");
		   	System.out.println("5: Move on to next day");
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
		   			System.out.print(crewList.get(iCrewIndex).toString());
		   		}
		   		break;
		   	case 2:
		   		System.out.print(crewShip.toString());
		   		break;
		   	case 3:
		   		do
			   	{
		   			inputTypeCorrect = false;
			   		System.out.println("Outpost menu: ");
				   	System.out.println("1: Show objects for sale");
				   	System.out.println("2: Show own objects & money");
				   	System.out.println("3: See objects prices");
				   	System.out.println("4: See object attributes");
				   	System.out.println("5: Open purchase menu");
				   	System.out.println("6: Exit Outpost");
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

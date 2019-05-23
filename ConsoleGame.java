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
 * Console game environment.
 *
 * Includes all gameplay logic.
 */
public class ConsoleGame 
{

	public void run() 
	{
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

		do 
		{
			/**
			 * Choose crew size
			 */
			do
			{
				inputTypeCorrect = true;
		   		printer.printCrewInit();
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
		   	//crewList.clear();
		   	for(int iCrewIndex = 0; iCrewIndex < amountCM; iCrewIndex++)
		   	{
		   		do
		   		{
		   			inputTypeCorrect = true;
		   			characterCreate = false;
		   			printer.printCrewInstructions(iCrewIndex);
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
		    			printer.printAreYouSure(strName, inputType);
		    			String strCreation = inputScanner.nextLine();
		    			if(strCreation.equals("y")) 
		    			{
		    				characterCreate = true;
		    			}
		    		}
		    		else
		    		{
		    			printer.printCrewError();
		    		}
		    	 }while(!characterCreate);
		   		//crewList.add(new CrewMember(strName,inputType));
		   		gameCrew.addCrew(new CrewMember(strName,inputType));
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
		   	
		   	spaceShip = new Ship(strName);
			gameCrew.setShip(spaceShip);
		   	printer.printAdvConfirm(gameCrew);

		   	String strCreation = inputScanner.nextLine();
	   		if(strCreation.equals("y"))
	   		{
	   			startAdventure = true;
   			}
		}while(!startAdventure);

		printer.printAdvStart();
		/**
		 * MAIN GAME LOOP
		 *
		 * Print out daily menu with options, visit outposts and planets
		 */
		do
		{
		
	   	do 
	   	{
	   		inputTypeCorrect = false;
			printer.printDailyMenu();
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
	   	
		Station outpost = new Station();
		
	   	switch(iInputType) 
	   	{
		   	case 1:
		   		for(int iCrewIndex = 0; iCrewIndex < gameCrew.crewMembers.size(); iCrewIndex++)
		   		{
		   			printer.printCrewStatus(gameCrew, iCrewIndex);
		   		}
		   		break;
		   	case 2:
		   		printer.printShipStatus(gameCrew);
		   		break;
		   	case 3:
		   		do
		   		{
		   			inputTypeCorrect = false;
		   			//outpost.populateStation();
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
				
		   		switch(iInputType) 
		   		{
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
				do 
				{
					inputTypeCorrect = false;
					
					printer.printCrewChooser(gameCrew.createActionChoseString());
					try 
					{
						iInputType = inputScanner.nextInt();
						if(iInputType >= 1 && iInputType <= gameCrew.crewSize()+1) 
						{
							inputTypeCorrect = true;
						}
					}catch(Exception e) 
					{
						inputTypeCorrect = false;
						inputScanner.nextLine();
					}
				}while(!inputTypeCorrect);
				if(iInputType != gameCrew.crewSize()+1)
				{
					int chosenCrewMemberIndex = iInputType-1;
					do 
					{
						inputTypeCorrect = false;
						printer.printCrewActions();
						try 
						{
							iInputType = inputScanner.nextInt();
							if(iInputType >= 1 && iInputType <= 7) 
							{
								inputTypeCorrect = true;
							}
						}catch(Exception e) 
						{
							inputTypeCorrect = false;
							inputScanner.nextLine();
						}
					}while(!inputTypeCorrect);
					CrewMember chosenMember = gameCrew.crewMembers.get(chosenCrewMemberIndex);
					switch(iInputType) 
					{
						
						case 1:
							
							if(chosenMember.doAction(CrewMember.PILOTING_ACTION))
							{
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.PILOTING_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 2:
							if(chosenMember.doAction(CrewMember.EATING_ACTION))
							{
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.EATING_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 3:
							if(chosenMember.doAction(CrewMember.MEDICINE_ACTION))
							{
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.MEDICINE_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 4:
							if(chosenMember.doAction(CrewMember.SLEEPING_ACTION))
							{
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.SLEEPING_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 5:
							if(chosenMember.doAction(CrewMember.VISIT_PLANET_ACTION))
							{
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.VISIT_PLANET_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 6:
							if(chosenMember.doAction(CrewMember.REPAIR_ACTION))
							{
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.REPAIR_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 7:
							break;
					}
			   		break;
				}
	   		case 6:
	   			StartGame.m_iActualDay++;
	   			break;
				default:
					break;
	   	}
	   	if(StartGame.m_iActualDay > StartGame.m_iDays)
	   	{
	   		StartGame.m_bEndCondition = true;
	   	}
		}while(!StartGame.m_bEndCondition);
	}
}

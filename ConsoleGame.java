// Import statements
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
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

		int modifier;
		int chance;
		int newChance;
		int encounterType;
		int encounterToday;
		int damage;

		Random encounter = new Random();

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
		Station actualOutpost = new Station();
		Planet actualPlanet = new Planet();

		do
		{

	   	do
	   	{
	   	inputTypeCorrect = false;

			printer.printDailyMenu();
		   	try
		   	{
		   		iInputType = inputScanner.nextInt();
	   			if(iInputType >= 1 && iInputType <= 5)
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
		   		printer.printCrewStatus(gameCrew);
		   		break;
		   	case 2:
		   		printer.printShipStatus(gameCrew);
		   		break;
		   	case 3:
				do
				{
					inputTypeCorrect = false;
					printer.printOutpostMenu();
					try
					{
						iInputType = inputScanner.nextInt();
						if(iInputType >= 1 && iInputType <= 3)
						{
							inputTypeCorrect = true;
						}
					}catch(Exception e)
					{
						inputTypeCorrect = false;
						inputScanner.nextLine();
					}
				}while(!inputTypeCorrect);

				//BUY/SELL AT STORE
				boolean exitCase = false;
				boolean atStore = true;
				while(atStore)
				{
					switch(iInputType)
					{
						//VIEW ITEMS FOR SALE
						case 1:
						do
			   		{
			   			inputTypeCorrect = false;
				   		printer.printOutpostInventory(actualOutpost);
					   	try
					   	{
				   			iInputType = inputScanner.nextInt();
				   			if(iInputType >= 1 && iInputType <= actualOutpost.availableItems.size()+2)
				   			{
				   				inputTypeCorrect = true;
				   			}
				   		}catch(Exception e)
					   	{
				   			inputTypeCorrect = false;
				   			inputScanner.nextLine();
				   		}
				   	}while(!inputTypeCorrect);
						if (iInputType >= actualOutpost.availableItems.size()+2)
						{
							exitCase = true;
						}
							Item item = actualOutpost.availableItems.get(iInputType-1);
							if (gameCrew.getMoney() >= item.get_BuyPrice())
							{
								actualOutpost.availableItems.remove(item);
								gameCrew.inventory.add(item);
								gameCrew.removeMoney(item.get_BuyPrice());
								printer.printBuy(item);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							case 2:
							do
				   		{
				   			inputTypeCorrect = false;
					   		printer.printCrewInventory(gameCrew);
						   	try
						   	{
					   			iInputType = inputScanner.nextInt();
					   			if(iInputType >= 1 && iInputType <= gameCrew.inventory.size()+2)
					   			{
					   				inputTypeCorrect = true;
					   			}
					   		}catch(Exception e)
						   	{
					   			inputTypeCorrect = false;
					   			inputScanner.nextLine();
					   		}
					   	}while(!inputTypeCorrect);
								if (iInputType >= gameCrew.inventory.size()+2)
								{
									exitCase = true;
								}
									item = gameCrew.inventory.get(iInputType-1);
									gameCrew.inventory.remove(item);
									actualOutpost.availableItems.add(item);
									gameCrew.addMoney(item.get_SellPrice());
									printer.printSell(item);
									break;
							case 3:
									break;
							default:
									break;
					}
				}
				if (exitCase == true)
				{
					atStore = false;
					break;
				}
		   	case 4:
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
					CrewMember chosenMember = gameCrew.crewMembers.get(chosenCrewMemberIndex);
					switch(iInputType)
					{

						case 1:

							if(chosenMember.doAction(CrewMember.PILOTING_ACTION))
							{
								gameCrew.crewShip.addPilot();
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.PILOTING_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;

						case 2:
							if(chosenMember.doAction(CrewMember.ITEM_ACTION) && !gameCrew.inventory.isEmpty())
							{
								do
									{
										inputTypeCorrect = false;
										printer.printCrewInventory(gameCrew);
										try
										{
											iInputType = inputScanner.nextInt();
											if(iInputType >= 1 && iInputType <= gameCrew.inventory.size()+1)
											{
											inputTypeCorrect = true;
											}
										}catch(Exception e)
										{
											inputTypeCorrect = false;
											inputScanner.nextLine();
										}
									}while(!inputTypeCorrect);
								if (iInputType == gameCrew.inventory.size()+1)
								{
									break;
								}
								else
								{
									Item item = gameCrew.inventory.get(iInputType-1);
									gameCrew.inventory.remove(iInputType-1);
									if (item.isInstance(MedicalItem))
									{
										if (item.getType() == CURES_SPACE_PLAGUE)
										{
											chosenMember.setState(HEALTHY);
										}
										chosenMember.updateHealth(item.get_Value());
									}
									else
									{
										chosenMember.updateHunger(item.get_Value());
									}
									printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.ITEM_ACTION);
								}
							}
								else
							{
								printer.printDoingActionAlready();
							}

							break;
						case 3:
							if(chosenMember.doAction(CrewMember.SLEEPING_ACTION))
							{
								chosenMember.updateFatigue(-25);
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.SLEEPING_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 4:
							if(chosenMember.doAction(CrewMember.VISIT_PLANET_ACTION))
							{
								Item thing = new Item();
								String part;
								int money;
								Random luckyFind = new Random();
								luckyFind.nextInt(5);
								if (luckyFind < 1)
								{
									thing = actualPlanet.get_RandomFoodItem();
									gameCrew.addItem(thing);
								}
								else if (luckyFind >= 1 && luckyFind < 2)
								{
									thing = actualPlanet.get_RandomMedicalItem();
									gameCrew.addItem(thing);
								}
								else if (luckyFind >= 2 && luckyFind < 3)
								{
									money = actualPlanet.get_RandomAmountMoney();
									gameCrew.addMoney(money);
								}
								else if (luckyFind >= 3 && luckyFind < 4)
								{
									part = actualPlanet.get_RandomShipPart();
									gameCrew.addPart(part);
								}
								else
								{
									printer.printNothing();
								}





								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.VISIT_PLANET_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 5:
							if(chosenMember.doAction(CrewMember.REPAIR_ACTION))
							{
								if (chosenMember.getType() == CrewMember.type.ENGINEER)
								{
									gameCrew.crewShip.update(25);
								}
								else
								{
									gameCrew.crewShip.update(10);
								}
								printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.REPAIR_ACTION);
							}
							else
							{
								printer.printDoingActionAlready();
							}
							break;
						case 6:
							break;
					}
			   		break;
				}
	   		case 5:

					if (gameCrew.shipParts >= StartGame.m_iParts)
					{
						StartGame.m_bEndCondition = true;
					}
	   			StartGame.m_iActualDay++;

					//CHECK IF READY TO FLY - if so, generate new planet and outpost.
					if (gameCrew.crewShip.getNumPilots() >= 2)
					{
						actualOutpost = new Station();
						actualPlanet = new Planet();
					}

					//RESET CREW ACTIONS AND UPDATE FATIGUE/HUNGER
					for (CrewMember cosmonaut: gameCrew.crewMembers)
					{
						cosmonaut.clearActions();
						cosmonaut.updateFatigue(10);
						cosmonaut.updateHunger(10);
						if (cosmonaut.getState() == SPACE_PLAGUE_INFECTED)
						{
							cosmonaut.updateHealth(-10);
						}
					}

					encounterToday = encounter.nextInt(3);

					if (encounterToday < 1) {
						boolean encounterHappens = true;
						encounterType = encounter.nextInt(3);
						switch(encounterType)
						{
							case 0:
								if (!gameCrew.inventory.isEmpty())
								{
									modifier = gameCrew.jobCount(CrewMember.type.DOCTOR);
									chance = (int) Math.pow(2, modifier)*3;
									newChance = encounter.nextInt(chance);
									if (newChance < 1)
									{
										boolean pirates = true;
										int toSteal = encounter.nextInt(gameCrew.inventory.size());
										gameCrew.inventory.remove(toSteal);
										printer.printPirates();
									}
								}
								break;
							case 1:
								modifier = gameCrew.jobCount(CrewMember.type.NAVIGATOR);
								chance = (int) Math.pow(2, modifier)*3;
								newChance = encounter.nextInt(chance);
								if (newChance < 1)
								{
									boolean asteroids = true;
									int shield = gameCrew.crewShip.getShield();
									int hull = gameCrew.crewShip.getHull();
									if (gameCrew.crewMembers.contains(CrewMember.type.PILOT))
									{
										double dmgMod = 0.1*gameCrew.jobCount(CrewMember.type.PILOT);
										double shieldMod = 0.2*(100-shield);
										damage = -50;
										damage -= 50*dmgMod;
										damage -= shieldMod;
									}
									else
									{
										damage = -(50+shieldMod);
									}
									gameCrew.crewShip.update(damage);

									printer.printAsteroids(damage);
								}
								break;
							case 2:
								modifier = gameCrew.jobCount(CrewMember.type.DOCTOR);
								chance = (int) Math.pow(2, modifier)*3;
								newChance = encounter.nextInt(chance);
								if (newChance < 1)
								{
									boolean plague = true;
									int infected = encounter.nextInt(gameCrew.crewSize());
									CrewMember sickCrew = gameCrew.crewMembers.get(infected);
									sickCrew.setState(CrewMember.status.SPACE_PLAGUE_INFECTED);
									printer.printPlague();
								}
								break;
							default:
								break;
						}
					}
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

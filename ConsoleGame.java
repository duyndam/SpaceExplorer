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

		int damage = 0;

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
		   		//SPACEOUTPUT MENUE
		   		boolean leaveOutpost = false;
		   		boolean leaveBuySellMenue = false;
		   		do
		   		{
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
					leaveBuySellMenue = false;
					switch(iInputType)
					{
						//VIEW ITEMS FOR SALE
						case 1:
							do
							{
								do
								{
						   			inputTypeCorrect = false;
						   			printer.printMoney(gameCrew.getMoney());
							   		printer.printOutpostInventory(actualOutpost);
								   	try
								   	{
							   			iInputType = inputScanner.nextInt();
							   			if(iInputType >= 1 && iInputType <= (actualOutpost.availableItems.size()+1))
							   			{
							   				inputTypeCorrect = true;
							   			}
							   		}catch(Exception e)
								   	{
							   			inputTypeCorrect = false;
							   			inputScanner.nextLine();
							   		}
								}while(!inputTypeCorrect);

								if(iInputType == (actualOutpost.availableItems.size() + 1))
								{
									leaveBuySellMenue = true;
								}
								else
								{
									if(gameCrew.getMoney() >= actualOutpost.availableItems.get(iInputType-1).get_BuyPrice())
									{
										gameCrew.removeMoney(actualOutpost.availableItems.get(iInputType-1).get_BuyPrice());
										printer.printBuy(actualOutpost.availableItems.get(iInputType-1));
										if(actualOutpost.availableItems.get(iInputType-1) instanceof MedicalItem)
										{
											MedicalItem addItem = (MedicalItem)actualOutpost.availableItems.get(iInputType-1);
											gameCrew.addMedical(addItem);
										}
										else
										{
											FoodItem addItem = (FoodItem)actualOutpost.availableItems.get(iInputType-1);
											gameCrew.addFood(addItem);
										}
										actualOutpost.get_ItemList().remove(iInputType-1);
									}
									else
									{
										printer.printCantAfford();
									}
								}
					
							}while(!leaveBuySellMenue);
							break;
						case 2:
							do
							{
								do
								{
						   			inputTypeCorrect = false;

						   			printer.printMoney(gameCrew.getMoney());
							   		printer.printCrewInventory(gameCrew);
								   	try
								   	{
							   			iInputType = inputScanner.nextInt();
							   			if(iInputType >= 1 && iInputType <= (gameCrew.inventory.size()+1))
							   			{
							   				inputTypeCorrect = true;
							   			}
							   		}catch(Exception e)
								   	{
							   			inputTypeCorrect = false;
							   			inputScanner.nextLine();
							   		}
								}while(!inputTypeCorrect);
								
								if(iInputType == (gameCrew.inventory.size() + 1))
								{
									leaveBuySellMenue = true;
								}
								else
								{
									gameCrew.addMoney(gameCrew.inventory.get(iInputType-1).get_SellPrice());
									printer.printSell(gameCrew.inventory.get(iInputType-1));
									actualOutpost.get_ItemList().add(gameCrew.inventory.get(iInputType-1));
									gameCrew.inventory.remove(iInputType-1);
								}
							}while(!leaveBuySellMenue);
							break;
						case 3:
							leaveOutpost = true;
							break;
						default:
							break;
					}
		   		}while(!leaveOutpost);
		   		break;
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
									if (gameCrew.inventory.get(iInputType-1) instanceof MedicalItem)
									{
										MedicalItem meds = (MedicalItem)gameCrew.inventory.get(iInputType-1);
										if (meds.get_Type() == typeMedical.CURES_SPACE_PLAGUE)
										{
											chosenMember.setState(CrewMember.status.HEALTHY);
										}
										else
										{
											chosenMember.updateHealth(meds.get_Value());
										}
									}
									else
									{
										FoodItem food = (FoodItem)gameCrew.inventory.get(iInputType-1);
										chosenMember.updateHunger(food.get_Value());
									}
									gameCrew.inventory.remove(iInputType-1);

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
								String part;
								int money;
								Random luckyFind = new Random();
								int found = luckyFind.nextInt(5);
								if (found < 1)
								{
									FoodItem thing = new FoodItem();
									thing = actualPlanet.get_RandomFoodItem();
									gameCrew.addFood(thing);
								}
								else if (found >= 1 && found < 2)
								{
									MedicalItem thing = new MedicalItem();
									thing = actualPlanet.get_RandomMedicalItem();
									gameCrew.addMedical(thing);
								}
								else if (found >= 2 && found < 3)
								{
									money = actualPlanet.get_RandomAmountMoney();
									gameCrew.addMoney(money);
								}
								else if (found >= 3 && found < 4)
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
				break;
	   		case 5:
					StartGame.score += 1000;

					if (gameCrew.shipParts != null && gameCrew.shipParts.size() >= StartGame.m_iParts)
					{
						// Endgame score calculation
						StartGame.score += 2000;
						for (Item thing: gameCrew.inventory)
						{
							StartGame.score += 25;
						}
						for (String part: gameCrew.shipParts)
						{
							StartGame.score += 200;
						}
						StartGame.score += 5*gameCrew.getMoney();
						StartGame.score += 100*gameCrew.crewSize();

						// Huge bonus for finding all parts
						StartGame.score += 5000;

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
						if (cosmonaut.getState() == CrewMember.status.SPACE_PLAGUE_INFECTED)
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
									double shieldMod = 0.2*(100-shield);
									if (gameCrew.crewMembers.contains(CrewMember.type.PILOT))
									{
										double dmgMod = 0.1*gameCrew.jobCount(CrewMember.type.PILOT);

										damage = -50;
										damage -= 50*dmgMod;
										damage -= shieldMod;
									}
									else
									{
										damage = (int)Math.round(-(50+shieldMod));
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
				// Endgame score calculation
				StartGame.score += 2000;
				for (Item thing: gameCrew.inventory)
				{
					StartGame.score += 25;
				}
				if (gameCrew.shipParts != null)
				{
					for (String part: gameCrew.shipParts)
					{
						StartGame.score += 200;
					}
				}
				StartGame.score += 5*gameCrew.getMoney();
				StartGame.score += 100*gameCrew.crewSize();

	   		StartGame.m_bEndCondition = true;
	   	}
		}while(!StartGame.m_bEndCondition);
	}
}

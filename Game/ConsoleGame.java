package Game;
// Import statements
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import Game.MedicalItem.typeMedical;
import gui.DailyFrame;

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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
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
		
		if(!StartGame.bGUI)
		{
			Scanner inputDays = new Scanner(System.in);
			boolean inputCorrect = false;
			do
			{
				inputCorrect = false;
				printer.printGameLength();
				try
				{
					StartGame.m_iDays = inputDays.nextInt();
					inputCorrect = true;
				}
				catch(Exception e) {
					inputCorrect = false;
					inputDays.nextLine();
				}
			}
			while(StartGame.m_iDays < 3 || StartGame.m_iDays > 10 || inputCorrect == false);
	
			// calculate number of spaceship parts required - equal to 2/3 of game length.
			
		}
		else
		{
			do
			{
				while(!StartGame.m_stringInputReadyGUI)
				{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				StartGame.m_stringInputReadyGUI = false;
				try
				{
				StartGame.m_iDays = Integer.parseInt(StartGame.m_stringInputGUI);
				}catch (Exception e)
				{
					StartGame.m_iDays = 0;
				}
				if(StartGame.m_iDays >= 3 && StartGame.m_iDays <= 10)
				{
					StartGame.m_stringInputReadyLogic = true;
					StartGame.m_stringInputLogic = "1";
				}
				else
				{
					StartGame.m_stringInputReadyLogic = true;
					StartGame.m_stringInputLogic = "0";
				}
			}while(StartGame.m_iDays < 3 || StartGame.m_iDays > 10);		
		}
		
		StartGame.m_iParts = StartGame.m_iDays * 2 / 3;

		do
		{
			/**
			 * Choose crew size
			 */
			if(!StartGame.bGUI)
			{
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
			}
			else
			{
				if(StartGame.m_stringInputReadyGUI)
				{
					String[] strMessage = StartGame.m_stringInputGUI.split(",");
					if(strMessage.length >= 5)	//because min amount 2 members
					{
						int iAmount = Integer.parseInt(strMessage[0]);
						String strSpaceShipName = strMessage[1];
						for(int iCrewMemberIndex = 2; iCrewMemberIndex < 2+iAmount*2;iCrewMemberIndex+=2)
						{
							gameCrew.addCrew(new CrewMember(strMessage[iCrewMemberIndex],CrewMember.type.values()[Integer.parseInt(strMessage[iCrewMemberIndex+1])]));
						}
						gameCrew.crewShip = new Ship(strSpaceShipName);
						startAdventure = true;
					}
					StartGame.m_stringInputReadyGUI = false;
					StartGame.m_stringInputGUI = "";
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}while(!startAdventure);
		
		StartGame.m_stringInputReadyLogic = true;

		if(!StartGame.bGUI)
		{
			printer.printAdvStart();
		}
		/**
		 * MAIN GAME LOOP
		 *
		 * Print out daily menu with options, visit outposts and planets
		 */
		
		Station actualOutpost = new Station();
		Planet actualPlanet = new Planet();

		do
		{
			if(!StartGame.bGUI)
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
			}
			else
			{
				do
			   	{
					inputTypeCorrect = false;
					if(StartGame.m_stringInputReadyGUI)
					{
						iInputType = Integer.parseInt(StartGame.m_stringInputGUI);
						if(iInputType >= 1 && iInputType <= 5)
						{
							inputTypeCorrect = true;
						}
						StartGame.m_stringInputReadyGUI = false;
						StartGame.m_stringInputGUI = "";
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}while(!inputTypeCorrect);
			}

		   	switch(iInputType)
		   	{
			   	case 1:
			   		if(!StartGame.bGUI)
			   		{
			   			printer.printCrewStatus(gameCrew);
			   		}
			   		else
			   		{
			   			StartGame.m_stringInputLogic = "";
			   			StartGame.m_stringInputLogic += gameCrew.crewSize();
			   			for(int iCrewIndex = 0; iCrewIndex < gameCrew.crewSize(); iCrewIndex++)
			   			{
			   				StartGame.m_stringInputLogic += gameCrew.crewMembers.get(iCrewIndex).serialize();
			   			}
			   			StartGame.m_stringInputReadyLogic = true;
			   			while(!StartGame.m_stringInputReadyGUI)
			   			{
			   				try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			   			}
			   			StartGame.m_stringInputReadyGUI = false;
			   		}
			   		break;
			   	case 2:
			   		if(!StartGame.bGUI)
			   		{
			   			printer.printShipStatus(gameCrew);
			   		}
			   		else
			   		{
			   			StartGame.m_stringInputLogic = "";
			   			StartGame.m_stringInputLogic += gameCrew.crewShip.serialize();
			   			StartGame.m_stringInputReadyLogic = true;
			   			while(!StartGame.m_stringInputReadyGUI)
			   			{
			   				try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			   			}
			   			StartGame.m_stringInputReadyGUI = false;
			   		}
			   		break;
			   	case 3:
			   		//SPACEOUTPUT MENUE
			   		int guiSecondInput = 0;
			   		boolean checkGUIValid = false;
			   		
			   		boolean leaveOutpost = false;
			   		boolean leaveBuySellMenue = false;
			   		do
			   		{
			   			if(!StartGame.bGUI)
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
				   		}
			   			else
			   			{
			   				String strSerializedCrewItems = "";
			   				String strSerializedOutpostItems = "";
			   				
			   				for(int iCrewItemIndex = 0; iCrewItemIndex < gameCrew.inventory.size(); iCrewItemIndex++)
			   				{
			   					strSerializedCrewItems += gameCrew.inventory.get(iCrewItemIndex).toString() + ",";
			   				}
			   				
			   				for(int iOutpostItemIndex = 0; iOutpostItemIndex < actualOutpost.get_ItemCount(); iOutpostItemIndex++)
			   				{
			   					strSerializedOutpostItems += actualOutpost.availableItems.get(iOutpostItemIndex).toString() + ",";
			   				}
			   				StartGame.m_stringInputLogic = strSerializedCrewItems + "::" + strSerializedOutpostItems;
			   				StartGame.m_stringInputReadyLogic = true;
			   				while(!StartGame.m_stringInputReadyGUI)
			   				{
			   					try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			   				}
			   				StartGame.m_stringInputReadyGUI = false;		//is needed to make sure gui communication goes into next step
			   				
			   				do
			   				{
								if(StartGame.m_stringInputReadyGUI)
								{
									String strMessage[] = StartGame.m_stringInputGUI.split(",");
									if(strMessage.length == 2)
									{
										iInputType = Integer.parseInt(strMessage[0]);
										guiSecondInput = Integer.parseInt(strMessage[1]);
										if(iInputType == 1 &&(guiSecondInput >= 1 && guiSecondInput <= actualOutpost.availableItems.size()+1))
										{
											checkGUIValid = true;
										}
										else if(iInputType == 2 &&(guiSecondInput >= 1 && guiSecondInput <= gameCrew.inventory.size()+1))
										{
											checkGUIValid = true;
										}
										else if(iInputType == 3)
										{
											checkGUIValid = true;
										}
									}
									StartGame.m_stringInputReadyGUI = false;
								}
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			   				}while(!checkGUIValid);
			   				
			   			}
						switch(iInputType)
						{
							//VIEW ITEMS FOR SALE
							case 1:
								do
								{
									if(!StartGame.bGUI)
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
									}
									if(StartGame.bGUI)
									{
										iInputType = guiSecondInput;									//Sets input coming from gui
									}
									if(iInputType == (actualOutpost.availableItems.size() + 1))
									{
										leaveBuySellMenue = true;
									}
									else
									{
										if(gameCrew.getMoney() >= actualOutpost.availableItems.get(iInputType-1).get_BuyPrice())
										{
											gameCrew.removeMoney(actualOutpost.availableItems.get(iInputType-1).get_BuyPrice());
											if(!StartGame.bGUI)
											{
												printer.printBuy(actualOutpost.availableItems.get(iInputType-1));
											}
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
											if(!StartGame.bGUI)
											{
												printer.printCantAfford();
											}
											else
											{
												DailyFrame.strActionLog += "Can't afford that\n";
											}
										}
									}
									if(StartGame.bGUI)
									{
										break;
									}
								}while(!leaveBuySellMenue);
								StartGame.m_stringInputReadyLogic = true;
								break;
							case 2:
								do
								{
									if(!StartGame.bGUI)
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
									}
									if(StartGame.bGUI)
									{
										iInputType = guiSecondInput;									//Sets input coming from gui
									}
									if(iInputType == (gameCrew.inventory.size() + 1))
									{
										leaveBuySellMenue = true;
									}
									else
									{
										gameCrew.addMoney(gameCrew.inventory.get(iInputType-1).get_SellPrice());
										if(!StartGame.bGUI)
										{
											printer.printSell(gameCrew.inventory.get(iInputType-1));
										}
										actualOutpost.get_ItemList().add(gameCrew.inventory.get(iInputType-1));
										gameCrew.inventory.remove(iInputType-1);
									}
									if(StartGame.bGUI)
									{
										break;
									}
								}while(!leaveBuySellMenue);
								StartGame.m_stringInputReadyLogic = true;
								break;
							case 3:
								leaveOutpost = true;
								//StartGame.m_stringInputLogic = "3";
								//StartGame.m_stringInputReadyLogic = true;
								break;
							default:
								break;
						}
						if(StartGame.bGUI)
						{
							StartGame.m_stringInputReadyGUI = false;
							break;
						}
			   		}while(!leaveOutpost);
			   		
			   		break;
			   	case 4:
			   		int iChosenIndex = 0;
			   		int iInputActionGUI = 0;
			   		if(StartGame.bGUI)
			   		{
				   		StartGame.m_stringInputLogic = "";
			   			StartGame.m_stringInputLogic += gameCrew.crewSize();
			   			for(int iCrewIndex = 0; iCrewIndex < gameCrew.crewSize(); iCrewIndex++)
			   			{
			   				StartGame.m_stringInputLogic += gameCrew.crewMembers.get(iCrewIndex).get_ActionWithCount();
			   			}
			   			StartGame.m_stringInputReadyLogic = true;
			   			while(!StartGame.m_stringInputReadyGUI)
			   			{
			   				try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			   			}
			   			StartGame.m_stringInputReadyGUI = false;
			   		}
			   		if(!StartGame.bGUI)
			   		{
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
			   		}
			   		else
			   		{
			   			
			   			do
			   			{
				   			while(!StartGame.m_stringInputReadyGUI)
				   			{
				   				try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				   			}
				   			iChosenIndex = Integer.parseInt(StartGame.m_stringInputGUI);
				   			if(iChosenIndex >= 0 && iChosenIndex <= gameCrew.crewSize())
				   			{
				   				break;
				   			}
				   			else
				   			{
				   				StartGame.m_stringInputLogic = "1";
								StartGame.m_stringInputReadyLogic = true;
				   			}
				   			StartGame.m_stringInputReadyGUI = false;
			   			}while(true);
			   			if(iChosenIndex == gameCrew.crewSize())
			   			{
			   				StartGame.m_stringInputReadyGUI = false;
			   				continue;
			   			}
			   			StartGame.m_stringInputLogic = "0," + gameCrew.inventory.size();
						StartGame.m_stringInputReadyLogic = true;
						while(!StartGame.m_stringInputReadyGUI)
						{
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						StartGame.m_stringInputReadyGUI = false;
			   		}
			   		
			   		if(StartGame.bGUI)
			   		{
			   			iInputType = iChosenIndex+1;		//get input from gui if gui is running, highest input is escape of the crewmember selection
			   		}
			   		
					if(iInputType != gameCrew.crewSize()+1)
					{
						int chosenCrewMemberIndex = iInputType-1;
						if(!StartGame.bGUI)
						{
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
						}
						else
						{
							
							do
							{
								while(!StartGame.m_stringInputReadyGUI)
								{
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								iInputActionGUI = Integer.parseInt(StartGame.m_stringInputGUI);
								if(iInputActionGUI >= 1 && iInputActionGUI <= 6)
								{
									StartGame.m_stringInputReadyGUI = false;
									break;
								}
								StartGame.m_stringInputReadyGUI = false;
							}while(true);
						}
						CrewMember chosenMember = gameCrew.crewMembers.get(chosenCrewMemberIndex);
						if(StartGame.bGUI)
						{
							iInputType = iInputActionGUI;
						}
						
						switch(iInputType)
						{
	
							case 1:
	
								if(chosenMember.doAction(CrewMember.PILOTING_ACTION))
								{
									gameCrew.crewShip.addPilot();
									if(!StartGame.bGUI)
									{
										printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.PILOTING_ACTION);
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + CrewMember.PILOTING_ACTION + "\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								else
								{
									if(!StartGame.bGUI)
									{
										printer.printDoingActionAlready();
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + " can't do that action (action not added)\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								StartGame.m_stringInputReadyGUI = false;
								break;
							case 2:
								int iChosenItem = 0;
								if(!gameCrew.inventory.isEmpty())
								{
									if(chosenMember.isActionDoAble(CrewMember.ITEM_ACTION))
									{
										if(!StartGame.bGUI)
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
										}
										else
										{
											StartGame.m_stringInputLogic = Integer.toString(gameCrew.inventory.size()) + ",";
											StartGame.m_stringInputLogic += gameCrew.get_SerializedItemList();
											StartGame.m_stringInputReadyLogic = true;
											do
								   			{
									   			while(!StartGame.m_stringInputReadyGUI)
									   			{
									   				try {
														Thread.sleep(100);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									   			}
									   			iChosenItem = Integer.parseInt(StartGame.m_stringInputGUI);
									   			if(iChosenItem >= 0 && iChosenItem <= gameCrew.inventory.size())
									   			{
									   				break;
									   			}
									   			StartGame.m_stringInputReadyGUI = false;
								   			}while(true);
										}
										
										if(StartGame.bGUI)
										{
											if(iChosenItem == gameCrew.inventory.size())
											{
												StartGame.m_stringInputReadyGUI = false;
												continue;
											}
											iInputType = iChosenItem+1;
										}
										
										if (iInputType == gameCrew.inventory.size()+1)
										{
											break;
										}
										else
										{
											if(chosenMember.doAction(CrewMember.ITEM_ACTION))
											{
												if (gameCrew.inventory.get(iInputType-1) instanceof MedicalItem)
												{
													MedicalItem meds = (MedicalItem)gameCrew.inventory.get(iInputType-1);
													if (meds.get_Type() == typeMedical.CURES_SPACE_PLAGUE.getValue())
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
												if(!StartGame.bGUI)
												{
													printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.ITEM_ACTION);
												}
												else
												{
													now = LocalDateTime.now();
													DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + CrewMember.ITEM_ACTION + "\n";
													StartGame.m_stringInputReadyLogic = true;
												}
											}
										}
									}
									else
									{
										if(!StartGame.bGUI)
										{
											printer.printDoingActionAlready();
										}
										else
										{
											StartGame.m_stringInputLogic = "0";
											StartGame.m_stringInputReadyLogic = true;
											while(!StartGame.m_stringInputReadyGUI)
											{
												try {
													Thread.sleep(100);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											StartGame.m_stringInputReadyGUI = false;
										}
									}
								}
								else
								{
									if(!StartGame.bGUI)
									{
										printer.printNoItemsInInventory();
									}
									else
									{
										
									}
								}
								StartGame.m_stringInputReadyGUI = false;
								break;
							case 3:
								if(chosenMember.doAction(CrewMember.SLEEPING_ACTION))
								{
									chosenMember.updateFatigue(-25);
									if(!StartGame.bGUI)
									{
										printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.SLEEPING_ACTION);
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + CrewMember.SLEEPING_ACTION + "\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								else
								{
									if(!StartGame.bGUI)
									{
										printer.printDoingActionAlready();
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + " can't do that action (action not added)\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								StartGame.m_stringInputReadyGUI = false;
								break;
							case 4:
								if(chosenMember.doAction(CrewMember.VISIT_PLANET_ACTION))					//CHECK LOGIC BUG!!!
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
									if (found >= 3 && found < 4)
									{
										part = actualPlanet.get_RandomShipPart();
										gameCrew.addPart(part);
									}
									else
									{
										if(!StartGame.bGUI)
										{
											printer.printNothing();
										}
									}
									if(!StartGame.bGUI)
									{
										printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.VISIT_PLANET_ACTION);
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + CrewMember.VISIT_PLANET_ACTION + "\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								else
								{
									if(!StartGame.bGUI)
									{
										printer.printDoingActionAlready();
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + " can't do that action (action not added)\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								StartGame.m_stringInputReadyGUI = false;
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
									if(!StartGame.bGUI)
									{
										printer.printActionCrewMemberDoes(chosenMember.getName() + CrewMember.REPAIR_ACTION);
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + CrewMember.REPAIR_ACTION + "\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								else
								{
									if(!StartGame.bGUI)
									{
										printer.printDoingActionAlready();
									}
									else
									{
										now = LocalDateTime.now();
										DailyFrame.strActionLog += "[" + dtf.format(now).toString() + "] " + chosenMember.getName() + " can't do that action (action not added)\n";
										StartGame.m_stringInputReadyLogic = true;
									}
								}
								StartGame.m_stringInputReadyGUI = false;
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
										if(!StartGame.bGUI)							//TODO: print pirate encounter in gui
										{
											printer.printPirates();
										}
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
									if(!StartGame.bGUI)										//TODO: print asteroids encounter in gui
									{
										printer.printAsteroids(damage);
									}
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
									if(!StartGame.bGUI)										////TODO: print plague encounter in gui
									{
										printer.printPlague();
									}
								}
								break;
							default:
								break;
						}
					}
					StartGame.m_stringInputReadyLogic = true;
		   			break;
		   		default:
					break;
		   	}
		   	if(StartGame.m_iActualDay > StartGame.m_iDays)			//TODO IMPLEMENT END OF GAME AND RANDOM ENCOUNTER
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

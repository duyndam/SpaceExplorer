package gui;
import Game.StartGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Component;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CharacterCreationFrame extends JFrame {

	private JPanel contentPane;
	private boolean spaceShip1 = true;
	private boolean spaceShip2 = false;
	private boolean spaceShip3 = false;
	
	private boolean bAdd = true;
	private static int actualMemberCount = 0;
	private int indexModify = 0;
	
	private int actualCrewNameSetter = 0;
	
	private int iTypeCrewMember1 = -1;
	private int iTypeCrewMember2 = -1;
	private int iTypeCrewMember3 = -1;
	private int iTypeCrewMember4 = -1;
	
	private String crewMember1Name = "";
	private String crewMember2Name = "";
	private String crewMember3Name = "";
	private String crewMember4Name = "";
	private JTextField txtf_name;
	private JTextField txtf_spaceshipName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterCreationFrame frame = new CharacterCreationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CharacterCreationFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CharacterCreationFrame.class.getResource("/graphics/game_icon_sun.png")));
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		Timer timer = new Timer("Repeated Interval");
        
		
		JLabel lbl_characterCreation = new JLabel("Create Crew Member");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_characterCreation, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_characterCreation, 387, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_characterCreation, 597, SpringLayout.WEST, contentPane);
		lbl_characterCreation.setForeground(Color.WHITE);
		lbl_characterCreation.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(lbl_characterCreation);
		
		
		JLabel lbl_spaceshipSentence = new JLabel("Choose ur Spaceship:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_characterCreation, 0, SpringLayout.NORTH, lbl_spaceshipSentence);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_spaceshipSentence, -500, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_spaceshipSentence, 407, SpringLayout.WEST, contentPane);
		lbl_spaceshipSentence.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lbl_spaceshipSentence.setForeground(Color.WHITE);
		contentPane.add(lbl_spaceshipSentence);
		
		JLabel lbl_spaceship1 = new JLabel("SELECTED");
		lbl_spaceship1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_spaceship1, 6, SpringLayout.SOUTH, lbl_spaceshipSentence);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_spaceship1, 0, SpringLayout.EAST, lbl_characterCreation);
		
		lbl_spaceship1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/spaceship_1.png")).getImage().getScaledInstance(230, 100, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_spaceship1);
		
		JLabel lbl_spaceship2 = new JLabel("");
		lbl_spaceship2.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_spaceship2, 0, SpringLayout.SOUTH, lbl_spaceship1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_spaceship2, -39, SpringLayout.WEST, lbl_spaceship1);
		
		lbl_spaceship2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/spaceship_2.png")).getImage().getScaledInstance(230, 100, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_spaceship2);
		
		JLabel lbl_spaceship3 = new JLabel("");
		lbl_spaceship3.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_spaceship3, 0, SpringLayout.NORTH, lbl_spaceship1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_spaceship3, 49, SpringLayout.EAST, lbl_spaceship1);
		lbl_spaceship1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!lbl_spaceship1.getText().equals("SELECTED"))
					lbl_spaceship1.setText("SELECT");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!spaceShip1)
					lbl_spaceship1.setText("");
				else
					lbl_spaceship1.setText("SELECTED");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				spaceShip1 = true;
				spaceShip2 = false;
				spaceShip3 = false;
				lbl_spaceship1.setText("SELECTED");
				lbl_spaceship2.setText("");
				lbl_spaceship3.setText("");
			}
		});
		
		lbl_spaceship2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!lbl_spaceship2.getText().equals("SELECTED"))
					lbl_spaceship2.setText("SELECT");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!spaceShip2)
					lbl_spaceship2.setText("");
				else
					lbl_spaceship2.setText("SELECTED");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				spaceShip1 = false;
				spaceShip2 = true;
				spaceShip3 = false;
				lbl_spaceship1.setText("");
				lbl_spaceship2.setText("SELECTED");
				lbl_spaceship3.setText("");
			}
		});
		
		lbl_spaceship3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!lbl_spaceship3.getText().equals("SELECTED"))
					lbl_spaceship3.setText("SELECT");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!spaceShip3)
					lbl_spaceship3.setText("");
				else
					lbl_spaceship3.setText("SELECTED");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				spaceShip1 = false;
				spaceShip2 = false;
				spaceShip3 = true;
				lbl_spaceship1.setText("");
				lbl_spaceship2.setText("");
				lbl_spaceship3.setText("SELECTED");
			}
		});
		lbl_spaceship3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/spaceship_3.png")).getImage().getScaledInstance(230, 100, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_spaceship3);
		
		
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lbl_background, lbl_characterCreation, lblNewLabel}));
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lbl_background, lbl_characterCreation}));
		
		
		
		JLabel lbl_pilot = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_pilot, -300, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_pilot, 220, SpringLayout.WEST, contentPane);
		lbl_pilot.setForeground(Color.WHITE);
		lbl_pilot.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_pilot);
		
		JLabel lbl_engineer = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_engineer, 0, SpringLayout.NORTH, lbl_pilot);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_engineer, 45, SpringLayout.EAST, lbl_pilot);
		lbl_engineer.setForeground(Color.WHITE);
		lbl_engineer.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_engineer);
		
		JLabel lbl_scavenger = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_scavenger, 0, SpringLayout.NORTH, lbl_pilot);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_scavenger, 45, SpringLayout.EAST, lbl_engineer);
		lbl_scavenger.setForeground(Color.WHITE);
		lbl_scavenger.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_scavenger);
		
		JLabel lbl_navigator = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_navigator, 0, SpringLayout.NORTH, lbl_pilot);
		lbl_navigator.setForeground(Color.WHITE);
		lbl_navigator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_navigator);
		
		JLabel lbl_soldier = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_soldier, 45, SpringLayout.EAST, lbl_navigator);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_soldier, 0, SpringLayout.SOUTH, lbl_pilot);
		lbl_soldier.setForeground(Color.WHITE);
		lbl_soldier.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 70, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_soldier);
		
		JLabel lbl_doctor = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_navigator, 45, SpringLayout.EAST, lbl_doctor);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_doctor, 0, SpringLayout.NORTH, lbl_pilot);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_doctor, 45, SpringLayout.EAST, lbl_scavenger);
		lbl_doctor.setForeground(Color.WHITE);
		lbl_doctor.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_doctor);
		
		JPanel crewPanel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, crewPanel, 250, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, crewPanel, -270, SpringLayout.EAST, contentPane);
		crewPanel.setBackground(Color.BLUE);
		crewPanel.setOpaque(true);
		contentPane.add(crewPanel);
		crewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_crewMember1 = new JLabel("");
		lbl_crewMember1.setForeground(Color.WHITE);
		lbl_crewMember1.setVisible(false);
		crewPanel.add(lbl_crewMember1);
		
		JLabel lbl_crewMember2 = new JLabel("");
		lbl_crewMember2.setForeground(Color.WHITE);
		lbl_crewMember2.setVisible(false);
		crewPanel.add(lbl_crewMember2);
		
		JLabel lbl_crewMember3 = new JLabel("");
		lbl_crewMember3.setForeground(Color.WHITE);
		lbl_crewMember3.setVisible(false);		
		crewPanel.add(lbl_crewMember3);

		
		JLabel lbl_crewMember4 = new JLabel("");
		lbl_crewMember4.setForeground(Color.WHITE);
		lbl_crewMember4.setVisible(false);
		crewPanel.add(lbl_crewMember4);
		
		JLabel lbl_Crew = new JLabel("Crew");
		sl_contentPane.putConstraint(SpringLayout.NORTH, crewPanel, 20, SpringLayout.SOUTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, crewPanel, 100, SpringLayout.SOUTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_Crew, 330, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_Crew, 468, SpringLayout.WEST, contentPane);
		lbl_Crew.setForeground(Color.WHITE);
		lbl_Crew.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(lbl_Crew);
		
		txtf_name = new JTextField();
		txtf_name.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtf_name.setBackground(Color.BLUE);
		txtf_name.setForeground(Color.WHITE);

		txtf_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				switch(actualCrewNameSetter)
				{
					case 1:
						crewMember1Name = txtf_name.getText();
						break;
					case 2:
						crewMember2Name = txtf_name.getText();
						break;
					case 3:
						crewMember3Name = txtf_name.getText();
						break;
					case 4:
						crewMember4Name = txtf_name.getText();
						break;
				}
			}
		});

		

		txtf_name.setVisible(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtf_name, 450, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtf_name, -80, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtf_name, -450, SpringLayout.EAST, contentPane);
		contentPane.add(txtf_name);
		txtf_name.setColumns(10);
		
		
		JButton btn_startAdventure = new JButton("Start Adventure");
		btn_startAdventure.setBackground(Color.BLUE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btn_startAdventure, 21, SpringLayout.SOUTH, txtf_name);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btn_startAdventure, -28, SpringLayout.SOUTH, contentPane);
		btn_startAdventure.setVisible(false);
		btn_startAdventure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				StartGame.m_stringInputGUI = "";
				StartGame.m_stringInputGUI += actualMemberCount + ",";
				StartGame.m_stringInputGUI += txtf_spaceshipName.getText() + ",";
				if(iTypeCrewMember1 != -1)
				{
					StartGame.m_stringInputGUI += crewMember1Name + "," + iTypeCrewMember1 + ",";
				}
				if(iTypeCrewMember2 != -1)
				{
					StartGame.m_stringInputGUI += crewMember2Name + "," + iTypeCrewMember2 + ",";
				}
				if(iTypeCrewMember3 != -1)
				{
					StartGame.m_stringInputGUI += crewMember3Name + "," + iTypeCrewMember3 + ",";
				}
				if(iTypeCrewMember4 != -1)
				{
					StartGame.m_stringInputGUI += crewMember4Name + "," + iTypeCrewMember4 + ",";
				}
				StartGame.m_stringInputReadyGUI = true;
				while(!StartGame.m_stringInputReadyLogic)
				{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				StartGame.m_stringInputReadyLogic = false;
				
				String[] strArguments = new String[1];
				if(spaceShip1)
				{
					strArguments[0] = "/graphics/spaceship_1.png";
				}
				if(spaceShip2)
				{
					strArguments[0] = "/graphics/spaceship_2.png";
				}
				if(spaceShip3)
				{
					strArguments[0] = "/graphics/spaceship_3.png";
				}
				
				DailyFrame myDaily = new DailyFrame(strArguments);
				myDaily.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btn_startAdventure, 422, SpringLayout.WEST, contentPane);
		btn_startAdventure.setForeground(Color.BLACK);
		btn_startAdventure.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		contentPane.add(btn_startAdventure);
		
		JLabel lbl_SpaceshipName = new JLabel("Name of Spaceship");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_SpaceshipName, 190, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_SpaceshipName, 432, SpringLayout.WEST, contentPane);
		lbl_SpaceshipName.setForeground(Color.WHITE);
		lbl_SpaceshipName.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		contentPane.add(lbl_SpaceshipName);
		
		txtf_spaceshipName = new JTextField();
		txtf_spaceshipName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtf_spaceshipName.setForeground(Color.WHITE);
		txtf_spaceshipName.setBackground(Color.BLUE);
		txtf_spaceshipName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(actualMemberCount == 2)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 2 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 3)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 3 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 4)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 4 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(actualMemberCount == 2)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 2 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 3)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 3 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 4)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 4 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtf_spaceshipName, 215, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtf_spaceshipName, 449, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtf_spaceshipName, -450, SpringLayout.EAST, contentPane);
		contentPane.add(txtf_spaceshipName);
		txtf_spaceshipName.setColumns(10);
		
		
		
		
		lbl_pilot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean bMemberCountRaised = false;
				if(lbl_crewMember1.getIcon() == null && bAdd == true)
				{
					indexModify = 1;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember2.getIcon() == null && bAdd == true)
				{
					indexModify = 2;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember3.getIcon() == null && bAdd == true)
				{
					indexModify = 3;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember4.getIcon() == null && bAdd == true)
				{
					indexModify = 4;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				switch(indexModify)
				{
				case 1:
					lbl_crewMember1.setVisible(true);
					lbl_crewMember1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember1 = 0;
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember2 = 0;
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember3 = 0;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember4 = 0;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("Modifying");
					break;
				}
				if(actualMemberCount == 4 && bMemberCountRaised == true)
				{
					indexModify = 5;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_pilot.setText("PILOT");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_pilot.setText("");
			}
		});
		
		lbl_engineer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean bMemberCountRaised = false;
				if(lbl_crewMember1.getIcon() == null && bAdd == true)
				{
					indexModify = 1;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember2.getIcon() == null && bAdd == true)
				{
					indexModify = 2;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember3.getIcon() == null && bAdd == true)
				{
					indexModify = 3;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember4.getIcon() == null && bAdd == true)
				{
					indexModify = 4;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				switch(indexModify)
				{
				case 1:
					lbl_crewMember1.setVisible(true);
					lbl_crewMember1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember1 = 1;
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember2 = 1;
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember3 = 1;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember4 = 1;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("Modifying");
					break;
				}
				if(actualMemberCount == 4 && bMemberCountRaised == true)
				{
					indexModify = 5;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_engineer.setText("ENGINEER");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_engineer.setText("");
			}
		});
		
		lbl_scavenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean bMemberCountRaised = false;
				if(lbl_crewMember1.getIcon() == null && bAdd == true)
				{
					indexModify = 1;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember2.getIcon() == null && bAdd == true)
				{
					indexModify = 2;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember3.getIcon() == null && bAdd == true)
				{
					indexModify = 3;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember4.getIcon() == null && bAdd == true)
				{
					indexModify = 4;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				switch(indexModify)
				{
				case 1:
					lbl_crewMember1.setVisible(true);
					lbl_crewMember1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember1 = 4;
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember2 = 4;
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember3 = 4;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember4 = 4;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("Modifying");
					break;
				}
				if(actualMemberCount == 4 && bMemberCountRaised == true)
				{
					indexModify = 5;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_scavenger.setText("SCAVENGER");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_scavenger.setText("");
			}
		});
		
		lbl_navigator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean bMemberCountRaised = false;
				if(lbl_crewMember1.getIcon() == null && bAdd == true)
				{
					indexModify = 1;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember2.getIcon() == null && bAdd == true)
				{
					indexModify = 2;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember3.getIcon() == null && bAdd == true)
				{
					indexModify = 3;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember4.getIcon() == null && bAdd == true)
				{
					indexModify = 4;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				switch(indexModify)
				{
				case 1:
					lbl_crewMember1.setVisible(true);
					lbl_crewMember1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember1 = 5;
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember2 = 5;
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember3 = 5;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember4 = 5;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("Modifying");
					break;
				}
				if(actualMemberCount == 4 && bMemberCountRaised == true)
				{
					indexModify = 5;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_navigator.setText("NAVIGATOR");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_navigator.setText("");
			}
		});
		
		lbl_soldier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean bMemberCountRaised = false;
				if(lbl_crewMember1.getIcon() == null && bAdd == true)
				{
					indexModify = 1;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember2.getIcon() == null && bAdd == true)
				{
					indexModify = 2;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember3.getIcon() == null && bAdd == true)
				{
					indexModify = 3;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember4.getIcon() == null && bAdd == true)
				{
					indexModify = 4;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				switch(indexModify)
				{
				case 1:
					lbl_crewMember1.setVisible(true);
					lbl_crewMember1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
					iTypeCrewMember1 = 2;
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
					iTypeCrewMember2 = 2;
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
					iTypeCrewMember3 = 2;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
					iTypeCrewMember4 = 2;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("Modifying");
					break;
				}
				if(actualMemberCount == 4 && bMemberCountRaised == true)
				{
					indexModify = 5;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_soldier.setText("SOLDIER");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_soldier.setText("");
			}
		});
		
		lbl_doctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean bMemberCountRaised = false;
				if(lbl_crewMember1.getIcon() == null && bAdd == true)
				{
					indexModify = 1;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember2.getIcon() == null && bAdd == true)
				{
					indexModify = 2;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember3.getIcon() == null && bAdd == true)
				{
					indexModify = 3;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				else if(lbl_crewMember4.getIcon() == null && bAdd == true)
				{
					indexModify = 4;
					bMemberCountRaised = true;
					actualMemberCount++;
				}
				switch(indexModify)
				{
				case 1:
					lbl_crewMember1.setVisible(true);
					lbl_crewMember1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember1 = 3;
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember2 = 3;
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember3 = 3;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					iTypeCrewMember4 = 3;
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("Modifying");
					
					break;
				}
				if(actualMemberCount == 4 && bMemberCountRaised == true)
				{
					indexModify = 5;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_doctor.setText("DOCTOR");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_doctor.setText("");
			}
		});
		
		lbl_crewMember1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					if(lbl_crewMember1.getText().equals("Modifying"))
					{
						bAdd = true;
					}
					actualMemberCount--;
					if(actualMemberCount < 2)
					{
						btn_startAdventure.setVisible(false);
					}
					iTypeCrewMember1 = -1;
					crewMember1Name = "";
					lbl_crewMember1.setIcon(null);
					lbl_crewMember1.setText("");
					lbl_crewMember1.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember1.getText().equals("Modifying"))
					{
						txtf_name.setVisible(false);
						lbl_crewMember1.setText("");
						crewMember1Name = txtf_name.getText();
						bAdd = true;
					}
					else
					{
						lbl_crewMember1.setText("Modifying");
						actualCrewNameSetter = 1;
						txtf_name.setText(crewMember1Name);
						txtf_name.setVisible(true);
					}
					indexModify = 1;
					lbl_crewMember2.setText("");
					lbl_crewMember3.setText("");
					lbl_crewMember4.setText("");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!lbl_crewMember1.getText().equals("Modifying"))
					lbl_crewMember1.setText("MODIFY/REMOVE");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!lbl_crewMember1.getText().equals("Modifying"))
					lbl_crewMember1.setText("");
			}
		});
		
		lbl_crewMember2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					if(lbl_crewMember2.getText().equals("Modifying"))
					{
						bAdd = true;
					}
					actualMemberCount--;
					if(actualMemberCount < 2)
					{
						btn_startAdventure.setVisible(false);
					}
					iTypeCrewMember2 = -1;
					crewMember2Name = "";
					lbl_crewMember2.setIcon(null);
					lbl_crewMember2.setText("");
					lbl_crewMember2.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember2.getText().equals("Modifying"))
					{
						txtf_name.setVisible(false);
						lbl_crewMember2.setText("");
						crewMember2Name = txtf_name.getText();
						bAdd = true;
					}
					else
					{
						lbl_crewMember2.setText("Modifying");
						actualCrewNameSetter = 2;
						txtf_name.setText(crewMember2Name);
						txtf_name.setVisible(true);
					}
					indexModify = 2;
					lbl_crewMember1.setText("");
					lbl_crewMember3.setText("");
					lbl_crewMember4.setText("");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!lbl_crewMember2.getText().equals("Modifying"))
					lbl_crewMember2.setText("MODIFY/REMOVE");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!lbl_crewMember2.getText().equals("Modifying"))
					lbl_crewMember2.setText("");
			}
		});
		
		lbl_crewMember3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					if(lbl_crewMember3.getText().equals("Modifying"))
					{
						bAdd = true;
					}
					actualMemberCount--;
					if(actualMemberCount < 2)
					{
						btn_startAdventure.setVisible(false);
					}
					iTypeCrewMember3 = -1;
					crewMember3Name = "";
					lbl_crewMember3.setIcon(null);
					lbl_crewMember3.setText("");
					lbl_crewMember3.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember3.getText().equals("Modifying"))
					{
						txtf_name.setVisible(false);
						lbl_crewMember3.setText("");
						crewMember3Name = txtf_name.getText();
						bAdd = true;
					}
					else
					{
						lbl_crewMember3.setText("Modifying");
						actualCrewNameSetter = 3;
						txtf_name.setText(crewMember3Name);
						txtf_name.setVisible(true);
					}
					indexModify = 3;
					lbl_crewMember1.setText("");
					lbl_crewMember2.setText("");
					lbl_crewMember4.setText("");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!lbl_crewMember3.getText().equals("Modifying"))
					lbl_crewMember3.setText("MODIFY/REMOVE");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!lbl_crewMember3.getText().equals("Modifying"))
					lbl_crewMember3.setText("");
			}
		});
		
		lbl_crewMember4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(SwingUtilities.isRightMouseButton(e))
				{
					if(lbl_crewMember4.getText().equals("Modifying"))
					{
						bAdd = true;
					}
					actualMemberCount--;
					if(actualMemberCount < 2)
					{
						btn_startAdventure.setVisible(false);
					}
					iTypeCrewMember4 = -1;
					lbl_crewMember4.setIcon(null);
					lbl_crewMember4.setText("");
					lbl_crewMember4.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember4.getText().equals("Modifying"))
					{
						txtf_name.setVisible(false);
						lbl_crewMember4.setText("");
						crewMember4Name = txtf_name.getText();
						bAdd = true;
					}
					else
					{
						lbl_crewMember4.setText("Modifying");
						actualCrewNameSetter = 4;
						txtf_name.setText(crewMember4Name);
						txtf_name.setVisible(true);
					}
					
					crewMember4Name = "";
					indexModify = 4;
					lbl_crewMember2.setText("");
					lbl_crewMember3.setText("");
					lbl_crewMember1.setText("");
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!lbl_crewMember4.getText().equals("Modifying"))
					lbl_crewMember4.setText("MODIFY/REMOVE");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!lbl_crewMember4.getText().equals("Modifying"))
					lbl_crewMember4.setText("");
			}
		});
		
		TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	if(actualMemberCount >= 2)
            	{
            		if(actualMemberCount == 2)
            		{
            			int iCount = 0;
            			if(!crewMember1Name.equals(""))
            				iCount++;
            			if(!crewMember2Name.equals(""))
            				iCount++;
            			if(!crewMember3Name.equals(""))
            				iCount++;
            			if(!crewMember4Name.equals(""))
            				iCount++;
            			if(iCount == 2 && !txtf_spaceshipName.getText().equals(""))
            				btn_startAdventure.setVisible(true);
            			else
            				btn_startAdventure.setVisible(false);
            		}
            		if(actualMemberCount == 3)
            		{
            			int iCount = 0;
            			if(!crewMember1Name.equals(""))
            				iCount++;
            			if(!crewMember2Name.equals(""))
            				iCount++;
            			if(!crewMember3Name.equals(""))
            				iCount++;
            			if(!crewMember4Name.equals(""))
            				iCount++;
            			if(iCount == 3 && !txtf_spaceshipName.getText().equals(""))
            				btn_startAdventure.setVisible(true);
            			else
            				btn_startAdventure.setVisible(false);
            		}
            		if(actualMemberCount == 4)
            		{
            			int iCount = 0;
            			if(!crewMember1Name.equals(""))
            				iCount++;
            			if(!crewMember2Name.equals(""))
            				iCount++;
            			if(!crewMember3Name.equals(""))
            				iCount++;
            			if(!crewMember4Name.equals(""))
            				iCount++;
            			if(iCount == 4 && !txtf_spaceshipName.getText().equals(""))
            				btn_startAdventure.setVisible(true);
            			else
            				btn_startAdventure.setVisible(false);
            		}
            	}
                //System.out.println("Execution time is :" + System.currentTimeMillis() + " Name of the thread is :" + Thread.currentThread().getName());
            }
        };
        long duration = 1500;
        long delay= 1000;
        timer.schedule(task, delay,duration);
		
        txtf_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(actualCrewNameSetter)
				{
					case 1:
						crewMember1Name = txtf_name.getText();
						break;
					case 2:
						crewMember2Name = txtf_name.getText();
						break;
					case 3:
						crewMember3Name = txtf_name.getText();
						break;
					case 4:
						crewMember4Name = txtf_name.getText();
						break;
				}
				
				if(actualMemberCount == 2)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 2 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 3)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 3 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 4)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 4 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
			}
        	@Override
        	public void keyReleased(KeyEvent e) {
        		switch(actualCrewNameSetter)
				{
					case 1:
						crewMember1Name = txtf_name.getText();
						break;
					case 2:
						crewMember2Name = txtf_name.getText();
						break;
					case 3:
						crewMember3Name = txtf_name.getText();
						break;
					case 4:
						crewMember4Name = txtf_name.getText();
						break;
				}
				
				if(actualMemberCount == 2)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 2 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 3)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 3 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        		if(actualMemberCount == 4)
        		{
        			int iCount = 0;
        			if(!crewMember1Name.equals(""))
        				iCount++;
        			if(!crewMember2Name.equals(""))
        				iCount++;
        			if(!crewMember3Name.equals(""))
        				iCount++;
        			if(!crewMember4Name.equals(""))
        				iCount++;
        			if(iCount == 4 && !txtf_spaceshipName.getText().equals(""))
        				btn_startAdventure.setVisible(true);
        			else
        				btn_startAdventure.setVisible(false);
        		}
        	}
		});
        
		JLabel lbl_background = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_background, -5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_background, -5, SpringLayout.WEST, contentPane);
		lbl_background.setBounds(0, 0, 0, 0);
		lbl_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/background_main.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lbl_background);
	}
}

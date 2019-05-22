package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class CharacterCreationFrame extends JFrame {

	private JPanel contentPane;
	private boolean spaceShip1 = false;
	private boolean spaceShip2 = false;
	private boolean spaceShip3 = false;
	
	private boolean bAdd = true;
	private int actualMemberCount = 0;
	private int indexModify = 0;
	
	
	private String oldStringCrewMember1 = "";
	private String oldStringCrewMember2 = "";
	private String oldStringCrewMember3 = "";
	private String oldStringCrewMember4 = "";
	
	private String crewMember1Name = "";
	private String crewMember2Name = "";
	private String crewMember3Name = "";
	private String crewMember4Name = "";
	private JTextField textField;

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
		
		
		
		JLabel lbl_characterCreation = new JLabel("Create Crew Member");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_characterCreation, 50, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_characterCreation, 387, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_characterCreation, 597, SpringLayout.WEST, contentPane);
		lbl_characterCreation.setForeground(Color.BLUE);
		lbl_characterCreation.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(lbl_characterCreation);
		
		
		JLabel lbl_spaceshipSentence = new JLabel("Choose ur Spaceship:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_spaceshipSentence, -432, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_characterCreation, -10, SpringLayout.NORTH, lbl_spaceshipSentence);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_spaceshipSentence, 407, SpringLayout.WEST, contentPane);
		lbl_spaceshipSentence.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lbl_spaceshipSentence.setForeground(Color.BLUE);
		contentPane.add(lbl_spaceshipSentence);
		
		JLabel lbl_spaceship1 = new JLabel("");
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
		lbl_pilot.setForeground(Color.WHITE);
		lbl_pilot.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_pilot);
		
		JLabel lbl_engineer = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_pilot, -46, SpringLayout.WEST, lbl_engineer);
		lbl_engineer.setForeground(Color.WHITE);
		lbl_engineer.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_engineer);
		
		JLabel lbl_scavenger = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_scavenger, 410, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_engineer, -46, SpringLayout.WEST, lbl_scavenger);
		lbl_scavenger.setForeground(Color.WHITE);
		lbl_scavenger.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_scavenger);
		
		JLabel lbl_navigator = new JLabel("");
		lbl_navigator.setForeground(Color.WHITE);
		lbl_navigator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_navigator);
		
		JLabel lbl_soldier = new JLabel("");
		lbl_soldier.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_soldier, 50, SpringLayout.EAST, lbl_navigator);
		lbl_soldier.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 70, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_soldier);
		
		JLabel lbl_doctor = new JLabel("");
		lbl_doctor.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_navigator, 50, SpringLayout.EAST, lbl_doctor);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_doctor, 50, SpringLayout.EAST, lbl_scavenger);
		lbl_doctor.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_doctor);
		
		JPanel crewPanel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, crewPanel, 230, SpringLayout.WEST, contentPane);
		crewPanel.setBackground(Color.BLUE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, crewPanel, -25, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, crewPanel, -230, SpringLayout.EAST, contentPane);
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, crewPanel, 12, SpringLayout.SOUTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_soldier, -26, SpringLayout.NORTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_navigator, -26, SpringLayout.NORTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_doctor, -26, SpringLayout.NORTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_scavenger, -26, SpringLayout.NORTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_engineer, -26, SpringLayout.NORTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_pilot, -26, SpringLayout.NORTH, lbl_Crew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_Crew, -143, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_Crew, 468, SpringLayout.WEST, contentPane);
		lbl_Crew.setForeground(Color.BLUE);
		lbl_Crew.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		contentPane.add(lbl_Crew);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 450, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -40, SpringLayout.SOUTH, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
					lbl_crewMember1.setIcon(null);
					lbl_crewMember1.setText("");
					lbl_crewMember1.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember1.getText().equals("Modifying"))
					{
						lbl_crewMember1.setText("");
						bAdd = true;
					}
					else
					{
						lbl_crewMember1.setText("Modifying");
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
					lbl_crewMember2.setIcon(null);
					lbl_crewMember2.setText("");
					lbl_crewMember2.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember2.getText().equals("Modifying"))
					{
						lbl_crewMember2.setText("");
						bAdd = true;
					}
					else
					{
						lbl_crewMember2.setText("Modifying");
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
					lbl_crewMember3.setIcon(null);
					lbl_crewMember3.setText("");
					lbl_crewMember3.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember3.getText().equals("Modifying"))
					{
						lbl_crewMember3.setText("");
						bAdd = true;
					}
					else
					{
						lbl_crewMember3.setText("Modifying");
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
					lbl_crewMember4.setIcon(null);
					lbl_crewMember4.setText("");
					lbl_crewMember4.setVisible(false);
				}
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					bAdd = false;
					if(lbl_crewMember4.getText().equals("Modifying"))
					{
						lbl_crewMember4.setText("");
						bAdd = true;
					}
					else
					{
						lbl_crewMember4.setText("Modifying");
					}
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
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_pilot.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
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
				lbl_pilot.setText("SELECT");
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
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_engineer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
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
				lbl_engineer.setText("SELECT");
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
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_normal.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
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
				lbl_scavenger.setText("SELECT");
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
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_navigator.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
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
				lbl_navigator.setText("SELECT");
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
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_soldier.png")).getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
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
				lbl_soldier.setText("SELECT");
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
//					lbl_crewMember2.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember1.setText("Modifying");
					break;
				case 2:
					lbl_crewMember2.setVisible(true);
					lbl_crewMember2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember3.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember2.setText("Modifying");
					break;
				case 3:
					lbl_crewMember3.setVisible(true);
					lbl_crewMember3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//					lbl_crewMember1.setText("");
//					lbl_crewMember2.setText("");
//					lbl_crewMember4.setText("");
//					lbl_crewMember3.setText("Modifying");
					break;
				case 4:
					lbl_crewMember4.setVisible(true);
					lbl_crewMember4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/penguin_medical_officer.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
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
				lbl_doctor.setText("SELECT");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_doctor.setText("");
			}
		});
//		JLabel lbl_background = new JLabel("");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_background, -5, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_background, -5, SpringLayout.WEST, contentPane);
//		lbl_background.setBounds(0, 0, 0, 0);
//		lbl_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/background_main.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
//		contentPane.add(lbl_background);
	}
}

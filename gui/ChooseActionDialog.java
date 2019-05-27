package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.StartGame;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ChooseActionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_Selector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChooseActionDialog dialog = new ChooseActionDialog(args);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChooseActionDialog(String[] args) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				StartGame.m_stringInputGUI = "6";
				StartGame.m_stringInputReadyGUI = true;
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChooseActionDialog.class.getResource("/graphics/game_icon_sun.png")));
		setTitle("Action Picker");
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbl_Selector = new JLabel("");
			lbl_Selector.setVisible(false);
			lbl_Selector.setBounds(0, 0, 20, 20); 
			lbl_Selector.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/game_icon_sun.png")).getImage().getScaledInstance(lbl_Selector.getWidth(),lbl_Selector.getHeight(), Image.SCALE_DEFAULT)));
			contentPanel.add(lbl_Selector);
		}
		{
			JLabel lbl_pilotShip = new JLabel("Pilot the ship");
			lbl_pilotShip.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StartGame.m_stringInputGUI = "1";
					StartGame.m_stringInputReadyGUI = true;
					while(!StartGame.m_stringInputReadyLogic)
					{
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					StartGame.m_stringInputReadyLogic = false;
					dispose();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_Selector.setVisible(true);
					lbl_Selector.setBounds(55, 10, 20, 20);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_Selector.setVisible(false);
				}
			});
			lbl_pilotShip.setFont(new Font("Snap ITC", Font.PLAIN, 11));
			lbl_pilotShip.setForeground(Color.WHITE);
			lbl_pilotShip.setBounds(98, 10, 98, 15);
			contentPanel.add(lbl_pilotShip);
		}
		{
			JLabel lbl_useItem = new JLabel("Use an item");
			if(args.length == 2)
			{
				if(args[1].equals("0"))
				{
					lbl_useItem.setEnabled(false);
				}
			}
			lbl_useItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(lbl_useItem.isEnabled())
					{
						StartGame.m_stringInputGUI = "2";
						StartGame.m_stringInputReadyGUI = true;
						while(!StartGame.m_stringInputReadyLogic)
						{
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						StartGame.m_stringInputReadyLogic = false;
						ItemPickerDialog choseItem = new ItemPickerDialog(StartGame.m_stringInputLogic.split(","));
						choseItem.setVisible(true);
						//choseItem.setModal(true);
						dispose();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_Selector.setVisible(true);
					lbl_Selector.setBounds(55, 30, 20, 20); 
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_Selector.setVisible(false);
				}
			});
			lbl_useItem.setForeground(Color.WHITE);
			lbl_useItem.setFont(new Font("Snap ITC", Font.PLAIN, 11));
			lbl_useItem.setBounds(104, 36, 86, 15);
			contentPanel.add(lbl_useItem);
		}
		{
			JLabel lbl_sleep = new JLabel("Sleep");
			lbl_sleep.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StartGame.m_stringInputGUI = "3";
					StartGame.m_stringInputReadyGUI = true;
					while(!StartGame.m_stringInputReadyLogic)
					{
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					StartGame.m_stringInputReadyLogic = false;
					dispose();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_Selector.setVisible(true);
					lbl_Selector.setBounds(55, 60, 20, 20); 
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_Selector.setVisible(false);
				}
			});
			lbl_sleep.setForeground(Color.WHITE);
			lbl_sleep.setFont(new Font("Snap ITC", Font.PLAIN, 11));
			lbl_sleep.setBounds(126, 62, 42, 15);
			contentPanel.add(lbl_sleep);
		}
		{
			JLabel lbl_visitPlanet = new JLabel("Visit the planet");
			lbl_visitPlanet.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StartGame.m_stringInputGUI = "4";
					StartGame.m_stringInputReadyGUI = true;
					while(!StartGame.m_stringInputReadyLogic)
					{
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					StartGame.m_stringInputReadyLogic = false;
					dispose();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_Selector.setVisible(true);
					lbl_Selector.setBounds(55, 86, 20, 20);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_Selector.setVisible(false);
				}
			});
			lbl_visitPlanet.setForeground(Color.WHITE);
			lbl_visitPlanet.setFont(new Font("Snap ITC", Font.PLAIN, 11));
			lbl_visitPlanet.setBounds(91, 88, 111, 15);
			contentPanel.add(lbl_visitPlanet);
		}
		{
			JLabel lblRepairShip = new JLabel("Repair Ship");
			lblRepairShip.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StartGame.m_stringInputGUI = "5";
					StartGame.m_stringInputReadyGUI = true;
					while(!StartGame.m_stringInputReadyLogic)
					{
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					StartGame.m_stringInputReadyLogic = false;
					dispose();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_Selector.setVisible(true);
					lbl_Selector.setBounds(55, 112, 20, 20);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbl_Selector.setVisible(false);
				}
			});
			lblRepairShip.setForeground(Color.WHITE);
			lblRepairShip.setFont(new Font("Snap ITC", Font.PLAIN, 11));
			lblRepairShip.setBounds(104, 114, 86, 15);
			contentPanel.add(lblRepairShip);
		}
		
	}

}

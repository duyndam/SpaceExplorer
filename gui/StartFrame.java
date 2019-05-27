package gui;
import Game.StartGame;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_inputDays;
	private CharacterCreationFrame createCharFrame;
	private JLabel lbl_invalid_input;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		setResizable(false);
		setTitle("Space Explorer");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartFrame.class.getResource("/graphics/game_icon_sun.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		//sl_contentPane.putConstraint(SpringLayout.SOUTH, tf_inputDays, -17, SpringLayout.NORTH, btn_gameStart);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tf_inputDays, lbl_questionDays, btn_gameStart}));
		tf_inputDays = new JTextField();
		tf_inputDays.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lbl_invalid_input.setVisible(false);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, tf_inputDays, 76, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tf_inputDays, -215, SpringLayout.EAST, contentPane);
		contentPane.add(tf_inputDays);
		tf_inputDays.setHorizontalAlignment(SwingConstants.CENTER);
		tf_inputDays.setColumns(3);
		
		
		JButton btn_gameStart = new JButton("Start Game");
		btn_gameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartGame.m_stringInputReadyGUI = true;
				StartGame.m_stringInputGUI = tf_inputDays.getText();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(StartGame.m_stringInputReadyLogic)
				{
					if(StartGame.m_stringInputLogic.equals("1"))
					{
						lbl_invalid_input.setVisible(false);
						createCharFrame = new CharacterCreationFrame();
						createCharFrame.setVisible(true);
						setVisible(false);
					}
					else
					{
						lbl_invalid_input.setVisible(true);
					}
					StartGame.m_stringInputReadyLogic = false;
				}
			}
		});
		btn_gameStart.setBackground(Color.BLUE);
		btn_gameStart.setForeground(Color.BLACK);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btn_gameStart, 119, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btn_gameStart, -180, SpringLayout.EAST, contentPane);
		contentPane.add(btn_gameStart);
		btn_gameStart.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		
		
		
		JLabel lbl_questionDays = new JLabel("How many Days you want to play?(3-10)");
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_questionDays, 47, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_questionDays, -14, SpringLayout.NORTH, tf_inputDays);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_questionDays, 397, SpringLayout.WEST, contentPane);
		lbl_questionDays.setForeground(Color.WHITE);
		contentPane.add(lbl_questionDays);
		lbl_questionDays.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lbl_questionDays.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_invalid_input = new JLabel("Invalid Input, days must be between 3 and 10");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_invalid_input, 28, SpringLayout.SOUTH, btn_gameStart);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_invalid_input, 35, SpringLayout.WEST, contentPane);
		lbl_invalid_input.setVisible(false);
		lbl_invalid_input.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_invalid_input.setForeground(Color.ORANGE);
		lbl_invalid_input.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		contentPane.add(lbl_invalid_input);
		
		JLabel lbl_background = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_background, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_background, 0, SpringLayout.WEST, contentPane);
		lbl_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/time_bg.jpg")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lbl_background);
	}
	

}

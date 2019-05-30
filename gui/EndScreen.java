package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.StartGame;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class EndScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndScreen frame = new EndScreen(args);
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
	public EndScreen(String[] args) {
		int iCounterVariable = 0;
		setTitle("Space Explorer");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EndScreen.class.getResource("/graphics/game_icon_sun.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Spaceship = new JLabel("");
		lbl_Spaceship.setBounds(50, 0, 280, 150);
		lbl_Spaceship.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(args[iCounterVariable++])).getImage().getScaledInstance(280, 150, Image.SCALE_DEFAULT)));
		contentPane.add(lbl_Spaceship);
		
		JLabel lbl_Spaceship_name = new JLabel("New label");
		lbl_Spaceship_name.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_Spaceship_name.setForeground(Color.WHITE);
		lbl_Spaceship_name.setBounds(86, 100, 250, 25);
		lbl_Spaceship_name.setText(args[iCounterVariable++]);
		contentPane.add(lbl_Spaceship_name);
		
		JLabel lbl_DaysTaken = new JLabel("New label");
		lbl_DaysTaken.setForeground(Color.WHITE);
		lbl_DaysTaken.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_DaysTaken.setBounds(86, 135, 262, 25);
		lbl_DaysTaken.setText("The game took " + StartGame.m_iActualDay + " Days to finish");
		contentPane.add(lbl_DaysTaken);
		
		JLabel lbl_PiecesMessage = new JLabel("New label");
		lbl_PiecesMessage.setForeground(Color.WHITE);
		lbl_PiecesMessage.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_PiecesMessage.setBounds(40, 170, 350, 25);
		if(StartGame.m_iActualParts >= StartGame.m_iParts)
		{
			lbl_PiecesMessage.setText("You found all pieces " + Integer.toString(StartGame.m_iActualParts) + "/" + Integer.toString(StartGame.m_iParts));
		}
		else
		{
			lbl_PiecesMessage.setText("You found " + Integer.toString(StartGame.m_iActualParts) + "/" + Integer.toString(StartGame.m_iParts) + " pieces, sadly not all");
		}
		contentPane.add(lbl_PiecesMessage);
		
		JLabel lbl_Score = new JLabel("New label");
		lbl_Score.setForeground(Color.WHITE);
		lbl_Score.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_Score.setBounds(42, 202, 350, 25);
		lbl_Score.setText("Your Score: " + StartGame.score);
		contentPane.add(lbl_Score);
	}
}

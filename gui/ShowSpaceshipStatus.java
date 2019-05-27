package gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import Game.StartGame;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShowSpaceshipStatus extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if(args.length == 5)
			{
				ShowSpaceshipStatus dialog = new ShowSpaceshipStatus(args);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShowSpaceshipStatus(String[] args) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				StartGame.m_stringInputReadyGUI = true;
			}
		});
		getContentPane().setBackground(Color.BLACK);
		setTitle("Spaceship Status");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowSpaceshipStatus.class.getResource("/graphics/game_icon_sun.png")));
		setBounds(100, 100, 500, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			int iCounterVariable = 0;
			String strStatusComplete = "<HTML>Name: ";
			strStatusComplete += args[iCounterVariable++] + "<BR>";
			strStatusComplete += "Shield: ";
			strStatusComplete += args[iCounterVariable++] + "%<BR>";
			strStatusComplete += "Hull: ";
			strStatusComplete += args[iCounterVariable++] + "%<BR>";
			strStatusComplete += "NumPiloting: ";
			strStatusComplete += args[iCounterVariable++] + "<HTML>";
				
			JSplitPane splitPane = new JSplitPane()
			{
			    private final int location = 280;
			    {
			        setDividerLocation( location );
			    }
			    @Override
			    public int getDividerLocation() {
			        return location ;
			    }
			    @Override
			    public int getLastDividerLocation() {
			        return location ;
			    }
			};
			splitPane.setBackground(Color.BLUE);
			splitPane.setBounds(42, 60 , 400, 150);
			contentPanel.add(splitPane);
			{
				JLabel lbl_pictureType = new JLabel("");
				lbl_pictureType.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(args[iCounterVariable++])).getImage().getScaledInstance(280, 150, Image.SCALE_DEFAULT)));
				splitPane.setLeftComponent(lbl_pictureType);
			}
			{
				JLabel lbl_Status = new JLabel(strStatusComplete);
				lbl_Status.setFont(new Font("Snap ITC", Font.PLAIN, 11));
				lbl_Status.setForeground(Color.WHITE);
				splitPane.setRightComponent(lbl_Status);
			}
			
		}
		{
			JLabel lbl_Spaceship = new JLabel("Spaceship");
			lbl_Spaceship.setForeground(Color.WHITE);
			lbl_Spaceship.setFont(new Font("Snap ITC", Font.PLAIN, 14));
			lbl_Spaceship.setBounds(201, 5, 91, 40);
			contentPanel.add(lbl_Spaceship);
		}
		
	}

}

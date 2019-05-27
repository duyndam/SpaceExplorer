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

public class ShowCrewStatus extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if(args.length >= 13)
			{
				ShowCrewStatus dialog = new ShowCrewStatus(args);
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
	public ShowCrewStatus(String[] args) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				StartGame.m_stringInputReadyGUI = true;
			}
		});
		setTitle("Crew Status");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowCrewStatus.class.getResource("/graphics/game_icon_sun.png")));
		int iAmountMembers = Integer.parseInt(args[0]);
		switch(iAmountMembers)
		{
		case 2:
			setBounds(100, 100, 320, 300);
			break;
		case 3:
			setBounds(100, 100, 320, 400);
			break;
		case 4:
			setBounds(100, 100, 320, 500);
			break;
		}
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			int iCounterVariable = 1;
			String strStatusComplete = "<HTML>Name: ";
			for(int iCountCrewMember = 0; iCountCrewMember < iAmountMembers * 100; iCountCrewMember+=100)
			{
				strStatusComplete = "<HTML>Name: ";
				strStatusComplete += args[iCounterVariable++] + "<BR>";
				strStatusComplete += "Health: ";
				strStatusComplete += args[iCounterVariable++] + "%<BR>";
				strStatusComplete += "Fatigue: ";
				strStatusComplete += args[iCounterVariable++] + "%<BR>";
				strStatusComplete += "Hunger: ";
				strStatusComplete += args[iCounterVariable++] + "%<BR>";
				strStatusComplete += "Status: ";
				strStatusComplete += args[iCounterVariable++] + "<HTML>";
				
			JSplitPane splitPane = new JSplitPane()
			{
			    private final int location = 60;
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
			splitPane.setBounds(13, 30 + iCountCrewMember, 278, 86);
			contentPanel.add(splitPane);
			{
				JLabel lbl_pictureType = new JLabel("");
				lbl_pictureType.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(args[iCounterVariable++])).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				splitPane.setLeftComponent(lbl_pictureType);
			}
			{
				JLabel lbl_Status = new JLabel(strStatusComplete);
				lbl_Status.setForeground(Color.WHITE);
				lbl_Status.setFont(new Font("Snap ITC", Font.PLAIN, 14));
				splitPane.setRightComponent(lbl_Status);
			}
			}
		}
		{
			JLabel lbl_Crew = new JLabel("Crew");
			lbl_Crew.setForeground(Color.WHITE);
			lbl_Crew.setFont(new Font("Snap ITC", Font.PLAIN, 14));
			lbl_Crew.setBounds(128, 5, 57, 19);
			contentPanel.add(lbl_Crew);
		}
		
	}

}

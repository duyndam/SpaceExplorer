package gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import Game.StartGame;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowCrewActionPicker extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int iMemberIndex = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if(args.length >= 13)
			{
				ShowCrewActionPicker dialog = new ShowCrewActionPicker(args);
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
	public ShowCrewActionPicker(String[] args) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				StartGame.m_stringInputGUI = args[0];
				StartGame.m_stringInputReadyGUI = true;
			}
		});
		
		StartGame.m_stringInputGUI = "4";
		StartGame.m_stringInputReadyGUI = true;
		setTitle("Crew Picker");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowCrewActionPicker.class.getResource("/graphics/game_icon_sun.png")));
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
			String strStatusComplete = "";
			int iActionCounter = 0;
			for(int iCountCrewMember = 0; iCountCrewMember < iAmountMembers * 100; iCountCrewMember+=100)
			{
				strStatusComplete = "<HTML>Name: ";
				strStatusComplete += args[iCounterVariable++] + "<BR>";
				strStatusComplete += "Actions: ";
				strStatusComplete += args[iCounterVariable++] + "<BR>";
				iActionCounter = Integer.parseInt(args[iCounterVariable++]);
				for(int iActionIndex = 0; iActionIndex < iActionCounter; iActionIndex++)
				{
					strStatusComplete += args[iCounterVariable++] + "<BR>";
				}
				
			JSplitPaneIndexed splitPane = new JSplitPaneIndexed()
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
			if(iActionCounter >= 2)
			{
				splitPane.setEnabled(false);
			}
			splitPane.set_IndexCrewMember(iMemberIndex++);
			if(splitPane.isEnabled())
			{
				splitPane.setBackground(Color.BLUE);
			}
			else
			{
				splitPane.setBackground(Color.RED);
			}
			splitPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					if(splitPane.isEnabled())
					{
						StartGame.m_stringInputGUI = Integer.toString(splitPane.get_IndexCrewMember());
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
						if(StartGame.m_stringInputLogic.charAt(0) == '0')
						{
							String[] strArgs = StartGame.m_stringInputLogic.split(",");
							ChooseActionDialog actionDialog = new ChooseActionDialog(strArgs);
							actionDialog.setModal(true);
							actionDialog.setVisible(true);
							dispose();
						}
					}
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(splitPane.isEnabled())
					{
						splitPane.setBackground(Color.CYAN);
					}
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					if(splitPane.isEnabled())
					{
						splitPane.setBackground(Color.BLUE);
					}
				}
			});
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
			JLabel lbl_Crew = new JLabel("Pick a crew Member");
			lbl_Crew.setForeground(Color.WHITE);
			lbl_Crew.setFont(new Font("Snap ITC", Font.PLAIN, 14));
			lbl_Crew.setBounds(66, 5, 181, 19);
			contentPanel.add(lbl_Crew);
		}

		
	}
}

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
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

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
		getContentPane().setBackground(Color.BLACK);
		setTitle("Spaceship Status");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowSpaceshipStatus.class.getResource("/graphics/game_icon_sun.png")));
		setBounds(100, 100, 500, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
			strStatusComplete += args[iCounterVariable++] + "%<HTML>";
				
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
			splitPane.setBounds(42, 60 , 400, 150);
			contentPanel.add(splitPane);
			{
				JLabel lbl_pictureType = new JLabel("");
				lbl_pictureType.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(args[iCounterVariable++])).getImage().getScaledInstance(280, 150, Image.SCALE_DEFAULT)));
				splitPane.setLeftComponent(lbl_pictureType);
			}
			{
				JLabel lbl_Status = new JLabel(strStatusComplete);
				splitPane.setRightComponent(lbl_Status);
			}
			
		}
		{
			JLabel lbl_Spaceship = new JLabel("Spaceship");
			lbl_Spaceship.setForeground(Color.WHITE);
			lbl_Spaceship.setFont(new Font("Snap ITC", Font.PLAIN, 14));
			lbl_Spaceship.setBounds(167, 5, 100, 40);
			contentPanel.add(lbl_Spaceship);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		}
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
		
	}

}

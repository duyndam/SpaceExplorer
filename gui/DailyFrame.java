package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DailyFrame extends JFrame {

	private int iDays = 1;
	private JPanel contentPane;
	JLabel lbl_background = null;
	JLabel lbl_Day = null;
	JLabel lbl_chooseAction = null;
	JLabel lbl_Selector = null;
	JLabel lbl_ShowCrewStatus = null;
	JLabel lbl_ShowSpaceShipStatus = null;
	JLabel lbl_VisitOutpost = null;
	JLabel lbl_DoCrewAction = null;
	JLabel lbl_MoveToNextDay = null;
	DefaultListModel myItemsOutpost = null;
	JList listOutpostInventory = null;
	DefaultListModel myItemsCrew = null;
	JList listCrewInventory = null;
	JScrollPane scrollPaneCrewInventory = null;
	JLabel lbl_CrewInventory = null;
	JButton btnSell_CrewItem = null;
	private JButton btn_sell;
	JLabel lbl_OutpostInventory = null;
	JButton btn_buy = null;
	JScrollPane scrollPaneOutpostInventory = null;
	JButton btn_LeaveOutpost = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DailyFrame frame = new DailyFrame();
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
	public DailyFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DailyFrame.class.getResource("/graphics/game_icon_sun.png")));
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_Day = new JLabel("DAY 1");
		lbl_Day.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lbl_Day.setForeground(Color.WHITE);
		lbl_Day.setBounds(22, 11, 92, 29);
		contentPane.add(lbl_Day);
		
		lbl_chooseAction = new JLabel("Choose your action:");
		lbl_chooseAction.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_chooseAction.setForeground(Color.WHITE);
		lbl_chooseAction.setBounds(22, 45, 135, 14);
		contentPane.add(lbl_chooseAction);
		lbl_Selector = new JLabel("");
		lbl_Selector.setVisible(false);
		lbl_Selector.setBounds(0, 0, 20, 20); //y += 25
												//lbl_Selector.setBounds(15, 98, 20, 20);
												//lbl_Selector.setBounds(15, 123, 20, 20);
												//lbl_Selector.setBounds(15, 148, 20, 20);
												//lbl_Selector.setBounds(15, 173, 20, 20);
		lbl_Selector.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/game_icon_sun.png")).getImage().getScaledInstance(lbl_Selector.getWidth(),lbl_Selector.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lbl_Selector);
		
		lbl_ShowCrewStatus = new JLabel("Show crew status");
		lbl_ShowCrewStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_Selector.setBounds(15, 73, 20, 20);
				lbl_Selector.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_Selector.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] str = {"2","Alfi","100","0","0","ILL","/graphics/penguin_pilot.png","Royal","80","0","50","CRAZY","/graphics/penguin_navigator.png"};
				ShowCrewStatus crewStatusDialog = new ShowCrewStatus(str);
				crewStatusDialog.setModal(true);
				crewStatusDialog.setVisible(true);
				
			}
		});
		lbl_ShowCrewStatus.setForeground(Color.WHITE);
		lbl_ShowCrewStatus.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_ShowCrewStatus.setBounds(50, 75, 125, 20);
		contentPane.add(lbl_ShowCrewStatus);
		
		lbl_ShowSpaceShipStatus = new JLabel("Show spaceship status");
		lbl_ShowSpaceShipStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] str = {"SpaceX","100","100","0","/graphics/spaceship_1.png"};
				ShowSpaceshipStatus spaceshipStatusDialog = new ShowSpaceshipStatus(str);
				spaceshipStatusDialog.setModal(true);
				spaceshipStatusDialog.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_Selector.setBounds(15, 98, 20, 20);
				lbl_Selector.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_Selector.setVisible(false);
			}
		});
		lbl_ShowSpaceShipStatus.setForeground(Color.WHITE);
		lbl_ShowSpaceShipStatus.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_ShowSpaceShipStatus.setBounds(50, 100, 160, 20);
		contentPane.add(lbl_ShowSpaceShipStatus);
		
		lbl_VisitOutpost = new JLabel("Visit Outpost");
		lbl_VisitOutpost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisibilityMainMenue(false);
				setVisibilityOutpostMenue(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_Selector.setBounds(15, 123, 20, 20);
				lbl_Selector.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_Selector.setVisible(false);
			}
		});
		lbl_VisitOutpost.setForeground(Color.WHITE);
		lbl_VisitOutpost.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_VisitOutpost.setBounds(50, 125, 160, 20);
		contentPane.add(lbl_VisitOutpost);
		
		lbl_DoCrewAction = new JLabel("Do crew action");
		lbl_DoCrewAction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_Selector.setBounds(15, 148, 20, 20);
				lbl_Selector.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_Selector.setVisible(false);
			}
		});
		lbl_DoCrewAction.setForeground(Color.WHITE);
		lbl_DoCrewAction.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_DoCrewAction.setBounds(50, 150, 160, 20);
		contentPane.add(lbl_DoCrewAction);
		
		lbl_MoveToNextDay = new JLabel("Move to next day");
		lbl_MoveToNextDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//StartGame.m_stringInputLogic("5");
				//StartGame.m_stringInputReadyLogic = true;
				lbl_Day.setText("DAY " + iDays++);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_Selector.setBounds(15, 173, 20, 20);
				lbl_Selector.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_Selector.setVisible(false);
			}
		});
		lbl_MoveToNextDay.setForeground(Color.WHITE);
		lbl_MoveToNextDay.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		lbl_MoveToNextDay.setBounds(50, 175, 160, 20);
		contentPane.add(lbl_MoveToNextDay);
		
		
		
		myItemsOutpost = new DefaultListModel();
		listOutpostInventory = new JList(myItemsOutpost);
		myItemsOutpost.add(0,"item1");
		myItemsOutpost.add(1,"item2");
		myItemsOutpost.add(2,"item3");
		myItemsOutpost.add(3,"item4");
		myItemsOutpost.add(4,"item5");

		myItemsCrew = new DefaultListModel();
		listCrewInventory = new JList(myItemsCrew); //data has type Object[]
		listCrewInventory.setLocation(392, 0);
		listCrewInventory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listCrewInventory.setLayoutOrientation(JList.VERTICAL);
		listCrewInventory.setVisibleRowCount(-1); 
		scrollPaneCrewInventory = new JScrollPane(listCrewInventory);
		scrollPaneCrewInventory.setVisible(false);
		scrollPaneCrewInventory.setBounds(350, 70, 200, 120);
		contentPane.add(scrollPaneCrewInventory);
		
		lbl_CrewInventory = new JLabel("Crew Inventory");
		lbl_CrewInventory.setVisible(false);
		
		lbl_CrewInventory.setForeground(Color.WHITE);
		lbl_CrewInventory.setBounds(411, 47, 92, 13);
		contentPane.add(lbl_CrewInventory);
		
		btn_sell = new JButton("Sell");
		btn_sell.setVisible(false);
		
		btn_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strSell = myItemsCrew.getElementAt(listCrewInventory.getSelectedIndex()).toString();
				myItemsCrew.removeElementAt(listCrewInventory.getSelectedIndex());
				myItemsOutpost.add(myItemsOutpost.size(), strSell);
			}
		});
		btn_sell.setBounds(403, 201, 89, 23);
		contentPane.add(btn_sell);
		
		lbl_OutpostInventory = new JLabel("Outpost Inventory");
		lbl_OutpostInventory.setVisible(false);
		
		lbl_OutpostInventory.setForeground(Color.WHITE);
		lbl_OutpostInventory.setBounds(645, 47, 106, 12);
		contentPane.add(lbl_OutpostInventory);
		
		btn_buy = new JButton("Buy");
		btn_buy.setVisible(false);
		
		btn_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strBuy = myItemsOutpost.getElementAt(listOutpostInventory.getSelectedIndex()).toString();
				myItemsOutpost.removeElementAt(listOutpostInventory.getSelectedIndex());
				myItemsCrew.add(myItemsCrew.size(), strBuy);
			}
		});
		btn_buy.setBounds(648, 201, 89, 23);
		contentPane.add(btn_buy);
		
		
		 //data has type Object[]
		listOutpostInventory.setLocation(392, 0);
		listOutpostInventory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listOutpostInventory.setLayoutOrientation(JList.VERTICAL);
		listOutpostInventory.setVisibleRowCount(-1); 
		scrollPaneOutpostInventory = new JScrollPane(listOutpostInventory);
		scrollPaneOutpostInventory.setVisible(false);
		scrollPaneOutpostInventory.setBounds(600, 70, 200, 120);
		contentPane.add(scrollPaneOutpostInventory);
		
		btn_LeaveOutpost = new JButton("Leave Outpost");
		btn_LeaveOutpost.setVisible(false);
		btn_LeaveOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisibilityOutpostMenue(false);
				setVisibilityMainMenue(true);
			}
		});
		btn_LeaveOutpost.setBounds(506, 16, 125, 23);
		contentPane.add(btn_LeaveOutpost);
		lbl_background = new JLabel("");
		lbl_background.setForeground(Color.WHITE);
		lbl_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/space_moon.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
		lbl_background.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lbl_background);
	}
	
	public void setVisibilityMainMenue(boolean bFlag)
	{
		lbl_chooseAction.setVisible(bFlag);
		lbl_ShowCrewStatus.setVisible(bFlag);
		lbl_ShowSpaceShipStatus.setVisible(bFlag);
		lbl_VisitOutpost.setVisible(bFlag);
		lbl_DoCrewAction.setVisible(bFlag);
		lbl_MoveToNextDay.setVisible(bFlag);
		lbl_Selector.setVisible(bFlag);
	}
	
	public void setVisibilityOutpostMenue(boolean bFlag)
	{
		lbl_CrewInventory.setVisible(bFlag);
		lbl_OutpostInventory.setVisible(bFlag);
		scrollPaneCrewInventory.setVisible(bFlag);
		scrollPaneOutpostInventory.setVisible(bFlag);
		btn_buy.setVisible(bFlag);
		btn_sell.setVisible(bFlag);
		btn_LeaveOutpost.setVisible(bFlag);
		if(bFlag)
			lbl_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/space_outpost.jpg")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
		else
			lbl_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/space_moon.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
	}
}

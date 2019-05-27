package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.StartGame;

import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractListModel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.awt.Font;

public class ItemPickerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList listItems;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemPickerDialog dialog = new ItemPickerDialog(args);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemPickerDialog(String[] args) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				StartGame.m_stringInputGUI = args[0];
				StartGame.m_stringInputReadyGUI = true;
				setModal(false);
				dispose();
			}
		});
		setTitle("Item use");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemPickerDialog.class.getResource("/graphics/game_icon_sun.png")));
		setResizable(false);
		setBounds(100, 100, 320, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPaneItems = new JScrollPane();
			scrollPaneItems.setBounds(28,23,258,130);
			contentPanel.add(scrollPaneItems);
			
			listItems = new JList();
			listItems.setFont(new Font("Snap ITC", Font.PLAIN, 10));
			listItems.setModel(new AbstractListModel() {
				String[] strValues = Arrays.copyOfRange(args, 1, args.length);
				String[] values =  strValues;
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			listItems.setSelectedIndex(0);
			listItems.setForeground(Color.WHITE);
			listItems.setBackground(Color.BLUE);
			scrollPaneItems.setViewportView(listItems);
		}
		
		JButton btn_UseItem = new JButton("Use selected Item");
		btn_UseItem.setForeground(Color.BLACK);
		btn_UseItem.setFont(new Font("Snap ITC", Font.PLAIN, 10));
		btn_UseItem.setBackground(Color.BLUE);
		btn_UseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartGame.m_stringInputGUI = Integer.toString(listItems.getSelectedIndex());
				StartGame.m_stringInputReadyGUI = true;
				while(!StartGame.m_stringInputReadyLogic)
				{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-#generated catch block
						e.printStackTrace();
					}
				}
				StartGame.m_stringInputReadyLogic = false;
				dispose();
			}
		});
		btn_UseItem.setBounds(77, 164, 160, 30);
		contentPanel.add(btn_UseItem);
	}
}

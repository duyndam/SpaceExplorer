package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Color;

public class StartFrame extends JFrame {

	private JPanel contentPane;
	private BufferedImage myImage;
	private ImagePanel myPanel;
	private BufferedImage iconImage;
	
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
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		try {
			myImage = ImageIO.read(new File("src//gui//background_main.png"));
			iconImage = ImageIO.read(new File("src//gui//game_icon_sun.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		myPanel = new ImagePanel(myImage);
		myPanel.setBounds(contentPane.getBounds());
		this.setIconImage(iconImage);
		setContentPane(myPanel);
	}

}

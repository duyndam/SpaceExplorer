package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImageAnimationPanel extends JPanel{
	 Image image;
	 Point pos;

	  public ImageAnimationPanel(String strImagepath,Point pos) {
	    image = Toolkit.getDefaultToolkit().createImage(strImagepath);
	    this.pos = pos;
	  }
	  
	  public void setPos(Point newPos)
	  {
		  pos = newPos;
	  }
	  

	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (image != null) {
	      g.drawImage(image, pos.x,pos.y, this);
	    }
	  }
}

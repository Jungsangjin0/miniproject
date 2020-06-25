package miniproject.views.mainMap;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Door extends JLabel {
		public void paintComponent(Graphics g) {
		ImageIcon d = new ImageIcon("src/miniproject/images/mainMap/pad.png");

		g.drawImage(d.getImage(), 0, 0, 500, 900, null);
		//			Point p = scrollPane.getViewport().getViewPosition();
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
		
			}
		
		
	}
